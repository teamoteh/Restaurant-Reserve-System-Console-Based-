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

    public static ArrayList<SetPromo> setPromoList = new ArrayList<SetPromo>();

    public static ArrayList<SetPromo> getPromoList() {
        return setPromoList;
    }

    public static void readPromo(ArrayList<SetPromo> promoList) throws FileNotFoundException {
        File file = new File("RestaurantReserveSystem/datatxt/SetPromo.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\s*,\\s*");
        SetPromo set = new SetPromo();
        String terminator = "End";
        String itemName, itemDesc, promoName, promoDesc;
        double itemPrice, promoPrice;
        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
        FoodType ftype = null; // Default value will change if it
        do {
            // Using '~' as a separator between the other Promo Packages
            promoName = sc.next();
            System.out.println("promoName: " + promoName);
            set.setPromoName(promoName);
            promoPrice = Double.parseDouble(sc.next());
            System.out.println("promoPrice: " + promoPrice);
            set.setPromoPrice(promoPrice);
            promoDesc = sc.next();
            System.out.println("promoDesc: " + promoDesc);
            set.setPromoDesc(promoDesc);
            String foodType = sc.next();
            boolean check = true;
            while (check) {
                // Identifying the classification of the FoodTypes

                for (int i = 0; i < FoodType.values().length; i++) {
                    if (FoodType.values()[i].toString().equals(foodType)) {
                        ftype = FoodType.values()[i];
                    }
                }
                itemName = sc.next();
                itemPrice = Double.parseDouble(sc.next());
                itemDesc = sc.next();
                System.out.println("This has been added: " + itemName + " " + itemPrice + " " + itemDesc);
                FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                set.addFood(food);
                foodType = sc.next();

                if (foodType.equals("End")) {
                    check = false;
                }
            }

            setPromoList.add(set);
            set.dropAllFood();
        } while (sc.hasNextLine());
        // sc.close();
    }

    public static void addFood(FoodItem food, SetPromo set) {
        if (food.getFoodType() == FoodType.Appetizer) {
            for (int i = 0; i < MenuMgr.appet.size(); i++) {
                if (food.getFoodName() == MenuMgr.appet.get(i).getFoodName()) {
                    set.addFood(MenuMgr.appet.get(i));
                    return;
                }
            }
        }
        if (food.getFoodType() == FoodType.MainCourse) {
            for (int i = 0; i < MenuMgr.mainCourse.size(); i++) {
                if (food.getFoodName() == MenuMgr.mainCourse.get(i).getFoodName()) {
                    set.addFood(MenuMgr.mainCourse.get(i));
                    return;
                }
            }
        }
        if (food.getFoodType() == FoodType.Drinks) {
            for (int i = 0; i < MenuMgr.drinks.size(); i++) {
                if (food.getFoodName() == MenuMgr.drinks.get(i).getFoodName()) {
                    set.addFood(MenuMgr.drinks.get(i));
                    return;
                }
            }
        }
        if (food.getFoodType() == FoodType.Dessert) {
            for (int i = 0; i < MenuMgr.dessert.size(); i++) {
                if (food.getFoodName() == MenuMgr.dessert.get(i).getFoodName()) {
                    set.addFood(MenuMgr.dessert.get(i));
                    return;
                }
            }
        }
        System.out.println("Food item:" + food.getFoodName() + "is not found in the Menu!");
    }

    public static void removeFood(FoodItem food, SetPromo set) {
        for (int i = 0; i < set.foodList.size(); i++) {
            if (food.getFoodName() == set.foodList.get(i).getFoodName()) {
                set.foodList.remove(food);
                return;
            }
        }
        System.out.println("Food item:" + food.getFoodName() + "is not found in the Set Promo!");
    }

    public static void printPromoMenu() {
        for (int s = 0; s < setPromoList.size(); s++) {
            String setName = setPromoList.get(s).getPromoName();
            System.out.println("The Set Promo for today is: \t" + setPromoList.get(s).getPromoName());
            System.out.println("The Set Promo cost is: \t" + setPromoList.get(s).getPromoPrice());
            System.out.println("About this Set Promo: \t" + setPromoList.get(s).getPromoDesc());
            for (int j = 0; j < setPromoList.get(s).foodList.size(); j++) {
                System.out.println("The " + setPromoList.get(s).foodList.get(j).getFoodType() + "in " + setName
                        + " Set Promo for today is: \t" + setPromoList.get(s).foodList.get(j).getFoodName());
            }
        }
    }
}

/*
 * if (sc.next() == "Main") { ftype = FoodType.MainCourse; itemName = sc.next();
 * itemPrice = Double.parseDouble(sc.next()); itemDesc = sc.next();
 * System.out.println("This has been added: " + itemName); FoodItem food = new
 * FoodItem(itemName, itemPrice, itemDesc, ftype); set.addFood(food); }
 * 
 * if (sc.next() == "Drink") { ftype = FoodType.Drinks; itemName = sc.next();
 * itemPrice = Double.parseDouble(sc.next()); itemDesc = sc.next();
 * System.out.println("This has been added: " + itemName); FoodItem food = new
 * FoodItem(itemName, itemPrice, itemDesc, ftype); set.addFood(food);
 * 
 * } if (sc.next() == "Dessert") { ftype = FoodType.Dessert; itemName =
 * sc.next(); itemPrice = Double.parseDouble(sc.next()); itemDesc = sc.next();
 * System.out.println("This has been added: " + itemName); FoodItem food = new
 * FoodItem(itemName, itemPrice, itemDesc, ftype); set.addFood(food); }
 */