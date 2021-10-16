package RestaurantReserveSystem;

public class Appetizer {
    private String appetName;
    private double appetPrice;
    private String appetDesc;

    //default constructor
    public Appetizer(){
        appetName = null;
        appetPrice = 0.0;
        appetDesc = null;
    }

    //contructor
    public Appetizer(String name, double price){
        this.appetName = name;
        this.appetPrice = price;
    }

    //get methods
    public String getAppetName(){
        return this.appetName;
    }

    public double getAppetPrice(){
        return this.appetPrice;
    }

    public String getAppetDesc(){
        return this.appetDesc;
    }

    //set methods
    public void setAppetName(String name){
        this.appetName = name;
    }

    public void setAppetPrice(double price){
        this.appetPrice = price;
    }

    public void setAppetDesc(String desc){
        this.appetDesc = desc;
    }
}
