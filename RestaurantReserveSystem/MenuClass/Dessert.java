package RestaurantReserveSystem;

public class Dessert {
    private String dessertName;
    private double dessertPrice;
    private String dessertDesc;

    public Dessert(){
        dessertName = null;
        dessertPrice = 0.0;
        dessertDesc = null;
    }

    public Dessert(String name, double price){
        this.dessertName = name;
        this.dessertPrice = price;
    }

    public String getDessertName(){
        return this.dessertName;
    }

    public double getDessertPrice(){
        return this.dessertPrice;
    }

    public String getDessertDesc(){
        return this.dessertDesc;
    }

    public void setDessertName(String name){
        this.dessertName = name;
    }

    public void setDessertPrice(double price){
        this.dessertPrice = price;
    }

    public void setDessertDesc(String desc){
        this.dessertDesc = desc;
    }
}
