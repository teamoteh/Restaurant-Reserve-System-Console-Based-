package Manager;
import datatxt.FileReaderWriter;

import java.io.FileNotFoundException;
import Entities.FoodItem;
import java.util.ArrayList;

public class MenuMgr {
	
	    protected ArrayList<FoodItem> appet;
	    protected ArrayList<FoodItem> dessert;
	    protected ArrayList<FoodItem> drinks;
	    protected ArrayList<FoodItem> mainCourse;

	    public MenuMgr() {
	        this.appet = new ArrayList<FoodItem>();
	        this.dessert = new ArrayList<FoodItem>();
	        this.mainCourse = new ArrayList<FoodItem>();
	        this.drinks = new ArrayList<FoodItem>();
	        
	        /*this.drinks = new FoodItem[3];
	    	  
	    	  for(int i = 0; i < 3; i++)
	  		{
	  			this.drinks[i] = new FoodItem();
	  		}*/
	    }

	    public void addAppetizer(String name, String price, String description) {
	        FoodItem appetizer = new FoodItem(name, price, description);
	        this.appet.add(appetizer);
	    }

	    public void addDessert(String name, String price, String description) {
	        FoodItem dessert = new FoodItem(name, price, description);
	        this.dessert.add(dessert);
	    }

	    public void addDrink() {
	        FileReaderWriter fi = new FileReaderWriter();
	        try {
				fi.getDrinks(this.drinks);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void printDrinks() {
	    	int size = this.drinks.size();
	    	for(int i = 0; i < size; i++)
	    	{
	    		System.out.println(this.drinks.get(i).getFoodName());
	    		System.out.println(this.drinks.get(i).getFoodPrice());
	    		System.out.println(this.drinks.get(i).getFoodDesc());
	    	}
	    }

	    public void addMainCourse(String name, String price, String description) {
	        FoodItem mainCourse = new FoodItem(name, price, description);
	        this.mainCourse.add(mainCourse);
	    }

	    public void deleteAppet(String name) {
	        for (int i = 0; i < this.appet.size(); i++) {
	            if (this.appet.get(i).getFoodName() == name) {
	                this.appet.remove(i);
	            }
	        }
	    }

	    /*public void deleteDrink(String name) {
	        for (int i = 0; i < this.drink.size(); i++) {
	            if (this.drink.get(i).getFoodName() == name) {
	                this.drink.remove(i);
	            }
	        }
	    }*/

	    public void deleteDessert(String name) {
	        for (int i = 0; i < this.dessert.size(); i++) {
	            if (this.dessert.get(i).getFoodName() == name) {
	                this.dessert.remove(i);
	            }
	        }
	    }

	    public void deleteMainCourse(String name) {
	        for (int i = 0; i < this.mainCourse.size(); i++) {
	            if (this.mainCourse.get(i).getFoodName() == name) {
	                this.mainCourse.remove(i);
	            }
	        }
	    }
	


}

