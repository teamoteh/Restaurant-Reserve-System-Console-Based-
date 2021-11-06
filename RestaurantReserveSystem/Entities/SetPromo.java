package Entities;
import Entities.FoodItem ;
import java.util.ArrayList;

//import enhancements.CusScanner;

public class SetPromo extends FoodItem {

    // public static ArrayList<FoodItem> foodList;
    public static ArrayList<FoodItem> foodList;

    public SetPromo(){
        super();
    }

    public SetPromo(String name, double cost, String description, FoodType type) {
        super(name, cost, description, type);
        this.foodList = new ArrayList<FoodItem>();
    }

    public ArrayList<FoodItem> getFoodList() {
        return this.foodList;
    }

    public void addFood(FoodItem foodToAdd) {
        this.foodList.add(foodToAdd);
    }

    public void setCost(){
        double total = 0;
        for(int i = 0; i < foodList.size(); i++){
            total += foodList.get(i).getFoodPrice();
        }
        total *= 0.8;
        this.foodPrice = total;
    }

    public double getCost(){
        return foodPrice;
    }

}