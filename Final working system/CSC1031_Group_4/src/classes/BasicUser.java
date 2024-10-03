package classes;

/**
 * Author: Adam Greeran Student Number: 40411908
 * 
 * Base class for every user in the system
 */

public class BasicUser {
	private int userID;
	private String name;
	private String password;
	private String phoneNo;
	private String email;
	protected boolean banned;

	/**
	 * Constructor for the basic user class
	 * 
	 * @param name
	 * @param password
	 * @param phoneNo
	 * @param email
	 * @throws Exception
	 */
	public BasicUser(int userID, String name, String password, String phoneNo, String email, boolean banned)
			throws Exception {
		this.userID = userID;
		// booleans are used to check if the input data is valid
		boolean correctName = setName(name);
		setPassword(password);
		this.banned = banned;
		boolean correctPhoneNo = setPhoneNo(phoneNo);
		boolean correctEmail = setEmail(email);
		// if any input is invalid, exception will throw showing invalid input
		if (correctName == false) {
			throw new Exception("Invalid Name");
		} else if (correctPhoneNo == false) {
			throw new Exception("Invalid Phone Number");
		} else if (correctEmail == false) {
			throw new Exception("Invalid Email Address");
		}
	}

	// setters return a true or false if the data is valid or not
	public boolean setName(String Name) {
		if (!Name.isBlank()) {
			name = Name;
			return true;
		} else {
			return false;
		}
	}

	public boolean setPhoneNo(String PhoneNo) {
		if (PhoneNo.length() == 11 && PhoneNo.charAt(0) == '0') {
			// ensure each char is a digit
			for (int i = 0; i < 11; i++) {
				if (!Character.isDigit(PhoneNo.charAt(i))) {
					return false;
				}
			}
			phoneNo = PhoneNo;
			return true;
		} else {
			return false;
		}
	}

	public boolean setEmail(String Email) {
		if (!Email.isBlank() && Email.contains("@")) {
			email = Email;
			return true;
		} else {
			return false;
		}
	}

	private void setPassword(String Password) {
		password = Password;
	}

	public void setBanned(boolean Banned) {
		banned = Banned;
	}

	// getters
	public int getUserID() {
		return this.userID;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean getBanned() {
		return this.banned;
	}

	public boolean checkPassword(String password) {
		if (this.password.compareTo(password.trim()) == 0) {
			return true;
		}
		return false;
	}

	protected boolean changePassword(String oldPassword, String newPassword) {
		// as there is no way to get the stored password, the old password has to be
		// passed in order to change it
		if (checkPassword(oldPassword)) {
			setPassword(newPassword);
			return true;
		}
		return false;
	}

	/**
	 * to string method to display the data of the user
	 */
	public String toString() {
		String user = "";
		user += "ID: " + getUserID();
		user += "\nName: " + getName();
		user += "\nPhone Number: " + getPhoneNo();
		user += "\nEmail Address: " + getEmail();
		return user;
	}

	/**
	 * Ban user
	 */
	public void banUser() {
		this.banned = true;
	}

	public void unbanUser() {
		this.banned = false;
	}
}
