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
            set = new SetPromo();
            promoName = sc.next();
            set.setPromoName(promoName);
            promoPrice = Double.parseDouble(sc.next());
            set.setPromoPrice(promoPrice);
            promoDesc = sc.next();
            set.setPromoDesc(promoDesc);
            String foodType = sc.next();
            boolean check = true;
            while (check) {
                // Identifying the classification of the FoodTypes

                for (int i = 0; i < FoodType.values().length; i++) {
                    if (FoodType.values()[i].toString().equals(foodType)) {
                        ftype = FoodType.values()[i];
                        break;
                    }
                }
                itemName = sc.next();
                itemPrice = Double.parseDouble(sc.next());
                itemDesc = sc.next();
                //System.out.println("This has been scanned : " + ftype + " " + itemName + " " + itemPrice + " " + itemDesc);
                FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);
                
                set.addFood(food);
                //System.out.println("This food has been added  : " + food.getFoodName() + " at index : " + set.foodList.indexOf(food));
                foodType = sc.next();

                if (foodType.equals("End")) {
                    check = false;
                }
            }
            setPromoList.add(set);
            //set.dropAllFood();
        } while (sc.hasNextLine());
        // sc.close();
    }
    
    public static void createSetPromo(String setName, String setDes, int numOfFood){
        FoodType ftype = null;
        SetPromo newSet = new SetPromo();
        newSet.setPromoName(setName);
        newSet.setPromoDesc(setDes);

        for (int i = 0; i < numOfFood; i ++){
            boolean flag = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("What is the name of Food Item " + (i+1) + " to add?");
            String name = scan.nextLine();

            System.out.println("What is the Food Type of Food Item " + (i+1) + " to add?");
            System.out.println("-----------------------------------------------");
            System.out.println("Appetizer, MainCourse, Drinks, Dessert");
            String type = scan.nextLine();
            for (int j = 0; j < FoodType.values().length; j++) {
                if (FoodType.values()[j].toString().equals(type)) {
                    ftype = FoodType.values()[j];
                    break;
                }
            }

            if (ftype == FoodType.Appetizer) {
                for (int j = 0; j < MenuMgr.appet.size(); j++) {
                    if (name.equals(MenuMgr.appet.get(j).getFoodName())) {
                        newSet.addFood(MenuMgr.appet.get(j));
                        flag = true;
                        break;
                    }
                }
            }
            if (ftype == FoodType.MainCourse) {
                for (int j = 0; j < MenuMgr.mainCourse.size(); j++) {
                    if (name.equals(MenuMgr.mainCourse.get(j).getFoodName())) {
                        newSet.addFood(MenuMgr.mainCourse.get(j));
                        flag = true;
                        break;
                    }
                }
            }
            if (ftype == FoodType.Drinks) {
                for (int j = 0; j < MenuMgr.drinks.size(); j++) {
                    if (name.equals(MenuMgr.drinks.get(j).getFoodName())) {
                        newSet.addFood(MenuMgr.drinks.get(j));
                        flag = true;
                        break;
                    }
                }
            }
            if (ftype == FoodType.Dessert) {
                for (int j = 0; j < MenuMgr.dessert.size(); i++) {
                    if (name.equals(MenuMgr.dessert.get(j).getFoodName())) {
                        newSet.addFood(MenuMgr.dessert.get(j));
                        flag = true;
                        break;
                    }
                }
            }
            
            if(!flag){
                System.out.println("The " + name + " Food Item is not found in the Menu!");
                System.out.println("Please try again!");
                i--;
            }
        }
        newSet.setPromoPriceFromFood();
        setPromoList.add(newSet);
    }

    public static void addFood(String foodName, String type, String setName) {
        FoodType ftype = null; // Default value will change if it is something else
		for (int i = 0; i < FoodType.values().length; i++) {
			if (FoodType.values()[i].toString().equals(type)) {
				ftype = FoodType.values()[i];
			}
		}
        
        if (ftype == null) {
			System.out.println("Invalid Food Type, please try again!");
			return;
		}

        FoodItem item = new FoodItem();
        item.setFoodName(foodName);
        item.setFoodType(ftype);

        for(int i = 0; i < setPromoList.size(); i++){
            if(setPromoList.get(i).getPromoName().equals(setName)){
                if (ftype == FoodType.Appetizer) {
                    for (int j = 0; j < MenuMgr.appet.size(); j++) {
                        if (item.getFoodName().equals(MenuMgr.appet.get(j).getFoodName())) {
                            setPromoList.get(i).addFood(MenuMgr.appet.get(j));
                            setPromoList.get(i).setPromoPriceFromFood();
                            System.out.println(foodName + " has been added to the Set Promo: " + setName);
                            System.out.println("");
                            return;
                        }
                    }
                }
                if (ftype == FoodType.MainCourse) {
                    for (int j = 0; i < MenuMgr.mainCourse.size(); i++) {
                        if (item.getFoodName().equals(MenuMgr.mainCourse.get(j).getFoodName())) {
                            setPromoList.get(i).addFood(MenuMgr.mainCourse.get(j));
                            setPromoList.get(i).setPromoPriceFromFood();
                            System.out.println(foodName + " has been added to the Set Promo: " + setName);
                            System.out.println("");
                            return;
                        }
                    }
                }
                if (ftype == FoodType.Drinks) {
                    for (int j = 0; i < MenuMgr.drinks.size(); i++) {
                        if (item.getFoodName().equals(MenuMgr.drinks.get(j).getFoodName())) {
                            setPromoList.get(i).addFood(MenuMgr.drinks.get(j));
                            setPromoList.get(i).setPromoPriceFromFood();
                            System.out.println(foodName + " has been added to the Set Promo: " + setName);
                            System.out.println("");
                            return;
                        }
                    }
                }
                if (ftype == FoodType.Dessert) {
                    for (int j = 0; i < MenuMgr.dessert.size(); i++) {
                        if (item.getFoodName().equals(MenuMgr.dessert.get(j).getFoodName())) {
                            setPromoList.get(i).addFood(MenuMgr.dessert.get(j));
                            setPromoList.get(i).setPromoPriceFromFood();
                            System.out.println(foodName + " has been added to the Set Promo: " + setName);
                            System.out.println("");
                            return;
                        }
                    }
                }   
            }
        }
        
        System.out.println("Food item:" + foodName + " is not found in the Menu!");
        System.out.println("");
    }

    public static void removeFood(String name, String setName) {
        for(int i = 0; i < setPromoList.size(); i++){
            if(setPromoList.get(i).getPromoName().equals(setName)){
                for(int j = 0; j < setPromoList.get(i).foodList.size(); j++){
                    if(setPromoList.get(i).foodList.get(j).getFoodName().equals(name)){
                        FoodItem food = setPromoList.get(i).foodList.get(j);
                        setPromoList.get(i).foodList.remove(food);
                        setPromoList.get(i).setPromoPriceFromFood();
                        System.out.println(name + " has been removed from " + setName + " Set Promo");
                        System.out.println("");
                        return;
                    }
                }
                System.out.println("Set Promo " + setName + " does not have " + name + " Food Item!");
                System.out.println("");
                return;
            }
        }
        System.out.println("There is no Set Promo with name " + setName);
        System.out.println("");
        return;
        /* for (int i = 0; i < set.foodList.size(); i++) {
            if (food.getFoodName() == set.foodList.get(i).getFoodName()) {
                set.foodList.remove(food);
                return;
            }
        }*/
    }

    public static void printPromoMenu() {
        System.out.println("");
        for (int s = 0; s < setPromoList.size(); s++) {
            String setName = setPromoList.get(s).getPromoName();
            //System.out.println("There are this many Set Promos: \t\t" + setPromoList.size());
            System.out.println("The Set Promo for today is: \t" + setPromoList.get(s).getPromoName());
            System.out.println("The Set Promo cost is: \t\t" + setPromoList.get(s).getPromoPrice());
            System.out.println("About this Set Promo: \t\t" + setPromoList.get(s).getPromoDesc());
            //System.out.println("There are this many food items: \t\t" + setPromoList.get(s).foodList.size());
            for (int j = 0; j < setPromoList.get(s).foodList.size(); j++) {
                System.out.println("The " + setPromoList.get(s).foodList.get(j).getFoodType() + " in " + setName
                        + " Set Promo is: \t" + setPromoList.get(s).foodList.get(j).getFoodName());
            }
            System.out.println("");
        }
        System.out.println("");
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