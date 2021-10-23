package RestaurantReserveSystem;

public class Drink {
    private String drinkName;
    private double drinkPrice;
    private String drinkDesc;

    public Drink(){
        drinkName = null;
        drinkPrice = 0.0;
        drinkDesc = null;
    }

    public Drink(String name, double price){
        this.drinkName = name;
        this.drinkPrice = price;
    }

    public String getDrinkName(){
        return this.drinkName;
    }

    public double getDrinkPrice(){
        return this.drinkPrice;
    }

    public String getDrinkDesc(){
        return this.drinkDesc;
    }

    public void setDrinkName(String name){
        this.drinkName = name;
    }

    public void setDrinkPrice(double price){
        this.drinkPrice = price;
    }

    public void setDrinkDesc(String desc){
        this.drinkDesc = desc;
    }
}