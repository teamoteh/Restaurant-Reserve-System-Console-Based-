package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.SetPromo;
import Entities.FoodItem.FoodType;
import MenuClass.Appetizer;
import MenuClass.Dessert;
import MenuClass.Drink;
import MenuClass.MainCourse;
import Entities.FoodItem;
import Manager.MenuMgr;

public class PromoMgr {

    public static ArrayList<SetPromo> setPromoList;

    public static void readPromo(ArrayList<SetPromo> promoList) throws FileNotFoundException {
        File file = new File("RestaurantReserveSystem/datatxt/SetPromo.txt");
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
                    set.addFood(food);
                    break;
                }
                if (foodName == "Main") {
                    ftype = FoodType.MainCourse;
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                    set.addFood(food);
                    ;
                    break;
                }
                if (foodName == "Drink") {
                    ftype = FoodType.Drinks;
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                    set.addFood(food);
                    ;
                    break;
                }
                if (foodName == "Dessert") {
                    ftype = FoodType.Dessert;
                    itemName = sc.next();
                    itemPrice = Double.parseDouble(sc.next());
                    itemDesc = sc.next();
                    FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                    set.addFood(food);
                    ;
                    break;
                }
            } else {
                setPromoList.add(set);
            }
        } while (sc.hasNextLine());
        sc.close();
    }

    public static ArrayList<SetPromo> getPromoList() {
        return setPromoList;
    }

    public static void addFood(FoodItem food, SetPromo set) {
        if (food.getFoodType() == FoodType.Appetizer) {
            for (int i = 0; i < MenuMgr.appet.size(); i++) {
                if (food.getFoodName() == MenuMgr.appet.get(i).getFoodName()) {
                    set.addFood(food);
                    break;
                }
            }
            System.out.println("Food item:" + food.getFoodName() + "is not found in the Menu!");
        }
        if (food.getFoodType() == FoodType.MainCourse) {
            for (int i = 0; i < MenuMgr.mainCourse.size(); i++) {
                if (food.getFoodName() == MenuMgr.mainCourse.get(i).getFoodName()) {
                    set.addFood(food);
                    break;
                }
            }
            System.out.println("Food item:" + food.getFoodName() + "is not found in the Menu!");
        }
        if (food.getFoodType() == FoodType.Drinks) {
            for (int i = 0; i < MenuMgr.drinks.size(); i++) {
                if (food.getFoodName() == MenuMgr.drinks.get(i).getFoodName()) {
                    set.addFood(food);
                    break;
                }
            }
            System.out.println("Food item:" + food.getFoodName() + "is not found in the Menu!");
        }
        if (food.getFoodType() == FoodType.Dessert) {
            for (int i = 0; i < MenuMgr.dessert.size(); i++) {
                if (food.getFoodName() == MenuMgr.dessert.get(i).getFoodName()) {
                    set.addFood(food);
                    break;
                }
            }
            System.out.println("Food item:" + food.getFoodName() + "is not found in the Menu!");
        }
    }

    public static void removeFood(FoodItem food, SetPromo set) {
        for (int i = 0; i < SetPromo.foodList.size(); i++) {
            if (food.getFoodName() == SetPromo.foodList.get(i).getFoodName()) {
                SetPromo.foodList.remove(food);
                break;
            }
        }
        System.out.println("Food item:" + food.getFoodName() + "is not found in the Set Promo!");
    }

    public static void printPromoMenu() {
        for (int s = 0; s < setPromoList.size(); s++) {
            String setName = setPromoList.get(s).getFoodName();
            System.out.println("The Set Promo for today is: \t" + setPromoList.get(s).getFoodName());
            System.out.println("The Set Promo cost is: \t" + setPromoList.get(s).getFoodPrice());
            System.out.println("About this Set Promo: \t" + setPromoList.get(s).getFoodDesc());
            for (int j = 0; j < setPromoList.get(s).foodList.size(); j++) {
                System.out.println("The " + setPromoList.get(s).foodList.get(j).getFoodType() + "in " + setName
                        + " Set Promo for today is: \t" + setPromoList.get(s).foodList.get(j).getFoodName());
            }
        }
    }
}