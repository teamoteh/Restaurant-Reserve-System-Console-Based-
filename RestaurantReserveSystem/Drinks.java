package RestaurantReserveSystem;

public class Drinks {
    private String drinkName;
    private double drinkPrice;

    public Drinks(){
        drinkName = "Water";
        drinkPrice = 0.50;
    }

    public Drinks(String name, double price){
        this.drinkName = name;
        this.drinkPrice = price;
    }

    public String getDrinkName(){
        return this.drinkName;
    }

    public double getDrinkPrice(){
        return this.drinkPrice;
    }
}