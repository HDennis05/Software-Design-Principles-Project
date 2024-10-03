package classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class plot {

	private int plotID;
	private crop crop;
	private LocalDate datePlanted;
	private LocalDate nextWaterDate; // %water level

	/**
	 * plot constructor
	 * 
	 * @param id   - plot id
	 * @param crop - crop planted (null for empty plot)
	 * @throws Exception
	 */
	public plot(int id, crop crop) throws Exception {
		setPlotID(id);
		if (crop != null) {
			setCrop(crop);
			setDatePlanted(LocalDate.now());
			waterPlot();
		} else {
			harvestCrop();
		}
	}

	/**
	 * plot constructor variation
	 * 
	 * @param id   - plot id
	 * @param crop - crop planted's ID (-1 for empty plot)
	 * @throws Exception
	 */
	public plot(int id, int cropID) throws Exception {
		setPlotID(id);
		if (cropID != -1) {
			setCrop(cropID);
			setDatePlanted(LocalDate.now());
			waterPlot();
		} else {
			harvestCrop();
		}
	}

	/**
	 * plot constructor variation from file
	 * 
	 * @param id   - plot id
	 * @param crop - crop planted's ID (-1 for empty plot)
	 * @throws Exception
	 */
	public plot(int id, int cropID, LocalDate datePlanted, LocalDate nextWaterDate) throws Exception {
		setPlotID(id);
		if (cropID != -1) {
			setCrop(cropID);
			setDatePlanted(datePlanted);
			setNextWaterDate(nextWaterDate);
		} else {
			harvestCrop();
		}
	}

	// Setters and Getters
	public int getPlotID() {
		return this.plotID;
	}

	public void setPlotID(int plotID) throws Exception {

		if (plotID < 0) {
			throw new Exception("Invalid input: plotID must be positive");
		}

		this.plotID = plotID;
	}

	public crop getCrop() {
		return this.crop;
	}

	public void setCrop(int cropID) throws Exception {
		boolean found = false;
		crop crop = null;
		ArrayList<crop> crops = FileAccess.importCrops(true);
		for (crop everyCrop : crops) {
			if (everyCrop.getCropID() == cropID) {
				found = true;
				crop = everyCrop;
			}
		}
		if (found == false) {
			throw new Exception("Crop not found");
		}

		this.crop = crop;
	}

	public void setCrop(crop crop) throws Exception {
		this.crop = crop;
	}

	public LocalDate getDatePlanted() {
		return this.datePlanted;
	}

	public void setDatePlanted(LocalDate datePlanted) throws Exception {
		if (datePlanted.isAfter(LocalDate.now())) {
			throw new Exception("Invalid input: date must be today or earlier");
		} else {
			this.datePlanted = datePlanted;
		}
	}

	public LocalDate getNextWaterDate() {
		return this.nextWaterDate;
	}

	public void setNextWaterDate(LocalDate nextWaterDate) {
		this.nextWaterDate = nextWaterDate;
	}

	// other methods
	/**
	 * Waters crop in plot
	 * 
	 * @throws Exception
	 */
	public void waterPlot() throws Exception {
		if (crop == null) {
			throw new Exception("No crop to water");
		}
		int waterCheckup = this.crop.getWaterCheckUp();
		this.nextWaterDate = LocalDate.now().plusDays(waterCheckup);

	}

	/**
	 * Sets crop (with id), datePlanted and nextWaterDate
	 * 
	 * @param cropID - ID for crop
	 * @throws Exception
	 */
	public void plantCrop(int cropID) throws Exception {
		try {
			setCrop(cropID);
			setDatePlanted(LocalDate.now());
			waterPlot();
		} catch (Exception e) {
			throw new Exception("Crop doesn't exist");
		}
	}

	/**
	 * Sets crop, datePlanted and nextWaterDate
	 * 
	 * @param crop - crop to be planted
	 * @throws Exception
	 */
	public void plantCrop(crop crop) throws Exception {
		try {
			setCrop(crop);
			setDatePlanted(LocalDate.now());
			waterPlot();
		} catch (Exception e) {
			throw new Exception("Crop doesn't exist");
		}
	}

	/**
	 * Removes crop from plot. Sets all crop related fields to null
	 */
	public void harvestCrop() {
		this.datePlanted = null;
		this.crop = null;
		this.nextWaterDate = null;
	}

	/**
	 * Returns days between current date and when it needs watered 0 if it needs
	 * watered today and negative if watering was missed
	 * 
	 * @return
	 */
	public int getWaterDays() {
		Period timePeriod = Period.between(this.nextWaterDate, LocalDate.now());
		return timePeriod.getDays();
	}

	/**
	 * Returns days between current date and when it needs harvested 0 if it needs
	 * harvested today and negative if harvest was missed
	 * 
	 * @return
	 */
	public int getGrowthDays() {
		LocalDate dateGrown = this.datePlanted.plusDays(this.crop.getGrowthLength());
		Period timePeriod = Period.between(dateGrown, LocalDate.now());
		return timePeriod.getDays();

	}

	public String toString() {
		return "Plot " + getPlotID() + "(" + getCrop().getName() + ")";
	}

	public String displayInfo() {
		String string = "PlotID: " + getPlotID() + "\nCrop: " + getCrop().getName() + "\nDate Planted: "
				+ getDatePlanted();
		if (getGrowthDays() == 0) {
			string += "\nCrop is ready for harvest!";
			return string;
		}
		if (getGrowthDays() > 0) {
			string += "Harvest in: " + getGrowthDays() + " days";
			if (getWaterDays() < getGrowthDays()) {
				if (getWaterDays() == 0) {
					string += "Water today!";
				}
				if (getWaterDays() < 0) {
					string += "Needed watered " + (getWaterDays() * -1) + " days ago!";
				}
				if (getWaterDays() < 0) {
					string += "Water in: " + getWaterDays() + " days";
				}
			}
			return string;
		}
		string += "Needed harvested " + (getGrowthDays() * -1) + " days ago!";
		return string;
	}
}
