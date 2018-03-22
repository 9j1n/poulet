package be.kiop.gameboard;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacle {
	
	private int xPos;
	private int yPos;
	private int xSprite;
	private int ySprite;
	private int width;
	private int height;
	private String imagePath;
	private Image image;
	
	public Obstacle(int xPos, int yPos,int xSprite, int ySprite, int width, int height, String imagePath) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSprite = xSprite;
		this.ySprite = ySprite;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
		
		try {
			image = ImageIO.read(new File(this.imagePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxSprite() {
		return xSprite;
	}

	public void setxSprite(int xSprite) {
		this.xSprite = xSprite;
	}

	public int getySprite() {
		return ySprite;
	}

	public void setySprite(int ySprite) {
		this.ySprite = ySprite;
	}

	public Image getImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
