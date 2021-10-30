package Entities;

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

    public void updatePromoAppet(String appetName, double appetPrice){
        this.appet = new Appetizer(appetName, appetPrice);
    }

    public void updatePromoDrink(String drinkName, double drinkPrice){
        this.drink = new Drink(drinkName, drinkPrice);
    }

    public void updatePromoDessert(String dessertName, double dessertPrice){
        this.dessert = new Dessert(dessertName, dessertPrice);
    }

    public void updatePromoMain(String mainName, double mainPrice){
        this.main = new MainCourse(mainName, mainPrice);
    }

    protected double totalCost(Appetizer appet, Dessert dessert, MainCourse main, Drink drink){
        double total = 0;
        total += appet.getAppetPrice();
        total += dessert.getDessertPrice();
        total += main.getCoursePrice();
        total += drink.getDrinkPrice();

        total *= DISC;
        this.totalCost = total;

        return total;
    }

    public void getPromo(){
        System.out.printf("The set promo for today is:\n");
        if(appet.getAppetName() != null){
            System.out.printf("Appetizer: %s, %s\n", appet.getAppetName(), appet.getAppetDesc());
        }
        if(main.getCourseName() != null){
            System.out.printf("Course: %s, %s\n", main.getCourseName(), main.getCourseDesc());
        }
        if(dessert.getDessertName() != null){
            System.out.printf("Dessert: %s, %s\n", dessert.getDessertName(), dessert.getDessertDesc());
        }
        if(drink.getDrinkName() != null){
            System.out.printf("Drinks to go: %s, %s\n", drink.getDrinkName(), drink.getDrinkDesc());
        }        
    }
}
