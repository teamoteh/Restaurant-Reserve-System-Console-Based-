package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.SetPromo;
import Entities.FoodItem.FoodType;
import Entities.FoodItem;
import Manager.MenuMgr;

/**
 * Represents the class which manages anything related to the Set Promos in the
 * restaurant.
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class PromoMgr {

    /**
     * The array list containing all the Set Promos and their attributes in the
     * restaurant.
     */
    public static ArrayList<SetPromo> setPromoList = new ArrayList<SetPromo>();

    /**
     * Gets the Array List of Set Promos
     * 
     * @return ArrayList<Reservation>
     */
    public static ArrayList<SetPromo> getPromoList() {
        return setPromoList;
    }

    /**
     * File Reader function to read data in the Set Promo txt file and stores the
     * values and its relative attributes in the Array List
     * 
     * @param promoList The Array List to store attributes.
     */
    public static void readPromo(ArrayList<SetPromo> promoList) throws FileNotFoundException {
        File file = new File("RestaurantReserveSystem/datatxt/SetPromo.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\s*,\\s*");
        SetPromo set = new SetPromo();
        String terminator = "End";
        String itemName, itemDesc, promoName, promoDesc;
        double itemPrice, promoPrice;
        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
        FoodType ftype = null; // Default value
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
                for (int i = 0; i < FoodType.values().length; i++) {
                    if (FoodType.values()[i].toString().equals(foodType)) {
                        ftype = FoodType.values()[i];
                        break;
                    }
                }
                itemName = sc.next();
                itemPrice = Double.parseDouble(sc.next());
                itemDesc = sc.next();
                FoodItem food = new FoodItem(itemName, itemPrice, itemDesc, ftype);

                set.addFood(food);
                foodType = sc.next();

                if (foodType.equals("End")) {
                    check = false;
                }
            }
            setPromoList.add(set);
        } while (sc.hasNextLine());
        // sc.close();
    }

    /**
     * Creates a new Set Promo and adds it to the Array List.
     * 
     * @param setName   This new Set Promo's name.
     * @param setDes    This new Set Promo's description.
     * @param numofFood The number of Food Item's in this new Set Promo.
     */
    public static void createSetPromo(String setName, String setDes, int numOfFood) {
        FoodType ftype = null;
        SetPromo newSet = new SetPromo();
        newSet.setPromoName(setName);
        newSet.setPromoDesc(setDes);

        for (int i = 0; i < numOfFood; i++) {
            boolean flag = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("What is the name of Food Item " + (i + 1) + " to add?");
            String name = scan.nextLine();

            System.out.println("What is the Food Type of Food Item " + (i + 1) + " to add?");
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

            if (!flag) {
                System.out.println("The " + name + " Food Item is not found in the Menu!");
                System.out.println("Please try again!");
                i--;
            }
        }
        newSet.setPromoPriceFromFood();
        setPromoList.add(newSet);
    }

    /**
     * Adds a new Food Item in the specified Set Promo.
     * 
     * @param foodName Name of Food Item to be added.
     * @param type     Type of the new Foot Item to be added.
     * @param setName  The name of the Set Promo to add Food Item.
     */
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

        for (int i = 0; i < setPromoList.size(); i++) {
            if (setPromoList.get(i).getPromoName().equals(setName)) {
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

    /**
     * Removes a Food Item from the Set Promo.
     * 
     * @param name    The name of the Food Item to be removed.
     * @param setName The name of the Set Promo for Food Item to be removed.
     */
    public static void removeFood(String name, String setName) {
        for (int i = 0; i < setPromoList.size(); i++) {
            if (setPromoList.get(i).getPromoName().equals(setName)) {
                for (int j = 0; j < setPromoList.get(i).foodList.size(); j++) {
                    if (setPromoList.get(i).foodList.get(j).getFoodName().equals(name)) {
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
    }

    /**
     * Prints the Set Promos available in the Restaurant
     * 
     */
    public static void printPromoMenu() {
        System.out.println("");
        /*
         * for (int s = 0; s < appet.size(); s++) { System.out.printf("%s%s%s",
         * String.format("%-20s", appet.get(s).getFoodName()), String.format("%-20s",
         * Double.toString(appet.get(s).getFoodPrice())), String.format("%-20s",
         * appet.get(s).getFoodDesc())); System.out.println(); }
         */
        for (int s = 0; s < setPromoList.size(); s++) {
            String setName = setPromoList.get(s).getPromoName();
            System.out.printf("%s%s%s", String.format("%-20s", setPromoList.get(s).getPromoName()),
                    String.format("%-20s", Double.toString(setPromoList.get(s).getPromoPrice())),
                    String.format("%-20s", setPromoList.get(s).getPromoDesc()));
            System.out.println();
            System.out.println("=============================================================");
            for (int j = 0; j < setPromoList.get(s).foodList.size(); j++) {
                System.out.printf("%s%s%s", String.format("%-20s", setPromoList.get(s).foodList.get(j).getFoodName()),
                        String.format("%-20s", setPromoList.get(s).foodList.get(j).getFoodType()),
                        String.format("%-20s", setPromoList.get(s).foodList.get(j).getFoodDesc()));
                System.out.println();
            }
            System.out.println("=============================================================");
            System.out.println("");
        }
        System.out.println("");
    }
}