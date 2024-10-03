package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException; //Imports
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;

public class FileAccess {
	
	/**
	 * Imports all crops in CSV file
	 * @param isHeader - true if there is a header (will skip that line)
	 * @return array list of all crops
	 * @throws IOException
	 */
	public static ArrayList<crop> importCrops(boolean isHeader) throws IOException{
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/crop.CSV";
		
		String line = null;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path)); //reader object			
			ArrayList<crop> crops = new ArrayList<crop>();
			
			if (isHeader) {
				line = bufferedReader.readLine();//skip first line
			}
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] cropParts = line.split(","); 
				int id = Integer.parseInt(cropParts[0].trim());
				String name = cropParts[1].trim();
				int shelfLife = Integer.parseInt(cropParts[2].trim());
				int lengthOfGrowth = Integer.parseInt(cropParts[3].trim());
				int waterCheckup = Integer.parseInt(cropParts[4].trim());
				

				crops.add(new crop(id, name, shelfLife, lengthOfGrowth,  waterCheckup));
			}

			bufferedReader.close(); //close reader
			return crops;
			
		} catch (FileNotFoundException e) {
			System.out.println(path + "\nfile not found");
		}
		return null;
	}
	
	/**
	 * Writes to crop CSV file
	 * @param arrayList - list of crops 
	 * @param writeHeaders - if headers need to be written or not
	 * @param append - if data should be appended instead of overwriting old data
	 */
	public static void writeCrops(ArrayList<crop> arrayList, boolean writeHeaders, boolean append) {
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/crop.CSV";
		
		try {
			PrintWriter myPw = new PrintWriter(new FileWriter(new File(path), append));
			
			if (writeHeaders) {
				myPw.println("cropID, name, shelfLife, lengthOfGrowth, waterCheckup");
			}
						
			for (crop everyItem : arrayList) {
				myPw.println(everyItem.getCropID() + ", " + everyItem.getName() + ", " + everyItem.getShelfLife() + ", " + everyItem.getGrowthLength() + ", " +  everyItem.getWaterCheckUp());
			
			}
			
			myPw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Imports all plots in CSV file
	 * @param isHeader - true if there is a header (will skip that line)
	 * @return array list of all plots
	 * @throws Exception 
	 */
	public static ArrayList<plot> importPlots(boolean isHeader) throws Exception{
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/plot.CSV";
		
		String line = null;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path)); //reader object		
			ArrayList<plot> plots = new ArrayList<plot>();
			
			if (isHeader) {
				line = bufferedReader.readLine();//skip first line
			}
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] plotParts = line.split(","); 
				int plotID = Integer.parseInt(plotParts[0].trim());
				int cropID = Integer.parseInt(plotParts[1].trim());
				LocalDate datePlanted = LocalDate.parse(plotParts[2].trim());
				LocalDate nextWaterDate = LocalDate.parse(plotParts[3].trim());
				

				plots.add(new plot(plotID, cropID, datePlanted, nextWaterDate));
				
			}

			bufferedReader.close(); //close reader
			return plots;
			
		} catch (FileNotFoundException e) {
			System.out.println(path + "\nfile not found");
		}
		return null;
	}
	
	/**
	 * Writes to plot CSV file
	 * @param arrayList - list of plots 
	 * @param writeHeaders - if headers need to be written or not
	 * @param append - if data should be appended instead of overwriting old data
	 */
	public static void writePlots(ArrayList<plot> arrayList, boolean writeHeaders, boolean append) {
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/plot.CSV";
		
		try {
			PrintWriter myPw = new PrintWriter(new FileWriter(new File(path), append));
			
			if (writeHeaders) {
				myPw.println("plotID, cropID, datePlanted, nextWaterDate");
			}
						
			for (plot everyItem : arrayList) {
				myPw.println(everyItem.getPlotID() + ", " + everyItem.getCrop().getCropID() + ", " + everyItem.getDatePlanted() + ", " + everyItem.getNextWaterDate());
			
			}
			
			myPw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Imports all plotOwner in CSV file
	 * @param isHeader - true if there is a header (will skip that line)
	 * @return array list of all crops
	 * @throws Exception 
	 */
	public static ArrayList<plotOwner> importPlotOwners(boolean isHeader) throws Exception{
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/plotOwner.CSV";
		
		String line = null;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path)); //reader object			
			ArrayList<plotOwner> plotOwners = new ArrayList<plotOwner>();
			
			if (isHeader) {
				line = bufferedReader.readLine();//skip first line
			}
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] plotOwnerParts = line.split(","); 
				int id = Integer.parseInt(plotOwnerParts[0].trim());
				String name = plotOwnerParts[1].trim();
				String password = plotOwnerParts[2].trim();
				String phoneNo = plotOwnerParts[3].trim();
				String email = plotOwnerParts[4].trim();
				boolean banned = false;
				if (plotOwnerParts[5].trim() == "true"){
					banned = true; }
					
				ArrayList<plot> plots = new ArrayList<plot>();
				String plotsString = plotOwnerParts[6].trim();
				String[] plotsArray = plotsString.split(","); 
				for (String everyItem : plotsArray) {
					ArrayList<plot> existingPlots = importPlots(true);
					for (plot everyPlot : existingPlots) {
						if (everyPlot.getPlotID() == Integer.parseInt(everyItem)){
							plots.add(everyPlot);
						}
					}
				}
				

				plotOwners.add(new plotOwner(id, name, password, phoneNo, email, banned, plots));
			}

			bufferedReader.close(); //close reader
			return plotOwners;
			
		} catch (FileNotFoundException e) {
			System.out.println(path + "\nfile not found");
		}
		return null;
	}
	
	/**
	 * Writes to plotOwner CSV file
	 * @param arrayList - list of plotOwners 
	 * @param writeHeaders - if headers need to be written or not
	 * @param append - if data should be appended instead of overwriting old data
	 */
	public static void writePlotOwner(ArrayList<plotOwner> arrayList, boolean writeHeaders, boolean append) {
		String userDirectory = System.getProperty("user.dir"); //get the directory where this project is saved locally
		String path = userDirectory + "/src/csvFiles/plotOwner.CSV";
		
		try {
			PrintWriter myPw = new PrintWriter(new FileWriter(new File(path), append));
			
			if (writeHeaders) {
				myPw.println("userID, name, password, phoneNo, email, banned, plots");
			}
				
			for (plotOwner everyItem : arrayList) {
				String plotsString = "";
				for (plot everyPlot : everyItem.getPlots()) {
					plotsString += everyPlot.getPlotID() + ", ";
				}
				myPw.println(everyItem.getUserID() + ", " + everyItem.getName() + ", " + everyItem.getPassword() + ", " + everyItem.getPhoneNo() + ", " 
					+ everyItem.getEmail() + ", " + everyItem.getBanned() + ", " + plotsString);
			
			}
			
			myPw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
