package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class cropMethods {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		cropMenu();

	}


	public static void cropMenu() throws IOException {
		String options[] = { "View Crops", "View Crop Growth", "View Crop Water Level", "Exit" };
		Menu mainMenu = new Menu("Crop Menu", options);
		boolean finished = false;
		do {
			int option = mainMenu.getUserChoice(4);
			switch (option) {
			case 1:
				viewCrops();
				break;
			case 2:
				viewCropGrowth();
				break;
			case 3:
				viewCropLevel();
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished); // will continue until the user exits
		System.out.println("Goodbye!");
		input.close();
	}

	/**
	 * for the admin to create new crops
	 * @throws IOException 
	 */
	public static void createCrop() throws IOException {
		boolean correct;
		do {
			ArrayList<crop> cropsList = FileAccess.importCrops(true);
			int id = cropsList.get(cropsList.size() -1).getCropID() + 1;
			System.out.println("Please input the name of the crop: ");
			String name = input.nextLine();
			System.out.println("Please input the shelf life of the crop (days): ");
			int shelfLife = input.nextInt();
			System.out.println("please input the length of time the crop takes to grow (days): ");
			int growth = input.nextInt();
			System.out.println("Please input the amount of days between each water: ");
			int checkUp = input.nextInt();
			try {
				crop a = new crop(id, name, shelfLife, growth, checkUp);
				cropsList.add(a);
				FileAccess.writeCrops(cropsList, true, false);
				correct = true;
			} catch (Exception ex) {
				System.out.println(ex);
				correct = false;
			}
		} while (!correct);
	}

	public static void cropDisplay(ArrayList<crop> data, int n) {
		if (data == null || data.size() == 0) {
			System.out.println("\tNo Crops to display.");
		} else {
			if (n == 0) {
				System.out.println("List of Crops:\n");
				for (crop crop : data) {
					System.out.println(crop);
				}
			} else if (n == 1) {
				System.out.println("List of Crops:\n");
				for (crop crop : data) {
					System.out.println(crop.getGrowthLength());
				}
			} else if (n == 2) {
				System.out.println("List of Crops:\n");
				for (crop crop : data) {
					System.out.println(crop.getWaterCheckUp());
				}
			}
		}
		System.out.println();
	}

	/**
	 * this would display all crops
	 * @throws IOException 
	 */
	public static void viewCrops() throws IOException {
		ArrayList<crop> crop = FileAccess.importCrops(true);
		cropDisplay(crop, 0);
	}

	/*
	 * this will show the growth of all crops
	 */
	public static void viewCropGrowth() throws IOException {
		ArrayList<crop> crop = FileAccess.importCrops(true);
		cropDisplay(crop, 1);
	}

	/*
	 * this will show the water level of all crops
	 */
	public static void viewCropLevel() throws IOException {
		ArrayList<crop> crop = FileAccess.importCrops(true);
		cropDisplay(crop, 2);
	}
}
