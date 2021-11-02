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
	    }

	    public void addAppetizer() {
			FileReaderWriter fi1 = new FileReaderWriter();
			try {
				fi1.getAppetizer(this.appet);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	    }

	    public void addDessert() {
			FileReaderWriter fi2 = new FileReaderWriter();
			try {
				fi2.getDessert(this.dessert);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	    }

	    public void addDrink() {
	        FileReaderWriter fi = new FileReaderWriter();
	        try {
				fi.getDrinks(this.drinks);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	    }

	    public void addMainCourse() {
	        FileReaderWriter fi3 = new FileReaderWriter();
			try{
				fi3.getMainCourse(this.mainCourse);
			}
			catch (FileNotFoundException e)
			{
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
				System.out.println();
			}
		}

		public void printAppetizer() {
			int size = this.appet.size();
			for(int i = 0; i < size; i++)
			{
				System.out.println(this.appet.get(i).getFoodName());
				System.out.println(this.appet.get(i).getFoodPrice());
				System.out.println(this.appet.get(i).getFoodDesc());
				System.out.println();
			}
		}

		public void printDessert() {
			int size = this.dessert.size();
			for(int i = 0; i < size; i++)
			{
				System.out.println(this.dessert.get(i).getFoodName());
				System.out.println(this.dessert.get(i).getFoodPrice());
				System.out.println(this.dessert.get(i).getFoodDesc());
				System.out.println();
			}
		}

		public void printMainCourse() {
			int size = this.mainCourse.size();
			for(int i = 0; i < size; i++)
			{
				System.out.println(this.mainCourse.get(i).getFoodName());
				System.out.println(this.mainCourse.get(i).getFoodPrice());
				System.out.println(this.mainCourse.get(i).getFoodDesc());
				System.out.println();
			}
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

