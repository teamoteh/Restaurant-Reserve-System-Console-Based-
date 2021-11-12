package Entities;

/**
 * A food item to be used in storing menu items
 * 
 * @author Pranwanth
 * @version 1.0
 * @since 2021-11-12
 */
public class FoodItem {
    /**
     * The Food Type that Food item is going to be classified as in Menu
     */
    public enum FoodType {
        MainCourse, Drinks, Dessert, Appetizer
    };

    /**
     * The food item's name.
     */
    protected String foodName;
    /**
     * The food item's price.
     */
    protected double foodPrice;
    /**
     * The food item's description.
     */
    protected String foodDesc;
    /**
     * The food item's type.
     */
    protected FoodType Ftype;

    /**
     * Creates an empty Food item
     */
    public FoodItem() {
        this.foodName = null;
        this.foodPrice = 0;
        this.foodDesc = null;
    }

    /**
     * Creates a Food Item
     * 
     * @param name        Food Item's name
     * @param price       Food Item's price
     * @param description Food Item's Description
     * @param fType       Food Item's Food Type
     */
    public FoodItem(String name, double price, String description, FoodType fType) {
        this.foodName = name;
        this.foodPrice = price;
        this.foodDesc = description;
        this.Ftype = fType;
    }

    /**
     * Gets the Food Item's Name
     * 
     * @return this Food Item's Name
     */
    public String getFoodName() {
        return this.foodName;
    }

    /**
     * Gets the Food Item's Price
     * 
     * @return this Food Item's Price
     */
    public double getFoodPrice() {
        return this.foodPrice;
    }

    /**
     * Gets the Food Item's Description
     * 
     * @return this Food Item's Description
     */
    public String getFoodDesc() {
        return this.foodDesc;
    }

    /**
     * Gets the Food Item's Food Type
     * 
     * @return this Food Item's Food Type
     */
    public FoodType getFoodType() {
        return this.Ftype;
    }

    /**
     * sets this Food Item's Name
     * 
     * @param name
     */
    public void setFoodName(String name) {
        this.foodName = name;
    }

    /**
     * sets this Food Item's Price
     * 
     * @param price
     */
    public void setFoodPrice(double price) {
        this.foodPrice = price;
    }

    /**
     * sets this Food Item's Description
     * 
     * @param desc
     */
    public void setFoodDesc(String desc) {
        this.foodDesc = desc;
    }

    /**
     * Sets this Food Item's Food Type
     * 
     * @param type
     */
    public void setFoodType(FoodType type) {
        this.Ftype = type;
    }
}
