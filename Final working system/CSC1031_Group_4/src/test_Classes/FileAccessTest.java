package test_Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import classes.FileAccess;
import classes.crop;
import classes.plot;
import classes.plotOwner;

public class FileAccessTest {
	public static void main(String[] args) throws Exception {
		ArrayList<crop> crops = FileAccess.importCrops(true);
		System.out.println(crops);
		
		ArrayList<plot> newPlots = new ArrayList<plot>();
		plot p1 = new plot(0,crops.get(0));
		plot p2 = new plot(1,crops.get(0));
		plot p3 = new plot(2,crops.get(1));
		plot p4 = new plot(3,crops.get(2));
		plot p5 = new plot(4,crops.get(2));
		newPlots.add(p1);
		newPlots.add(p2);
		newPlots.add(p3);
		newPlots.add(p4);
		newPlots.add(p5);
		FileAccess.writePlots(newPlots, true, false);
		System.out.println(FileAccess.importPlots(true));
		
		ArrayList<plot> plots1 = new ArrayList<plot>();
		plots1.add(p1);
		ArrayList<plot> plots2 = new ArrayList<plot>();
		plots2.add(p2);
		ArrayList<plot> plots3 = new ArrayList<plot>();
		plots3.add(p3);
		ArrayList<plot> plots4 = new ArrayList<plot>();
		plots4.add(p4);
		ArrayList<plot> plots5 = new ArrayList<plot>();
		plots5.add(p5);
		
		ArrayList<plotOwner> newPlotOwners = new ArrayList<plotOwner>();
		plotOwner a = new plotOwner(1,"Adam", "Password1", "07482047562", "adam123@gmail.com",false, plots1);
		plotOwner b = new plotOwner(2,"Simon", "Password2", "07482047562", "simon456@gmail.com",false, plots2);
		plotOwner c = new plotOwner(3,"Hannah", "Password3", "07482047562", "hannah789@gmail.com",false, plots3);
		plotOwner d = new plotOwner(4,"Peter", "Password4", "07482047562", "peter012@gmail.com",false, plots4);
		plotOwner e = new plotOwner(5,"Luke", "Password5", "07482047562", "luke345@gmail.com",false, plots5);
		newPlotOwners.add(a);
		newPlotOwners.add(b);
		newPlotOwners.add(c);
		newPlotOwners.add(d);
		newPlotOwners.add(e);
		FileAccess.writePlotOwner(newPlotOwners, true, false);
		System.out.println(FileAccess.importPlotOwners(true));
	}
}
