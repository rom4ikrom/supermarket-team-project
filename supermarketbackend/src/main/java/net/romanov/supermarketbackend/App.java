package net.romanov.supermarketbackend;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("This is Sant");
		System.out.println("This is Sam");

	}

	public void getDB() {
		// Area for getting DB info

		updateSite();
	}

	public void updateSite() {
		// Get info from getDB, push to website.

	}

	public void getLoginDetails() {
		// Grabs Username and Password from Website textboxes

		verifyUser(username, password);
	}

	public void verifyUser(String Username, String Password) {
		// Checks username and password against the DB

	}

}
