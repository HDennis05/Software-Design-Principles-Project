package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import classes.FileAccess;
import classes.Menu;
import classes.admin;
import classes.plotOwner;
import classes.crop;
import classes.plot;

public class CommunityGardens {
	static Scanner input = new Scanner(System.in); // scanner for user inputs
	static plotOwner[] owners = new plotOwner[5];
	private static ArrayList<plot> plots;

	public static void main(String[] args) {
		plots = new ArrayList<plot>();
		plots.add(null);
		try {
			// dummy data for testing purposes instead of pulling from files
			plotOwner a = new plotOwner(1, "Adam", "Password1", "07482047562", "adam123@gmail.com", false, plots);
			plotOwner b = new plotOwner(2, "Simon", "Password2", "07482047562", "simon456@gmail.com", false, plots);
			plotOwner c = new plotOwner(3, "Hannah", "Password3", "07482047562", "hannah789@gmail.com", false, plots);
			plotOwner d = new plotOwner(3, "Peter", "Password4", "07482047562", "peter012@gmail.com", false, plots);
			plotOwner e = new plotOwner(4, "Luke", "Password5", "07482047562", "luke345@gmail.com", false, plots);
			owners[0] = a;
			owners[1] = b;
			owners[2] = c;
			owners[3] = d;
			owners[4] = e;
		} catch (Exception e) {
			System.out.println(e);
		}
		String options[] = { "Login", "Exit" };
		Menu homeMenu = new Menu("--------Home Menu--------", options);
		boolean finished = false;
		do {
			int option = homeMenu.getUserChoice(options.length);
			switch (option) {
			case 1:
				login();
				break;
			case 2:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished); // will continue until the user exits
		System.out.println("Goodbye!");
		input.close();
	}

	public static void adminMenu() {
		String options[] = { "View Users", "Add User", "Ban User", "Approve Supplies", "Logout" };
		Menu mainMenu = new Menu("--------Admin Menu--------", options);
		boolean finished = false;
		do {
			int option = mainMenu.getUserChoice(options.length);
			switch (option) {
			case 1:
				try {
					System.out.println("View Users:");
					ArrayList<plotOwner> plotOwners = FileAccess.importPlotOwners(true);
					if (plotOwners != null && !plotOwners.isEmpty()) {
						for (plotOwner owner : plotOwners) {

							System.out.println(owner);
						}
					} else {
						System.out.println("No plot owners found.");
					}
				} catch (Exception e) {
					System.out.println("An error occurred while trying to read plot owners: " + e.getMessage());
				}
				break;
			case 2:
				admin.addUser();
				break;
			case 3:
				System.out.println("Ban user is currently under development\n");
				break;
			case 4:
				System.out.println("Approve supplies is currently under development\n");
				break;
			case 5:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished); // will continue until the user exits
	}

	public static void userMenu() {
		String options[] = { "Crop Menu", "Supply Management", "Logout" };
		Menu mainMenu = new Menu("--------User Menu--------", options);
		boolean finished = false;
		do {
			int option = mainMenu.getUserChoice(options.length);
			switch (option) {
			case 1:
				// System.out.println("Crop Menu is currently under development\n");
				try {
					cropMenu();
				} catch (IOException e) {
				}
				break;
			case 2:
				System.out.println("Supply Management is currently under development\n");
				// createPlotOwner()
				break;
			case 3:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished); // will continue until the user exits
	}

	// -- will be looked at in sprint 2
	// ------------------------------------------------------\\
//	public static void createPlotOwner() {
//		boolean correct;
//		do {
//			System.out.println("Please input the plot owner's name: ");
//			String name = input.nextLine();
//			System.out.println("Please input a password: ");
//			String password = input.nextLine();
//			System.out.println("Please input the plot owner's phone number");
//			String phoneNo = input.nextLine();
//			System.out.println("Please input the plot owner's Email address");
//			String email = input.nextLine();
//			try {
//				PlotOwner a = new PlotOwner(name, password, phoneNo, email);
//				correct = true;
//			} catch (Exception ex) {
//				System.out.println(ex);
//				correct = false;
//			}
//		} while (!correct);
//	}
	// ------------------------------------------------------\\
	// -- will be looked at in sprint 2

	public static void login() {
		System.out.println("----------Login----------");
		System.out.print("Enter ID: ");
		String id = input.nextLine();
		System.out.print("Enter Password: ");
		String password = input.nextLine();

		// Check for admin credentials
		if (id.equals("admin") && password.equals("adminPass1")) {
			adminMenu(); // Redirect to admin menu if admin credentials are entered
		} else if (checkID(id, password)) {
			userMenu(); // Redirect to user menu if user credentials are valid
		} else {
			System.out.println("Invalid data\n"); // Display error if credentials are invalid
		}
	}

	private static boolean checkID(String id, String password) {
		for (int i = 0; i < owners.length; i++) { // ensures id is a digit
			for (int j = 0; j < id.length(); j++) {
				if (!Character.isDigit(id.charAt(j))) {
					return false;
				}
			}
			if (owners[i].getUserID() == Integer.parseInt(id)) { // checks for id in array of users
				if (owners[i].checkPassword(password)) {
					System.out.println("\nLogged in as " + owners[i].getName() + "\n");
					return true;
				}
			}
		}
		return false;
	}

	public static void viewUsers() {

	}

	/*
	 * the menu that will display the options for the crops will be finished in
	 * sprint 2
	 */
	public static void cropMenu() throws IOException {
		String options[] = { "View Crops", "View Crop Growth", "View Crop Water Level", "Plant crop", "Water crop",
				"Back" };
		Menu mainMenu = new Menu("Crop Menu", options);
		boolean finished = false;
		do {
			int option = mainMenu.getUserChoice(options.length);
			switch (option) {
			case 1:
				viewPlots();
				break;
			case 2:
				viewCropPlotGrowth();
				break;
			case 3:
				viewCropPlotLevel();
				break;
			case 4:
				plantCrop();
				break;
			case 5:
				waterCrop();
				break;
			case 6:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished); // will continue until the user exits
	}

//	/**
//	 * for the admin to create new crops
//	 * @throws IOException 
//	 */
//	public static void createCrop() throws IOException {
//		boolean correct;
//		do {
//			ArrayList<crop> cropsList = FileAccess.importCrops(true);
//			int id = cropsList.get(cropsList.size() -1).getId() + 1;
//			System.out.println("Please input the name of the crop: ");
//			String name = input.nextLine();
//			System.out.println("Please input the shelf life of the crop: ");
//			int shelfLife = input.nextInt();
//			System.out.println("Please input the growth of the crop: ");
//			int growth = input.nextInt();
//			System.out.println("Please input the water level of the crop: ");
//			int waterLevel = input.nextInt();
//			System.out.println("Please input the water check up of the crop(days): ");
//			int checkUp = input.nextInt();
//			try {
//				crop a = new crop(id, name, shelfLife, growth, waterLevel, checkUp);
//				cropsList.add(a);
//				FileAccess.writeCrops(cropsList, true, false);
//				correct = true;
//			} catch (Exception ex) {
//				System.out.println(ex);
//				correct = false;
//			}
//		} while (!correct);
//	}

	public static void plotDisplay(ArrayList<plot> data, int option) {
		if (data == null || data.size() == 0) {
			System.out.println("\tNo Plots to display.");
		} else {
			if (option == 0) {
				System.out.println("List of Plots:\n");
				for (plot plot : data) {
					System.out.println(plot);
				}
			} else if (option == 1) {
				System.out.println("List of Crops:\n");
				for (plot plot : data) {
					LocalDate GrowthDate = LocalDate.now().plusDays(plot.getGrowthDays());
					if (plot.getGrowthDays() < 0) {
						System.out.println("Harvest Missed");
					} else {
						System.out.println("Harverst Date:" + GrowthDate);
					}
				}
			} else if (option == 2) {
				System.out.println("List of Crops:\n");
				for (plot plot : data) {
					LocalDate WaterDate = LocalDate.now().plusDays(plot.getWaterDays());
					if (plot.getWaterDays() < 0) {
						System.out.println("Plant has died");
					} else {
						System.out.println("Next water Date:" + WaterDate);
					}
				}
			}
			System.out.println();
		}
	}

	/**
	 * This is the method to display the desired crop data
	 * 
	 * @param data,  this is the crop data that is going to sorted through
	 * @param option this is the option that dictates what info will be shown not
	 *               finished yet - will be done in sprint 2
	 */
	public static void cropDisplay(ArrayList<crop> data, int option) {
		if (data == null || data.size() == 0) {
			System.out.println("\tNo Crops to display.");
		} else {
			if (option == 0) {
				System.out.println("List of Crops:\n");
				for (crop crop : data) {
					System.out.println(crop);
				}
//			} else if (option == 1) {
//				System.out.println("List of Crops:\n");
//				for (plot plot : data) {
//					System.out.println(plot.returnGrowth());
//				}
//			} else if (option == 2) {
//				System.out.println("List of Crops:\n");
//				for (plot plot : data) {
//					System.out.println(plot.returnWaterDetails());
//				}			
			}
			System.out.println();
		}
	}

	/**
	 * used select which crop to plant and which plot to plant in
	 */
	public static void plantCrop() {
		boolean finished = false;
		boolean correct = false;
		char response = ' ';
		String crop = "";
		String plot = "";
		do { // repeats until the user is finished
			correct = false;
			try {
				viewCrops();
				System.out.print("Please input the Id of the crop you wish to plant: ");
				crop = input.nextLine();
				viewPlots();
				System.out.print("Please input the Id of the plot to plant a crop in: ");
				plot = input.nextLine();
				if (checkCropPlotDetails(crop.trim(), plot.trim())) {
					correct = true;
				}
			} catch (Exception ex) {

			}

			if (correct) {
				System.out.println("Changes made");
			} else {
				System.out.println("Invalid inputs");
			}
			System.out.print("Do you want to make another change?(y/n): ");
			response = input.nextLine().charAt(0);
			if (response == 'n') {
				finished = true;
			}
		} while (!finished);
	}

	/**
	 * used select which crop to plant and which plot to plant in
	 */
	public static void waterCrop() {
		boolean finished = false;
		boolean correct = false;
		char response = ' ';
		String plot = "";
		do { // repeats until the user is finished
			correct = false;
			try {
				viewPlots();
				System.out.print("Please input the Id of the plot water: ");
				plot = input.nextLine();
				if (checkPlotDetails(plot.trim())) {
					plot RealPlot = null;
					ArrayList<plot> plots = FileAccess.importPlots(true);
					for (int i = 0; i < plots.size(); i++) {
						if (plots.get(i).getPlotID() == Integer.parseInt(plot)) {
							RealPlot = plots.get(i);
						}
					}
					RealPlot.waterPlot();
					correct = true;
				}

				if (correct) {
					System.out.println("Plot watered");
				} else {
					System.out.println("Invalid input");
				}
				System.out.print("Do you want to water another crop?(y/n): ");
				response = input.nextLine().charAt(0);
				if (response == 'n') {
					finished = true;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!finished);
	}

	/**
	 * Used to ensure input crop and plot exist
	 * 
	 * @param crop
	 * @param plot
	 * @return - true if valid, false if not
	 */
	public static boolean checkCropPlotDetails(String crop, String plot) {
		boolean realCrop = false;
		boolean realPlot = false;
		ArrayList<crop> crops = null;
		ArrayList<plot> plots = null;
		// checking to see if the input crop id relates to a crop
		for (int i = 0; i < crop.length(); i++) {
			if (!Character.isDigit(crop.charAt(i))) {
				return false;
			}
		}
		int c = Integer.parseInt(crop); // converts the string to int
		// imports the crops to compare input with Id's
		try {
			crops = FileAccess.importCrops(true);
		} catch (Exception e) {
		}

		crop temp = null;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i).getCropID() == c) {
				temp = crops.get(i);
				realCrop = true;
			}
		}
		// checking to see if the input plot id relates to a plot
		for (int i = 0; i < plot.length(); i++) {
			if (!Character.isDigit(plot.charAt(i))) {
				return false;
			}
		}
		int p = Integer.parseInt(plot); // converts the string to int
		// imports the plots to compare input with Id's
		try {
			plots = FileAccess.importPlots(true);
		} catch (Exception e) {
		}
		try {
			plot updatedPlot = new plot(p, temp);
			for (int i = 0; i < plots.size(); i++) {
				if (plots.get(i).getPlotID() == p) {
					realPlot = true;
				}
			}

			if (realCrop && realPlot) {
				for (int i = 0; i < plots.size(); i++) {
					if (plots.get(i).getPlotID() == p) {
						plots.set(i, updatedPlot);
					}
				}
				FileAccess.writePlots(plots, true, false);
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * Used to ensure input plot exists
	 * 
	 * @param crop
	 * @param plot
	 * @return - true if valid, false if not
	 */
	public static boolean checkPlotDetails(String plot) {

		// checking to see if the input plot id relates to a plot
		for (int i = 0; i < plot.length(); i++) {
			if (!Character.isDigit(plot.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * this would display all plots currently used
	 * 
	 * @throws IOException
	 */
	public static void viewPlots() throws IOException {
		ArrayList<plot> plot;
		try {
			plot = FileAccess.importPlots(true);
			plotDisplay(plot, 0);
		} catch (Exception e) {
		}
	}

	/**
	 * this will call and display the crops harvest date in the plot
	 * 
	 * @throws IOException
	 */
	public static void viewCropPlotGrowth() throws IOException {
		ArrayList<plot> plot;
		try {
			plot = FileAccess.importPlots(true);
			plotDisplay(plot, 1);
		} catch (Exception e) {
		}
	}

	/**
	 * this will call and display the crops water date in the plot
	 * 
	 * @throws IOException
	 */
	public static void viewCropPlotLevel() throws IOException {
		ArrayList<plot> plot;
		try {
			plot = FileAccess.importPlots(true);
			plotDisplay(plot, 2);
		} catch (Exception e) {
		}
	}

	/**
	 * this would display all crops currently planted
	 * 
	 * @throws IOException
	 */
	public static void viewCrops() throws IOException {
		ArrayList<crop> crop;
		try {
			crop = FileAccess.importCrops(true);
			cropDisplay(crop, 0);
		} catch (Exception e) {
		}
	}

	/*
	 * this will show the growth of all crops
	 */
//	public static void viewCropGrowth() throws IOException {
//		ArrayList<crop> crop = FileAccess.importCrops(true);
//		cropDisplay(crop, 1);
//	}
//
//	/*
//	 * this will show the water level of all crops
//	 */
//	public static void viewCropLevel() throws IOException {
//		ArrayList<crop> crop = FileAccess.importCrops(true);
//		cropDisplay(crop, 2);
//	}
}