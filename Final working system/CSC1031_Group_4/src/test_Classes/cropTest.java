package test_Classes;

import classes.cropOld;

public class cropTest {
	static cropOld data = new cropOld(4,"Spuds", 3, 70, 100, 3);

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
	}

	public static void testCase1() {
		System.out.println("Test Case 1 ---------->\n");
		System.out.println("Testing to see if a crop is added with correct data");
		System.out.println("---------- Start Test Case ----------\n");
		// crop data = new crop("Spuds", 3, 70, 100, 3);
		System.out.println(data);
		System.out.println("Crop successfully added");
		System.out.println("---------- End Test Case ----------\n");

	}

	public static void testCase2() {
		System.out.println("Test Case 2 ---------->\n");
		System.out.println("Testing to see if set crops water level works");
		System.out.println("---------- Start Test Case ----------\n");
		try {
			data.setWaterLevel(30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
		System.out.println("Crop successfully added");
		System.out.println("---------- End Test Case ----------\n");

	}

	public static void testCase3() {
		System.out.println("Test Case 3 ---------->\n");
		System.out.println("Testing to see if set crops name works");
		System.out.println("---------- Start Test Case ----------\n");
		try {
			data.setName("Testing");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
		System.out.println("Crop successfully added");
		System.out.println("---------- End Test Case ----------\n");
	}

	public static void testCase4() {
		System.out.println("Test Case 4 ---------->\n");
		System.out.println("Testing to see if set setGrowth works");
		System.out.println("---------- Start Test Case ----------\n");
		try {
			data.setGrowth(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
		System.out.println("Crop successfully added");
		System.out.println("---------- End Test Case ----------\n");
	}

	
}
