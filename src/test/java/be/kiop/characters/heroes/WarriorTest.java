package be.kiop.characters.heroes;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import be.kiop.characters.GameCharacter;
import be.kiop.exceptions.CharacterDiedException;
import be.kiop.exceptions.IllegalWeaponException;
import be.kiop.exceptions.MaxLevelReachedException;
import be.kiop.exceptions.MinLevelReachedException;
import be.kiop.exceptions.OutOfLivesException;
import be.kiop.weapons.Fist;
import be.kiop.weapons.Staff;
import be.kiop.weapons.Sword;

public class WarriorTest {
	private Warrior hero;
	private Sword sword;
	
	private final static float MARGIN = 0.1F;
	
	private final static String HERO_NAME = "Warrior";
	private final static float HERO_HEALTH = 100;
	private final static int HERO_LEVEL = 10;
	private final static int HERO_LIVES = 5;
	private final static float HERO_ARMOR = 50;
	private final static float HERO_EXPERIENCE = 200;
	private final static float HERO_SHIELD = 10;
	private final static String HERO_SKIN_PATH = "src/main/resources/hero.png";
	
	@Before
	public void before() {
		sword = new Sword();
		hero = new Warrior(HERO_NAME, HERO_HEALTH, sword, HERO_LEVEL, HERO_ARMOR, HERO_LIVES, HERO_EXPERIENCE, HERO_SHIELD, HERO_SKIN_PATH);
	}
	
	@Test
	public void getName_nA_heroName() {
		assert(hero.getName().equals(HERO_NAME));
	}
	
	@Test
	public void getHealth_nA_heroHealth() {
		assertEquals(HERO_HEALTH, hero.getHealth(),MARGIN);
	}
	
	@Test(expected=CharacterDiedException.class)
	public void takeFlatDamage_moreThanHeroHealth_Exception() {
		hero.takeFlatDamage(HERO_HEALTH+1);
	}
	
