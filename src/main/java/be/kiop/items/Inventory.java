package be.kiop.items;

import java.util.ArrayList;

public class Inventory extends ArrayList<Item>{

	private int maxSize;
	
	public Inventory(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
}
