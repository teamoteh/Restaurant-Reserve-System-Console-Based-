package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.SetPromo;
import MenuClass.Appetizer;
import MenuClass.Dessert;
import MenuClass.Drink;
import MenuClass.MainCourse;
import Entities.FoodItem;

public class PromoMgr {

    public static ArrayList<SetPromo> setPromoList;

    public static void readStaffs(ArrayList<SetPromo> promoList) throws FileNotFoundException {
        File file = new File("/datatxt/SetPromo.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\s*,\\s*");
        SetPromo set = new SetPromo();
        String itemName, itemDesc;
        double itemPrice;
        FoodType ftype = FoodType.Drinks; // Default value will change if it
        do {
            // Using '~' as a separator between the other Promo Packages
            if (sc.next() != "~") {
                String foodName = sc.next();
                // Identifying the classification of the FoodTypes
                if (foodName == "Appetizer") {
                    ftype = FoodType.Appetizer;
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                    set.updatePromoAppet(itemName, itemPrice, itemDesc);
                    break;
                }
                if (foodName == "Main") {
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    MainCourse course = new MainCourse(itemName, itemPrice, itemDesc);
                    set.updatePromoMain(itemName, itemPrice, itemDesc);
                    break;
                }
                if (foodName == "Drink") {
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    Drink drink = new Drink(itemName, itemPrice, itemDesc);
                    set.updatePromoDrink(itemName, itemPrice, itemDesc);
                    break;
                }
                if (foodName == "Dessert") {
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    Dessert sweet = new Dessert(itemName, itemPrice, itemDesc);
                    set.updatePromoDessert(itemName, itemPrice, itemDesc);
                    break;
                }
            } else {
                setPromoList.add(set);
            }
        } while (sc.hasNextLine());
        sc.close();
    }

    public static void getSetPromo() {
        for (int i = 0; i < setPromoList.size(); i++) {
            SetPromo set = setPromoList.get(i);
            ((SetPromo) set).getPromo();
        }
    }

    public static ArrayList<SetPromo> getPromoList() {
        return setPromoList;
    }

    public void addFood(ArrayList<MenuItem> menuList) {
        int idx = 0;
        int i = 0;
        ArrayList<Integer> mapping = new ArrayList<Integer>();

        if (menuList.size() < 1) {
            System.out.println("There are no items in the menu, You must have at least 1 item in the menu to add");
            return;
        }

        System.out.println();
        System.out.println("Which food would you like to add to the " + this.getName() + " Set Package?");

        for (; i < menuList.size(); i++) {
            if (menuList.get(i) instanceof FoodItem) {
                System.out.println("[" + (idx++ + 1) + "] - " + menuList.get(i).getName());
                mapping.add(i);
            }
        }

        System.out.println();
        int choice = CusScanner.nextInt(1, idx);

        FoodItem foodToAdd = (FoodItem) menuList.get(mapping.get(choice - 1));
        this.foodList.add(foodToAdd);
        System.out.println(foodToAdd.getName() + " was successfully add to " + this.getName() + " Set Package");

    }

    public void removeFood() {
        int idx = 0;

        if (this.foodList.size() < 1) {
            System.out.println(
                    "There are no food items in this set package, You must have at least 1 item in the package to remove");
            return;
        }

        System.out.println();
        System.out.println("Which food would you like to remove from the " + this.getName() + " Set Package?");
        for (FoodItem foodItem : this.foodList)
            System.out.println("[" + (idx++ + 1) + "] - " + foodItem.getName());

        System.out.println();
        int choice = CusScanner.nextInt(1, idx);

        String removedItemName = this.foodList.get(choice - 1).getName();
        this.foodList.remove(choice - 1);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Set Package");
    }
}