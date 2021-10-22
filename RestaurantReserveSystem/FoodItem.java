package RestaurantReserveSystem;

public class FoodItem {
    private String foodName;
    private double foodPrice;
    private String foodDesc;

    public food()
    {
        this.foodName = null;
        this.foodDesc = null;
        this.foodPrice = 0;
    }

    public food(String name, double price, String description){
        this.foodName = name;
        this.foodPrice = price;
        this.foodDesc = description;

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

    public void setFoodName(String name) {
        this.foodName = name;
    }

    public void setFoodPrice(double price) {
        this.foodPrice = price;
    }

    public void setFoodDesc(String desc) {
        this.foodDesc = desc;
    }
}
