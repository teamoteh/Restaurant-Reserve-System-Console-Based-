package RestaurantReserveSystem;

import java.util.ArrayList;

public class Menu {
    protected ArrayList<FoodItem> appet;
    protected ArrayList<FoodItem> dessert;
    protected ArrayList<FoodItem> drink;
    protected ArrayList<FoodItem> mainCourse;

    public Menu() {
        this.appet = new ArrayList<FoodItem>();
        this.dessert = new ArrayList<FoodItem>();
        this.drink = new ArrayList<FoodItem>();
        this.mainCourse = new ArrayList<FoodItem>();
    }

    public void addAppetizer(String name, double price, String description) {
        FoodItem appetizer = new FoodItem(name, price, description);
        this.appet.add(appetizer);
    }

    public void addDessert(String name, double price, String description) {
        FoodItem dessert = new FoodItem(name, price, description);
        this.dessert.add(dessert);
    }

    public void addDrink(String name, double price, String description) {
        FoodItem drink = new FoodItem(name, price, description);
        this.drink.add(drink);
    }

    public void addMainCourse(String name, double price, String description) {
        FoodItem mainCourse = new FoodItem(name, price, description);
        this.mainCourse.add(mainCourse);
    }

    public void deleteAppet(String name) {
        for (int i = 0; i < this.appet.size(); i++) {
            if (this.appet.get(i).getFoodName() == name) {
                this.appet.remove(i);
            }
        }
    }

    public void deleteDrink(String name) {
        for (int i = 0; i < this.drink.size(); i++) {
            if (this.drink.get(i).getFoodName() == name) {
                this.drink.remove(i);
            }
        }
    }

    public void deleteDessert(String name) {
        for (int i = 0; i < this.dessert.size(); i++) {
            if (this.dessert.get(i).getFoodName() == name) {
                this.dessert.remove(i);
            }
        }
    }

    public void deleteMainCourse(String name) {
        for (int i = 0; i < this.mainCourse.size(); i++) {
            if (this.mainCourse.get(i).getFoodName() == name) {
                this.mainCourse.remove(i);
            }
        }
    }
}
