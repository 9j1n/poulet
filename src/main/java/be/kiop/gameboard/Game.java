package be.kiop.gameboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
		
		map.createObstacle(0, 0, 0, 0, 640, 10, "src/main/resources/border.png");
		map.createObstacle(0, 0, 0, 0, 10, 640, "src/main/resources/border.png");
		map.createObstacle(0, 640, 0, 0, 640, 10, "src/main/resources/border.png");
		map.createObstacle(640, 0, 0, 0, 10, 640, "src/main/resources/border.png");
		
		board.setHero(herc);
		
		this.setContentPane(board);
	}
	
	class keyboardLst implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
