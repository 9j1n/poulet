package be.kiop.gameboard;

import java.awt.Image;

public class Obstacle {
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private String imagePath;
	private Image image;
	
	public Obstacle(int xPos, int yPos, int width, int height, String imagePath) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
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
