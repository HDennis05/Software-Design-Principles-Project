package classes;

/**
 * Author: Adam Greeran
 * Student Number: 40411908
 * 
 * Purpose of this class is to provide structure for console based menus
 */

import java.util.Scanner;

public class Menu {
	private String items[]; // the options to be used in the menu
	private String title; // the title of the menu
	private Scanner input; // the user's input

	/**
	 * Constructor for the class
	 * 
	 * @param title - name if the menu
	 * @param data  - options to be listed in the menu
	 */
	public Menu(String title, String data[]) {
		this.title = title; // sets the title
		this.items = data; // sets the options
		this.input = new Scanner(System.in); // creates the scanner
	}

	/**
	 * displays the options of the menu to the user
	 */
	private void display() {
		System.out.println(title);
//		for (int count = 0; count < title.length(); count++) {
//			System.out.print("+");
//		}
//		System.out.println();
		for (int option = 1; option <= items.length; option++) {
			System.out.println(option + ". " + items[option - 1]);
		}
		System.out.println();
	}

	/**
	 * gets the user's choice from the options in the menu
	 * 
	 * @param values - number of options. Used to see if the input is a valid option
	 * @return - int of the user's choice
	 */
	public int getUserChoice(int values) {
		// parameter allows method to be used for several menus of different lengths
		display();
		int value = 0;
		boolean correct = false;
		do { // do while loop ensures valid input
			System.out.print("Enter Selection: ");
			try {
				value = input.nextInt();
				if (value >= 1 && value <= values) {
					correct = true;
				} else {
					System.out.println("Invalide Response - Try Again");
				}
			} catch (Exception ex) {
				System.out.println("Invalide Response - Try Again");
				input.nextLine();
			}
			System.out.println("");
		} while (!correct);
		return value;
	}

}
