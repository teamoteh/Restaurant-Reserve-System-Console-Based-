package UI;

import java.util.Scanner;
import Manager.MenuMgr;

public class MenuUI {

	public static void displayMenu_UI() {
		Scanner sc = new Scanner(System.in);

		int user_choice;
		do {
			System.out.println("What would you like to do?");

			System.out.println("1. View Current Menu \n" + "2. Create Menu Item\n" + "3. Update Menu Item\n"
					+ "4. Remove Menu Item\n" + "5. View Promo Menu\n" + "6. Create Promo Item\n"
					+ "7. Update Promo Item\n" + "8. Remove Promo Item\n" + "9. Exit\n");

			System.out.println("Input a choice:");
			user_choice = sc.nextInt();

			switch (user_choice) {
			case 1:
				MenuMgr.printMenu();
				break;

			case 2:
				System.out.println("What is the name of the new Menu Item?");
				String name = sc.next();

				System.out.println("What is the price of the new Menu Item?");
				double price = sc.nextDouble();

				System.out.println("What is the description of the new Menu Item?");
				String desc = sc.next();

				System.out.println(
						"What is the type of the new Menu Item? Choose from MainCourse, Drinks, Dessert or Appetizer ");
				String type = sc.next();

				MenuMgr.addToMenu(name, price, desc, type);
				break;

			case 3:
				System.out.println("What is the name of the current Menu Item to be updated?");
				String name1 = sc.next();

				System.out.println("What is the name of the updated Menu Item?");
				String newname = sc.next();

				System.out.println("What is the price of the updated Menu Item?");
				double price1 = sc.nextDouble();

				System.out.println("What is the description of the updated Menu Item?");
				String desc1 = sc.next();

				System.out.println(
						"What is the type of the updated Menu Item? Choose from MainCourse, Drinks, Dessert or Appetizer ");
				String type1 = sc.next();

				MenuMgr.updateToMenu(name1, newname, price1, desc1, type1);

				break;

			case 4:
				System.out.println("What is the current Menu Item to be removed?");
				String name3 = sc.next();

				MenuMgr.removeFromMenu(name3);

				break;

			case 5:
				MenuMgr.printMenu(); // promomenu
				break;

			case 6:
				System.out.println("What is the name of the new Promo Item?");
				String promoname = sc.next();

				// Menu.display

				System.out.println("What is the name of the Appetizer to add to the Promo?");
				// Menu.display- have to retype if dont match - enter - if dont want to add eg.

				System.out.println("What is the name of the MainCourse to add to the Promo?");
				// Menu.display

				System.out.println("What is the name of the Dessert to add to the Promo?");
				// Menu.display

				System.out.println("What is the name of the Drink to add to the Promo?");

				System.out.println("What is the price of the new Promo Item?");
				double promoprice = sc.nextDouble();

				System.out.println("What is the description of the new Promo Item?");
				String promodesc = sc.next();

				// System.out.println(
				// "What is the type of the new Menu Item? Choose from MainCourse, Drinks,
				// Dessert or Appetizer ");
				// String type = sc.next();

				MenuMgr.addToMenu(promoname, promoprice, promodesc);
				break;

			case 7:
				System.out.println("What is the name of the current Promo Item to be updated?");
				String name1 = sc.next();

				System.out.println("What is the name of the updated Promo Item?");
				String newname = sc.next();

				System.out.println("What is the price of the Promo Menu Item?");
				double price1 = sc.nextDouble();

				System.out.println("What is the description of the updated Menu Item?");
				String desc1 = sc.next();

				// System.out.println(
				// "What is the type of the updated Menu Item? Choose from MainCourse, Drinks,
				// Dessert or Appetizer ");
				// String type1 = sc.next();

				MenuMgr.updateToMenu(name1, newname, price1, desc1);

				break;

			case 8:
				System.out.println("What is the current Promo Item to be removed?");
				String name3 = sc.next();

				MenuMgr.removeFromMenu(name3);

				break;

			}

		} while (user_choice > 0 && user_choice < 9);
	}
}