	@Test
	public void takeFlatDamage_lessThanHeroHealth_remainingHealth() {
		hero.takeFlatDamage(HERO_HEALTH-1);
		assertEquals(1, hero.getHealth(), MARGIN);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void takeFlatDamage_negativeAmount_Exception() {
		hero.takeFlatDamage(-1);
	}
		
	@Test(expected=CharacterDiedException.class)
	public void takeDamage_moreThanHeroHealth_Exception() {
		hero.takeDamage(HERO_HEALTH*100/HERO_ARMOR+HERO_HEALTH);
	}
	
	@Test
	public void takeDamage_lessThanHeroShield_remainingHealth() {
		hero.takeDamage(HERO_SHIELD);
		assertEquals(HERO_HEALTH, hero.getHealth(), MARGIN);
	}
	
	@Test
	public void takeDamage_lessThanHeroHealth_remainingHealth() {
		hero.takeDamage(HERO_SHIELD+HERO_HEALTH);
		assertEquals(HERO_HEALTH*HERO_ARMOR/100, hero.getHealth(), MARGIN);
		
		//HERO_HEALTH-(HERO_HEALTH*(1-HERO_ARMOR/100))
		//HERO_HEALTH(1-(1-HERO_ARMOR/100))
		//HERO_HEALTH(HERO_ARMOR/100)
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void takeDamage_negativeAmount_Exception() {
		hero.takeDamage(-1);
	}
	
	@Test(expected=CharacterDiedException.class)
	public void takeDamage_moreThanHeroLifeAndPenetration_Exception() {
		hero.takeDamage(HERO_HEALTH, HERO_ARMOR+1);
	}
	
	@Test
	public void takeDamage_lessThanHeroLifeAndPenetration_remainingHealth() {
		hero.takeDamage(HERO_HEALTH-1, HERO_ARMOR);
		assertEquals(1, hero.getHealth(), MARGIN);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void takeDamage_negativeDamageAndPositivePenetration_Exception() {
		hero.takeDamage(-1, HERO_HEALTH/2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void takeDamage_positiveDamageAndNegativePenetration_Exception() {
		hero.takeDamage(1, -HERO_HEALTH/2);
	}
	
	@Test
	public void heal_moreThanHeroLife_maxHealth() {
		hero.heal(hero.getMaxHealth()+1);
		assertEquals(hero.getMaxHealth(), hero.getHealth(), MARGIN);
	}
	
	@Test
	public void heal_lessThanHeroLife_heroHealth() {
		hero.heal(1);
		assertEquals(HERO_HEALTH+1, hero.getHealth(), MARGIN);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void heal_negativeAmount_Exception() {
		hero.heal(-1);
	}
	
	@Test
	public void getWeapon_nA_heroWeapon() {
		assertEquals(sword , hero.getWeapon());
	}
	
	@Test
	public void changeWeapon_validWeapon_heroWeapon() {
		hero.changeWeapon(new Fist());
		assertEquals(new Fist(), hero.getWeapon());
	}
	
	@Test(expected=IllegalWeaponException.class)
	public void changeWeapon_invalidWeapon_exception() {
		hero.changeWeapon(new Staff());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void changeWeapon_nullWeapon_exception() {
		hero.changeWeapon(null);
	}
	
	@Test
	public void dropWeapon_nA_fist() {
		hero.dropWeapon();
		assertEquals(new Fist(), hero.getWeapon());
	}
	
	@Test
	public void getLevel_nA_heroLevel() {
		assertEquals(HERO_LEVEL, hero.getLevel());
	}
	
	@Test
	public void increaseLevel_nA_heroLevelIncreased() {
		hero.increaseLevel();
		assertEquals(HERO_LEVEL+1, hero.getLevel());
	}
	
	@Test(expected=MaxLevelReachedException.class)
	public void increaseLevel_moreThanMaxLevel_exception() {
		IntStream.range(0, GameCharacter.MAX_LEVEL+1).forEach(val -> hero.increaseLevel());
	}
	
	@Test
	public void decreaseLevel_nA_heroLevelDecreased() {
		hero.decreaseLevel();
		assertEquals(HERO_LEVEL-1, hero.getLevel());
	}
	
	@Test(expected=MinLevelReachedException.class)
	public void decreaseLevel_lessThanMinLevel_exception() {
		IntStream.range(0, GameCharacter.MAX_LEVEL+1).forEach(val -> hero.decreaseLevel());
	}
	
	@Test
	public void getLives_nA_heroLives() {
		assertEquals(HERO_LIVES, hero.getLives());
	}
	
	@Test
	public void increaseLives_nA_heroLivesIncremented() {
		hero.increaseLives();
		assertEquals(HERO_LIVES+1, hero.getLives());
	}
	
	@Test
	public void decreaseLives_nA_heroLivesDecreased() {
		hero.decreaseLives();
		assertEquals(HERO_LIVES-1, hero.getLives());
	}
	
	@Test(expected=OutOfLivesException.class)
	public void decreaseLives_nA_exception() {
		IntStream.range(0, HERO_LIVES+1).forEach(val -> hero.decreaseLives());
	}
	
	@Test
	public void getExperience_nA_heroExperience() {
		assertEquals(HERO_EXPERIENCE, hero.getExperience(), MARGIN);
	}
	
	@Test
	public void increaseExperience_notEnoughForNewLevel_heroExperienceIncreased() {
		hero.increaseExperience(HERO_LEVEL*100-HERO_EXPERIENCE-1);
		assertEquals(HERO_LEVEL*100-1, hero.getExperience(), MARGIN);
	}
	
	@Test
	public void increaseExperience_enoughForTwoNewLevels_heroExperienceIncreased() {
		hero.increaseExperience((2*HERO_LEVEL+1)*100);
		assertEquals(HERO_EXPERIENCE, hero.getExperience(), MARGIN);
		assertEquals(HERO_LEVEL+2, hero.getLevel());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void increaseExperience_negativeAmount_exception() {
		hero.increaseExperience(-1);
	}
	
	@Test
	public void getShield_nA_heroShield() {
		assertEquals(HERO_SHIELD, hero.getShield(), MARGIN);
	}
	
}
