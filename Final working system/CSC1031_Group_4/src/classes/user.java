package classes;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

public class user {

	public String name;
	public String username;
	public String password;
	public boolean banned;
	public File myObj = new File("filename.txt");

	// Constructor
	public user(String name, String username, String password, boolean banned) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.banned = banned;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isBanned() {
		return banned;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBanned(boolean i) {
		this.banned = i;
	}

	public void banUser() {
		setBanned(true);
	}

	public void createFiles() {
		try {
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void registerUser(user user) {
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
