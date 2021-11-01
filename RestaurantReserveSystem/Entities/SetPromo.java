package Entities;
import MenuClass.Appetizer;
import MenuClass.Dessert;
import MenuClass.Drink;
import MenuClass.MainCourse;
public class SetPromo {
    private static final double DISC = 0.2;

    public Appetizer appet;
    public Dessert dessert;
    public Drink drink;
    public MainCourse main;
    public double totalCost;

    public SetPromo(){
        appet = new Appetizer();
        dessert = new Dessert();
        drink = new Drink();
        main = new MainCourse();
        totalCost = 0;
    }

    public void updatePromoAppet(String name, double price, String description) {
        this.appet = new Appetizer(name, price, description);
    }

    public void updatePromoDrink(String name, double price, String description) {
        this.drink = new Drink(name, price, description);
    }

    public void updatePromoDessert(String name, double price, String description) {
        this.dessert = new Dessert(name, price, description);
    }

    public void updatePromoMain(String name, double price, String description) {
        this.main = new MainCourse(name, price, description);
    }

    protected double totalCost(Appetizer appet, Dessert dessert, MainCourse main, Drink drink){
        double total = 0;
        total += appet.getFoodPrice();
        total += dessert.getFoodPrice();
        total += main.getFoodPrice();
        total += drink.getFoodPrice();

        total *= DISC;
        this.totalCost = total;

        return total;
    }

    public void getPromo(){
        System.out.printf("The set promo for today is:\n");
        if(appet.getFoodName() != null){
            System.out.printf("Appetizer: %s, %s\n", appet.getFoodName(), appet.getFoodDesc());
        }
        if(main.getFoodName() != null){
            System.out.printf("Course: %s, %s\n", main.getFoodName(), main.getFoodDesc());
        }
        if(dessert.getFoodName() != null){
            System.out.printf("Dessert: %s, %s\n", dessert.getFoodName(), dessert.getFoodDesc());
        }
        if(drink.getFoodName() != null){
            System.out.printf("Drinks to go: %s, %s\n", drink.getFoodName(), drink.getFoodDesc());
        }        
    }
}
