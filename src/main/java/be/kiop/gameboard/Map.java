package be.kiop.gameboard;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Map extends JPanel{
	
	private int width;
	private int height;
	private String name;
	private String imagePath;
	

	private Image image;
	private ArrayList<Obstacle> obstacles;
	
	public Map(int width, int height, String imagePath) {
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
		
		this.obstacles = new ArrayList<Obstacle>();
		
		try {
			this.image = ImageIO.read(new File(imagePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public void createObstacle(int xPos, int yPos, int xSprite, int ySprite, int width, int height, String imagePath) {
		this.obstacles.add(new Obstacle(xPos, yPos, xSprite, ySprite, width, height, imagePath));
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
