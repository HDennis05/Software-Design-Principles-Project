package classes;

import java.util.ArrayList;

/**
 * Author: Adam Greeran Student Number: 40411908
 * 
 * Plot Owner class used to create, show and edit a PlotOwner object
 */

public class plotOwner extends BasicUser {
	private ArrayList<plot> plots;

	/**
	 * 
	 * @param name
	 * @param password
	 * @param phoneNo
	 * @param email
	 * @param plots
	 * @throws Exception
	 */
	public plotOwner(int userID, String name, String password, String phoneNo, String email, boolean banned,
			ArrayList<plot> plots) throws Exception {
		super(userID, name, password, phoneNo, email, banned);
		// boolean is used to check if the input data is valid
		boolean correctPlots = setPlots(plots);
		// if any input is invalid, exception will throw showing invalid input
		if (correctPlots == false) {
			throw new Exception("Invalid Plots");
		}
	}

	// Getters and Setters
	public ArrayList<plot> getPlots() {
		return this.plots;
	}

	public boolean setPlots(ArrayList<plot> Plots) {
		if (!Plots.isEmpty()) {
			this.plots = Plots;
			return true;
		} else {
			return false;
		}
	}

	// used to add plots that are assigned to this owner
	public void addPlots(ArrayList<plot> Plots) {
		ArrayList<plot> currentPlots = getPlots();
		for (plot everyPlot : Plots) {
			currentPlots.add(everyPlot);
		}
		this.plots = currentPlots;
	}

	// used to remove plots that are unassigned to this owner
	public void removePlots(ArrayList<plot> Plots) {
		ArrayList<plot> currentPlots = getPlots();
		for (plot everyPlot : currentPlots) {
			if (Plots.contains(everyPlot)) {
				currentPlots.remove(everyPlot);
			}
		}
		this.plots = currentPlots;
	}

	/**
	 * to string method to display the data of the plot owner
	 * uses the super toString to reduce length
	 */
	public String toString() {
		String plotOwner = "";
		plotOwner += super.toString();
		plotOwner += "\nPlots:\n";
		for (int i = 0; i < getPlots().size(); i++) {
			plotOwner += "\t" + (i + 1) + ": " + getPlots().get(i) + "\n";
		}
		return plotOwner;
	}
}
