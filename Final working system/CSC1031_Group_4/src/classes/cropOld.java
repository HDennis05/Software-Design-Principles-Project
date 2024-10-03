package classes;

import java.io.IOException;

public class cropOld {
	// attributes needed: id, name, shelf-life, growth, water level,
	// methods needed: getters + setters, 'others'

	private int id;
	private String name;
	private int shelfLife; // months
	private int growth; // %to harvest
	private int waterLevel; // %water level
	private int waterCheckUp; // the amount of time a plant needs before needing watered again


	public cropOld(int id, String name, int shelfLife, int growth, int waterLevel, int waterCheckUp) {
		this.id = id;
		this.name = name;
		this.growth = growth;
		this.shelfLife = shelfLife;
		this.waterLevel = waterLevel;
		this.waterCheckUp = waterCheckUp;
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(int waterLevel) throws Exception {
		if (waterLevel >= 0 && waterLevel <= 100)
			this.waterLevel = waterLevel;
		else
			throw new Exception("Invalid input");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if (id >= 0)
			this.id = id;
		else
			throw new Exception("Invalid input");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) throws Exception {
		if (newName == null || newName.equals("") || newName.trim().equals("")) {
			throw new Exception("Invalid String input");
		} else
			this.name = newName;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) throws Exception {
		if (growth >= 0 && growth <= 100)
			this.growth = growth;
		else
			throw new Exception("Invalid input");
	}
/*
 * this will display all crops
 */
	public String toString() {
		return "Name: " + getName() + "(" + (getId() + 1) + ")";
	}
/*
 * this will return the growth details of all crops
 */
	public String returnGrowth() {
		return "Name: " + getName() + "(" + (getId() + 1) + ")" + "\n" + "\t" + "Growth of crop: " + getGrowth() + "%";
	}
/*
 * this will return the water details of all crops
 */
	public String returnWaterDetails() {
		return "Name: " + getName() + "(" + (getId() + 1) + ")" + "\n" + "\t" + "Water level :" + getWaterLevel() + "%"
				+ "\n" + "\t" + "This crop needs to be watered every: " + getWaterCheckUp() + " days" + "\n" + "\t";
	}

	public int getWaterCheckUp() {
		return waterCheckUp;
	}

	public void setWaterCheckUp(int waterCheckUp) {
		this.waterCheckUp = waterCheckUp;
	}

	public void water_Crop(int id) {
		if (id == this.id)
			try {
				this.setWaterLevel(100);
			} catch (Exception e) {
			}
	}
}
