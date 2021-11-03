package UI;

import java.util.Scanner;
import Manager.MenuMgr;

public class MenuUI {

	public static void displayMenu_UI() {
		Scanner sc = new Scanner (System.in);
	
		System.out.println("What would you like to do?");
       
        System.out.println("1. View Current Menu \n" 
							+ "2. Create Menu Item\n" 
                            + "3. Update Menu Item\n"
                            + "4. Remove Item\n"
							+ "5. Exit\n");
            
        
            System.out.println("Input a choice:");
			int user_choice = sc.nextInt();
			
			switch(user_choice)
			{
				case 1:
					MenuMgr.printMenu();


				case 2:
                    System.out.println("What is the name of the new Menu Item?");
					String name = sc.next();

					System.out.println("What is the price of the new Menu Item?");
					double price = sc.nextDouble();

					System.out.println("What is the description of the new Menu Item?");
					String desc = sc.next();

					System.out.println("What is the type of the new Menu Item? Choose from MainCourse, Drinks, Dessert or Appetizer ");
					String type = sc.next();

					MenuMgr.addToMenu(name, price, desc, type);


				case 3:
					System.out.println("What is the name of the current Menu Item to be updated?");
					String name1 = sc.next();

					System.out.println("What is the name of the updated Menu Item?");
					String newname = sc.next();

					System.out.println("What is the price of the updated Menu Item?");
					double price1 = sc.nextDouble();

					System.out.println("What is the description of the updated Menu Item?");
					String desc1 = sc.next();

					System.out.println("What is the type of the updated Menu Item? Choose from MainCourse, Drinks, Dessert or Appetizer ");
					String type1 = sc.next();

					MenuMgr.updateToMenu(name1, newname, price1, desc1, type1);
					
                    break;

                case 4:
					System.out.println("What is the current Menu Item to be removed?");
					String name3 = sc.next();

					MenuMgr.removeFromMenu(name3);
					
                    break;
					
               default:
					break;
			}
			sc.close();
		}


}

