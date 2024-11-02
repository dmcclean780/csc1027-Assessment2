package part01;

import java.util.Scanner;

public class Menu {
	private String items[];
	private String title;
	private Scanner input;

	/**
	 * Constructor
	 * @param title - the menu title
	 * @param data - the options that make up the menu
	 */
	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}

	/**
	 * prints the title with a row of + the same length followed by a numbered list of the options
	 */
	private void display() {
		System.out.println(title);
		for (int count = 0; count < title.length(); count++) {
			System.out.print("+");
		}
		System.out.println();
		for (int option = 1; option <= items.length; option++) {
			System.out.println(option + ". " + items[option - 1]);
		}
		System.out.println();
	}

	/**
	 * Displays the menu and takes the users selection from it
	 * @return the value entered by the user
	 */
	public int getUserChoice() {
		boolean ok = false;
		int value = 0;
		display();
		do {
			System.out.print("Enter Selection: ");
			try {
				value = input.nextInt();
				if ( value>=1 && value<=items.length ) {
					ok = true;
				}
			} catch (Exception ex) {
				input.nextLine();
			}
		} while (!ok);
		return value;
	}
}
