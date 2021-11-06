package Entities;

import java.util.ArrayList;

//import enhancements.CusScanner;

public class SetPackage extends FoodItem {

    private ArrayList<FoodItem> foodList;

    public SetPackage(String name, String description, double price) {
        super(name, description, price);
        this.foodList = new ArrayList<FoodItem>();
    }

    public ArrayList<FoodItem> getFoodList() {
        return this.foodList;
    }

    public void addFood(FoodItem foodToAdd) {
        this.foodList.add(foodToAdd);
    }

}