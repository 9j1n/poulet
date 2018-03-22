package be.kiop.characters.foes;

import java.util.ArrayList;
import java.util.Set;

import be.kiop.characters.GameCharacter;
import be.kiop.items.Item;
import be.kiop.weapons.Weapon;
import be.kiop.weapons.Weapons;

public class Foe extends GameCharacter {
	
	private String name;
	private float health;
	private Weapon weapon;
	private ArrayList<Item> drops;
	
	public Foe(String name, float health, Weapon weapon, ArrayList<Item> drops, Set<Weapons> availableWeapons, int level, float armor) {
		super(name, health, weapon, availableWeapons, level, armor);
		this.drops = drops;
	}
	
	public Item drop(ArrayList<Item> drops) {
		return weapon;
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

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public ArrayList<Item> getDrops() {
		return drops;
	}

	public void setDrops(ArrayList<Item> drops) {
		this.drops = drops;
	}
}
