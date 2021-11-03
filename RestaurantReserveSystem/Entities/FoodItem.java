package Entities;

public class FoodItem {
    public enum FoodType {MainCourse, Drinks, Dessert, Appetizer};
    private String foodName;
    private double foodPrice;
    private String foodDesc;
    private FoodType Ftype;
    

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

    public String getFoodName() {
        return this.foodName;
    }

    public double getFoodPrice() {
        return this.foodPrice;
    }

    public String getFoodDesc() {
        return this.foodDesc;
    }

    public FoodType getFoodType() {
        return this.Ftype;
    }

    public void setFoodName(String name) {
        this.foodName = name;
    }

    public void setFoodPrice(double price) {
        this.foodPrice = price;
    }

    public void setFoodDesc(String desc) {
        this.foodDesc = desc;
    }

    public void setFoodType(FoodType type)
    {
        this.Ftype = type;
    }
}

