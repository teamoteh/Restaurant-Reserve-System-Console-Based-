package Entities;

import Entities.FoodItem;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents the Set Promos available.
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */

public class SetPromo {
    /**
     * The name of the SetPromo.
     */
    public String promoName;

    /**
     * The price of the SetPromo.
     */
    public double promoPrice;

    /**
     * The description of the SetPromo.
     */
    public String promoDesc;

    /**
     * The List of Food Items in the SetPromo.
     */
    public ArrayList<FoodItem> foodList;

    /**
     * Default constructor.
     */
    public SetPromo() {
        this.promoName = null;
        this.promoPrice = 0;
        this.promoDesc = null;
        this.foodList = new ArrayList<FoodItem>();
    }

    /**
     * Creates a new Set Promo with the given Promo Name, Promo Price, Promo
     * Description and an ArrayList of FoodItems.
     *
     * @param name        This SetPromo's name.
     * @param cost        s SetPromo's cost.
     * @param description s SetPromo's description.
     * @param foodList    s SetPromo's List of Food Items.
     */
    public SetPromo(String name, double cost, String description, ArrayList<FoodItem> foodList) {
        this.promoName = name;
        this.promoPrice = cost;
        this.promoDesc = description;
        this.foodList = foodList;
    }

    /**
     * Gets the name of this Set Promo
     * 
     * @return this Set Promo's name.
     */
    public String getPromoName() {
        return promoName;
    }

    /**
     * Changes the name of this Set Promo.
     * 
     * @param promoName This Set Promo's new name.
     */
    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    /**
     * Gets the price of this Set Promo.
     * 
     * @return this Set Promo's price.
     */
    public double getPromoPrice() {
        return promoPrice;
    }

    /**
     * Changes the price of this Set Promo.
     * 
     * @param promoPrice This Set Promo's new price.
     */
    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    /**
     * Changes the price of this Set Promo from the Food Items.
     * 
     */
    public void setPromoPriceFromFood() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getFoodPrice();
        }
        total *= 0.8;
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        this.promoPrice = bd.doubleValue();
    }

    /**
     * Gets the description of this Set Promo.
     * 
     * @return this Set Promo's descripton.
     */
    public String getPromoDesc() {
        return promoDesc;
    }

    /**
     * Changes the description of this Set Promo.
     * 
     * @param promoDesc This Set Promo's new description.
     */
    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }

    /**
     * Gets the Array of Food Items in this Set Promo.
     * 
     * @return this Set Promo's Food Items.
     */
    public ArrayList<FoodItem> getFoodList() {
        return this.foodList;
    }

    /**
     * Adds a new Food Item to an existing Set Promo.
     * 
     * @param food Food Item to be added into Set Promo.
     */
    public void addFood(FoodItem food) {
        this.foodList.add(food);
    }

    /**
     * Prints all consisting Food Items in the Set Promo.
     * 
     */
    public void printAllFood() {
        System.out.println("The size is : " + foodList.size());
        for (int s = 0; s < foodList.size(); s++) {
            System.out.println(foodList.get(s).getFoodType() + " " + foodList.get(s).getFoodName() + " "
                    + foodList.get(s).getFoodPrice() + " " + foodList.get(s).getFoodDesc());
        }
    }
}