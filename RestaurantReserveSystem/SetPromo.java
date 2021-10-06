package RestaurantReserveSystem;

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

    private double totalCost(Appetizer appet, Dessert dessert, MainCourse main, Drink drink){
        double total = 0;
        total += appet.getAppetPrice();
        total += dessert.getDessertPrice();
        total += main.getCoursePrice();
        total += drink.getDrinkPrice();

        total *= DISC;

        return total;
    }

    public void getPromo(){
        if(appet.getAppetName() != null){
            if(main.getCourseName() != null){
                if(dessert.getDessertName() != null){
                    if(drink.getDrinkName() != null){
                        System.out.printf("The set promo for today is:\n");
                        System.out.printf("Appetizer: %s, %s\n", appet.getAppetName(), appet.getAppetDesc());
                        System.out.printf("Course: %s, %s\n", main.getCourseName(), main.getCourseDesc());
                        System.out.printf("Dessert: %s, %s\n", dessert.getDessertName(), dessert.getDessertDesc());
                        System.out.printf("Drinks to go: %s, %s\n", drink.getDrinkName(), drink.getDrinkDesc());
                    }
                    else{
                        System.out.printf("The set promo for today is:\n");
                        System.out.printf("Appetizer: %s, %s\n", appet.getAppetName(), appet.getAppetDesc());
                        System.out.printf("Course: %s, %s \n", main.getCourseName(), main.getCourseDesc());
                        System.out.printf("Dessert: %s, %s \n", dessert.getDessertName(), dessert.getDessertDesc());
                    }
                }
                else{
                    System.out.printf("The set promo for today is:\n");
                        System.out.printf("Appetizer: %s, %s\n", appet.getAppetName(), appet.getAppetDesc());
                        System.out.printf("Course: %s, %s\n", main.getCourseName(), main.getCourseDesc());
                }
            }
            else{
                System.out.printf("The set promo for today is:");
                        System.out.printf("Appetizer: %s, %s\n", appet.getAppetName(), appet.getAppetDesc());
            }
        }
    }
}
