package Entities;

public class FoodItem {
    private String foodName;
    private String foodPrice;
    private String foodDesc;

    public FoodItem() {
        this.foodName = null;
        this.foodPrice = null;
        this.foodDesc = null;
    }

    public FoodItem(String name, String price, String description) {
        this.foodName = name;
        this.foodPrice = price;
        this.foodDesc = description;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public String getFoodPrice() {
        return this.foodPrice;
    }

    public String getFoodDesc() {
        return this.foodDesc;
    }

    public void setFoodName(String name) {
        this.foodName = name;
    }

    public void setFoodPrice(String price) {
        this.foodPrice = price;
    }

    public void setFoodDesc(String desc) {
        this.foodDesc = desc;
    }
}

