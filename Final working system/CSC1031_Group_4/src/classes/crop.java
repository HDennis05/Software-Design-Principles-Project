package classes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class crop {

	private int cropID;
	private String name;
	private int shelfLife; // days
	private int lengthOfGrowth; // how many days it takes to grow
	private int waterCheckUp; // the amount of time a plant needs before needing watered again

	/**
	 * Crop constructor
	 * @param cropID
	 * @param name - name of crop
	 * @param shelfLife - days it will last in a refrigerator
	 * @param lengthOfGrowth - how long it takes to grow
	 * @param waterCheckUp - how long before it needs watered again
	 */
	public crop(int cropID, String name, int shelfLife, int lengthOfGrowth,  int waterCheckUp) {
		this.cropID = cropID;
		this.name = name;
		this.shelfLife = shelfLife;
		this.lengthOfGrowth = lengthOfGrowth;
		this.waterCheckUp = waterCheckUp;
	}

	public int getCropID() {
		return this.cropID;
	}

	public void setId(int cropID) throws Exception {
		if (cropID >= 0)
			this.cropID = cropID;
		else
			throw new Exception("Invalid input: cropID must be positive");
	}

	public String getName() {
		return this.name;
	}
	public void setName(String newName) throws Exception {
		if (newName == null || newName.equals("") || newName.trim().equals("")) {
			throw new Exception("Invalid String input");
		} else
			this.name = newName;
	}

	public int getShelfLife() {
		return this.shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public int getGrowthLength() {
		return lengthOfGrowth;
	}
/*
 * this will set the duration of growth
 */
	public void setGrowthLength(int lengthOfGrowth) throws Exception {
		if (lengthOfGrowth >= 0 && lengthOfGrowth <= 100)
			this.lengthOfGrowth = lengthOfGrowth;
		else
			throw new Exception("Invalid input");
	}


	public int getWaterCheckUp() {
		return waterCheckUp;
	}

	public void setWaterCheckUp(int waterCheckUp) {
		this.waterCheckUp = waterCheckUp;
	}
/*
 * this will display all crops
 */
	public String toString() {
		return "Name: " + getName() + "(" + getCropID() + ")";
	}
	
}
