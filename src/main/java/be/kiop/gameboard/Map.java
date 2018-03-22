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
		
		try {
			this.image = ImageIO.read(new File(imagePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
