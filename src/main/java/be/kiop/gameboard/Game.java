package be.kiop.gameboard;

import javax.swing.JFrame;

import be.kiop.characters.heroes.Hero;
import be.kiop.characters.heroes.Warrior;
import be.kiop.weapons.Sword;
import be.kiop.weapons.Weapon;

public class Game extends JFrame {
	
	private String name;
	
	private Map map;
	private Board board;
	
	private Warrior herc = new Warrior("Herc", 100, new Sword(), 1, 10, 9, 12345, 10, "src/main/resources/hero.png");
	
	public Game(String name){
		this.name = name;
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 680);
		this.setResizable(false);
		
		map = new Map(640, 640, "src/main/resources/map.png");
		board = new Board(map, 640, 640);
		
		board.setHero(herc);
		
		this.setContentPane(board);
	}
}