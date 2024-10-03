package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class PlotOwnerLogin {
	static Scanner input = new Scanner(System.in); // scanner for user inputs
	static plotOwner[] owners = new plotOwner[5];
	private static ArrayList<plot> plots;

	public static void main(String[] args) {
		plots = new ArrayList<plot>();
		plots.add(null);
		try {
			plotOwner a = new plotOwner(1,"Adam", "Password1", "07482047562", "adam123@gmail.com", false, plots);
			plotOwner b = new plotOwner(2, "Simon", "Password2", "07482047562", "simon456@gmail.com", false, plots);
			plotOwner c = new plotOwner(3, "Hannah", "Password3", "07482047562", "hannah789@gmail.com", false, plots);
			plotOwner d = new plotOwner(4, "Peter", "Password4", "07482047562", "peter012@gmail.com", false, plots);
			plotOwner e = new plotOwner(5, "Luke", "Password5", "07482047562", "luke345@gmail.com", false, plots);
			owners[0] = a;
			owners[1] = b;
			owners[2] = c;
			owners[3] = d;
			owners[4] = e;
		} catch (Exception e) {
			
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

	public static void mainMenu() {
		String options[] = { "View Users", "Add User", "Logout" };
		Menu mainMenu = new Menu("--------Main Menu--------", options);
		boolean finished = false;
		do {
			int option = mainMenu.getUserChoice(options.length);
			switch (option) {
			case 1:
				System.out.println("View users is currently under development\n");
				// viewUsers();
				break;
			case 2:
				System.out.println("Add user is currently under development\n");
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

	public static void login() {
		System.out.println("----------Login----------");
		System.out.print("Enter ID: ");
		String id = input.nextLine();
		System.out.print("Enter Password: ");
		String password = input.nextLine();
		if (checkID(id, password)) {
			mainMenu();
		} else {
			System.out.println("Invalid data\n");
		}
	}

	private static boolean checkID(String id, String password) {
		for (int i = 0; i < owners.length; i++) {
			for (int j = 0; j < id.length(); j++) {
				if (!Character.isDigit(id.charAt(j))) {
					return false;
				}
			}
			if (owners[i].getUserID() == Integer.parseInt(id)) {
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
}
