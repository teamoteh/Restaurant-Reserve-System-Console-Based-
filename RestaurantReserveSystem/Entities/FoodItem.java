package Entities;

public class FoodItem {
    public enum FoodType {
        MainCourse, Drinks, Dessert, Appetizer
    };

    protected String foodName;
    protected double foodPrice;
    protected String foodDesc;
    protected FoodType Ftype;

    public FoodItem() {
        this.foodName = null;
        this.foodPrice = 0;
        this.foodDesc = null;
    }

    public FoodItem(String name, double price, String description, FoodType fType) {
        this.foodName = name;
        this.foodPrice = price;
        this.foodDesc = description;
        this.Ftype = fType;
    }

    /**
     * @return String
     */
    public String getFoodName() {
        return this.foodName;
    }

    /**
     * @return double
     */
    public double getFoodPrice() {
        return this.foodPrice;
    }

    /**
     * @return String
     */
    public String getFoodDesc() {
        return this.foodDesc;
    }

    /**
     * @return FoodType
     */
    public FoodType getFoodType() {
        return this.Ftype;
    }

    /**
     * @param name
     */
    public void setFoodName(String name) {
        this.foodName = name;
    }

    /**
     * @param price
     */
    public void setFoodPrice(double price) {
        this.foodPrice = price;
    }

    /**
     * @param desc
     */
    public void setFoodDesc(String desc) {
        this.foodDesc = desc;
    }

    /**
     * @param type
     */
    public void setFoodType(FoodType type) {
        this.Ftype = type;
    }
}
