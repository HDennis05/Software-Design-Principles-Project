package test_Classes;

import java.util.ArrayList;

import classes.plot;
import classes.plotOwner;

public class PlotOwnerTest {
	private static ArrayList<plot> plots;

	public static void main(String[] args) {
		plots = new ArrayList<plot>();
		plots.add(null);
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
		testCase6();
		testCase7();
	}

	public static void testCase1() {
		System.out.println("Test Case 1:");
		System.out.println("Testing the input of valid data");
		System.out.println(
				"Data input: Name = \"Adam\", Phone Number = 07482047562, Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "07482047562", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 1\n");
	}

	public static void testCase2() {
		System.out.println("Test Case 2:");
		System.out.println("Testing the input of an invalid Name");
		System.out.println(
				"Data input: Name = \"   \", Phone Number = 07482047562, Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "   ", "Password1", "07482047562", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 2\n");
	}

	public static void testCase3() {
		System.out.println("Test Case 3:");
		System.out.println("Testing the input of an invalid Phone Number(too short)");
		System.out.println("Data input: Name = \"Adam\", Phone Number = 074820, Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "074820", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 3\n");
	}

	public static void testCase4() {
		System.out.println("Test Case 4:");
		System.out.println("Testing the input of an invalid Phone Number(doesn't begin with 0)");
		System.out.println(
				"Data input: Name = \"Adam\", Phone Number = 17482047562, Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "17482047562", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 4\n");
	}

	public static void testCase5() {
		System.out.println("Test Case 5:");
		System.out.println("Testing the input of an invalid Phone Number(entire input of letters)");
		System.out.println(
				"Data input: Name = \"Adam\", Phone Number = \"qwerty\", Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "qwerty", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 5\n");
	}

	public static void testCase6() {
		System.out.println("Test Case 6:");
		System.out.println("Testing the input of an invalid Phone Number(part of the input will be a letter)");
		System.out.println(
				"Data input: Name = \"Adam\", Phone Number = \"07482Q47562\", Email Address = \"adam123@gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "07482Q47562", "adam123@gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 6\n");
	}

	public static void testCase7() {
		System.out.println("Test Case 7:");
		System.out.println("Testing the input of an invalid Email Address");
		System.out.println(
				"Data input: Name = \"Adam\", Phone Number = 07482047562, Email Address = \"adam123gmail.com\"");
		try {
			plotOwner a = new plotOwner(1, "Adam", "Password1", "07482047562", "adam123gmail.com", false, plots);
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End of Test Case 7\n");
	}
}
