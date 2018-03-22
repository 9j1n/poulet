package be.kiop.characters;

import java.util.Set;

import be.kiop.weapons.Weapon;
import be.kiop.weapons.Weapons;

public abstract class GameCharacter {

	private String name;
	private float health;
	private float maxHealth;
	protected int level;
	private float armor;
	private Set<Weapons> availableWeapons;
	
	public GameCharacter(String name, float health, Weapon weapon, Set<Weapons> availableWeapons, int level, float armor){
		this.name = name;
		this.health = health;
		this.weapon = weapon;
		this.availableWeapons = availableWeapons;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHealth() {
		return health;
	}
	public void setHealth(float health) {
		this.health = health;
	}
	public float getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(float maxHealth) {
		this.maxHealth = maxHealth;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	private Weapon weapon;

	public void takeDamage(float damage) {
		
		
	}
	
	protected void increaseLevel() {
		
	}
	
}
