package Entities;

import Entities.FoodItem;
import java.util.ArrayList;

public class SetPromo {

    public String promoName;
    public double promoPrice;
    public ArrayList<FoodItem> foodList;
    public String promoDesc;

    public SetPromo() {
        this.promoName = null;
        this.promoPrice = 0;
        this.promoDesc = null;
        this.foodList = new ArrayList<FoodItem>();
    }

    public SetPromo(String name, double cost, String description, ArrayList<FoodItem> foodList) {
        this.promoName = name;
        this.promoPrice = cost;
        this.promoDesc = description;
        this.foodList = foodList;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public void setPromoPriceFromFood() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getFoodPrice();
        }
        total *= 0.8;
        this.promoPrice = total;
    }

    public String getPromoDesc() {
        return promoDesc;
    }

    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }

    public ArrayList<FoodItem> getFoodList() {
        return this.foodList;
    }

    public void addFood(FoodItem food) {
        this.foodList.add(food);
    }

    public void dropAllFood() {
        for (int i = 0; i < foodList.size(); i++) {
            foodList.remove(i);
        }
    }
}