package UI;

import java.util.Scanner;
import Manager.MenuMgr;
import Manager.OrderMgr;
import Manager.PromoMgr;
import Entities.FoodItem;

/**
 * Menu Console UI to display Menu options
 * 
 * @author Pranwanth
 * @version 1.0
 * @since 2021-11-12
 */

public class MenuUI {
	/**
	 * Displays all the menu console UI options
	 */
	public static void displayMenu_UI() {
		Scanner sc = new Scanner(System.in);

		int user_choice;
		do {

			System.out.println("What would you like to do?");

			System.out.println("1. View Current Menu \n" + "2. Create Menu Item\n" + "3. Update Menu Item\n"
					+ "4. Remove Menu Item\n" + "5. View Promo Menu\n" + "6. Add Promo Item\n"
					+ "7. Remove Promo Item\n" + "8. Create New Set Promo\n" + "9. Exit\n");

			System.out.println("Input a choice:");
			user_choice = Integer.parseInt(sc.nextLine());

			switch (user_choice) {
			case 1:
				MenuMgr.printMenu();
				break;

			case 2:
				System.out.println("What is the name of the new Menu Item?");
				String name = sc.nextLine();

				System.out.println("What is the price of the new Menu Item?");
				double price = Double.parseDouble(sc.nextLine());

				System.out.println("What is the description of the new Menu Item?");
				String desc = sc.nextLine();

				System.out.println("Please choose from MainCourse, Drinks, Dessert or Appetizer");
				System.out.println("What is the type of the new Menu Item?");
				String type = sc.nextLine();

				MenuMgr.addToMenu(name, price, desc, type);
				break;

			case 3:
				System.out.println("What is the name of the current Menu Item to be updated?");
				String name1 = sc.nextLine();

				System.out.println("What is the name of the updated Menu Item?");
				String newName = sc.nextLine();

				System.out.println("What is the price of the updated Menu Item?");
				double price1 = Double.parseDouble(sc.nextLine());

				System.out.println("What is the description of the updated Menu Item?");
				String desc1 = sc.nextLine();

				System.out.println(
						"What is the type of the updated Menu Item? Choose from MainCourse, Drinks, Dessert or Appetizer ");
				String type1 = sc.nextLine();

				MenuMgr.updateToMenu(name1, newName, price1, desc1, type1);

				break;

			case 4:
				System.out.println("What is the current Menu Item to be removed?");
				String name3 = sc.nextLine();

				MenuMgr.removeFromMenu(name3);

				break;

			case 5:
				PromoMgr.printPromoMenu(); // promomenu
				break;

			case 6:
				System.out.println("What is the name of the new Menu Item?");
				name = sc.nextLine();

				System.out.println("");

				System.out.println("Please choose from MainCourse, Drinks, Dessert or Appetizer");
				System.out.println("What is the type of the new Menu Item?");
				type = sc.nextLine();
				System.out.println("");

				System.out.println("Please type the name of the Set Promo to add to: ");
				for (int s = 0; s < PromoMgr.setPromoList.size(); s++) {
					System.out.println("-" + PromoMgr.setPromoList.get(s).getPromoName());
				}

				String setName = sc.nextLine();

				System.out.println("");
				PromoMgr.addFood(name, type, setName);
				break;

			case 7:
				System.out.println("What is the name of the Food Item from Set Promo to be removed?");
				name = sc.nextLine();
				System.out.println("");

				System.out.println("Please type the name of the Set Promo to add to: ");
				for (int s = 0; s < PromoMgr.setPromoList.size(); s++) {
					System.out.println("-" + PromoMgr.setPromoList.get(s).getPromoName());
				}

				setName = sc.nextLine();

				PromoMgr.removeFood(name, setName);
				break;

			case 8:
				System.out.println("What is the name of the new Set Promo?");
				name = sc.nextLine();

				System.out.println("What is the description of the new Set Promo?");
				desc = sc.nextLine();

				System.out.println("How many Food Items are in " + name + " Set Promo?");
				int num = Integer.parseInt(sc.nextLine());

				PromoMgr.createSetPromo(name, desc, num);
			}

		} while (user_choice > 0 && user_choice < 9);
		// sc.close();
	}

}
