package be.kiop.gameboard;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import be.kiop.characters.heroes.Warrior;

public class Board extends JPanel{

	private Map map;
	private int width;
	private int height;
	
	private Warrior hero;
	
	public Board(Map map, int width, int height) {
		this.map = map;
		this.width = width;
		this.height = height;
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(map.getImage(), 0, 0, width, height, 0, 0, width, height, this);
		g2d.drawImage(hero.getSkin(), 250, 250, 250+24*3, 250+32*3, 24, 32, 24+24, 32+32, this);
	}
	
	public void setHero(Warrior hero) {
		this.hero = hero;
	}
	
	public Warrior getHero() {
		return this.hero;
	}
}
