package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class admin extends BasicUser{
	
	public admin(int userID, String name, String password, String phoneNo, String email, boolean banned) throws Exception {
		super(userID, name, password, phoneNo, email, banned);
    }

	@Override
	public void setBanned(boolean Banned) 
    {
    	this.banned = false;
    }
	// Inside your admin class

	public static void addUser() {
	    Scanner scanner = new Scanner(System.in); // Note: Consider managing Scanner more globally
	    ArrayList<plotOwner> ownersList = new ArrayList<>();

	    System.out.println("Enter user ID:");
	    int userID = Integer.parseInt(scanner.nextLine());
	    System.out.println("Enter name:");
	    String name = scanner.nextLine();
	    System.out.println("Enter password:");
	    String password = scanner.nextLine();
	    System.out.println("Enter phone number:");
	    String phoneNo = scanner.nextLine();
	    System.out.println("Enter email:");
	    String email = scanner.nextLine();

	    boolean banned = false;
	    ArrayList<plot> plots = new ArrayList<>();

	    try {
	        plotOwner newOwner = new plotOwner(userID, name, password, phoneNo, email, banned, plots);
	        ownersList.add(newOwner);

	        FileAccess.writePlotOwner(ownersList, false, true);

	        System.out.println("User added successfully.");
	    } catch (Exception e) {
	        System.out.println("Failed to add user: " + e.getMessage());
	    } finally {
	        scanner.close(); // Be cautious with closing System.in
	    }
	}

}
//

	

