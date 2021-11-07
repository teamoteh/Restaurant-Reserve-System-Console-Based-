package UI;

import java.util.Scanner;
import Manager.MenuMgr;
import Manager.OrderMgr;
import Manager.PromoMgr;
import Entities.FoodItem;

public class MenuUI {
	/*
	 * PLEASE READ BEFORE EDITING sc.nextLine() is used instead of sc.next(), as
	 * sc.next() stops reading at whitespaces Hence when inputting foodDesc e.g.
	 * "Spicy Chicken Burger" sc.next() will be equal to Spicy only therefore had to
	 * use sc.nextLine() Integer and Double are being parsed, to allow proper
	 * execution of sc.nextLine() Without parse THE PROBLEM will occur. THE PROBLEM:
	 * https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-
	 * after-using-next-or-nextfoo Menu should be working fine now, only need to
	 * figure out how to write to text file. To run it remember to initialise it in
	 * Restaurant App at the start Initialise command: MenuMgr.getMenu();
	 *
	 * For the txt files the commas after the last item were the reason why MenuMgr
	 * got errors
	 *
	 * Menu Testing was done on a different local git branch
	 */
	// public static void main(String args[])
	public static void displayMenu_UI() {
		// MenuMgr.getMenu();
		Scanner sc = new Scanner(System.in);

		int user_choice;
		do {
			System.out.println("What would you like to do?");

			System.out.println("1. View Current Menu \n" + "2. Create Menu Item\n" + "3. Update Menu Item\n"
					+ "4. Remove Menu Item\n" + "5. View Promo Menu\n" + "6. Add Promo Item\n"
					+ "7. Remove Promo Item\n" + "8. Exit\n");

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
				int promoChoice;
				do {
					System.out.println("What is the Food Type of the item to be added?");
					System.out.println(
							"1. Appetizer \n" + "2. Main Course\n" + "3. Dessert\n" + "4. Drink\n" + "5. Exit\n");
					promoChoice = sc.nextInt();
					switch (promoChoice) {
					case 1:
						int i;
						System.out.println("What is the name of the Appetizer to add to the Promo?");
						String foodName = sc.nextLine();
						FoodItem food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Appetizer);
						System.out.println("What is the name of the set you would like to add to?");
						String promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.addFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 2:
						System.out.println("What is the name of the Main Course to add to the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.MainCourse);
						System.out.println("What is the name of the set you would like to add to?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.addFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 3:
						System.out.println("What is the name of the Dessert to add to the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Dessert);
						System.out.println("What is the name of the set you would like to add to?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.addFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 4:
						System.out.println("What is the name of the Drink to add to the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Drinks);
						System.out.println("What is the name of the set you would like to add to?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.addFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					}
				} while (promoChoice > 0 && promoChoice < 5);
				break;

			case 7:
				do {
					System.out.println("What is the Food Type of the item to be removed?");
					System.out.println(
							"1. Appetizer \n" + "2. Main Course\n" + "3. Dessert\n" + "4. Drink\n" + "5. Exit\n");
					promoChoice = Integer.parseInt(sc.nextLine());
					switch (promoChoice) {
					case 1:
						int i;
						System.out.println("What is the name of the Appetizer to remove from the Promo?");
						String foodName = sc.nextLine();
						FoodItem food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Appetizer);
						System.out.println("What is the name of the set you would like to remove from?");
						String promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.removeFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 2:
						System.out.println("What is the name of the Main Course to remove from the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.MainCourse);
						System.out.println("What is the name of the set you would like to remove from?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.removeFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 3:
						System.out.println("What is the name of the Dessert to remove from the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Dessert);
						System.out.println("What is the name of the set you would like to remove from?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.removeFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					case 4:
						System.out.println("What is the name of the Drink to remove from the Promo?");
						foodName = sc.nextLine();
						food = new FoodItem();
						food.setFoodName(foodName);
						food.setFoodType(FoodItem.FoodType.Drinks);
						System.out.println("What is the name of the set you would like to remove from?");
						promoName = sc.nextLine();
						for (i = 0; i < PromoMgr.setPromoList.size(); i++) {
							if (PromoMgr.setPromoList.get(i).getPromoName() == promoName) {
								PromoMgr.removeFood(food, PromoMgr.setPromoList.get(i));
								PromoMgr.setPromoList.get(i).setPromoPriceFromFood();
							}
						}
					}
				} while (promoChoice > 0 && promoChoice < 5);
				break;

			}

		} while (user_choice > 0 && user_choice < 8);
		// sc.close();
	}

}
