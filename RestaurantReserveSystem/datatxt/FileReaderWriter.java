package datatxt;
import java.io.*;
import java.util.Scanner;
import Entities.FoodItem;
import Entities.Table;
import java.util.ArrayList;

public class FileReaderWriter {
  
	      public FileReaderWriter() {
	    	 
	      }
	      
	      
	      public void getDrinks(ArrayList<FoodItem> drinks) throws FileNotFoundException
	      {
      		  File file = new File("./Drinks.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	String foodName = sc.next();
		          	double foodPrice = sc.nextDouble();
		          	String foodDesc = sc.next();
		            
		            FoodItem drink = new FoodItem(foodName,foodPrice,foodDesc);
		            drinks.add(drink);
		      }
		      while(sc.hasNextLine());     
		     sc.close();
	      }

		public void getAppetizer(ArrayList<FoodItem> appet) throws FileNotFoundException
		{
			File file = new File("./Appetizer.txt");
			Scanner sc = new Scanner(file);
			sc.useDelimiter("\\s*,\\s*");

			do{
				String foodName = sc.next();
				double foodPrice = sc.nextDouble();
				String foodDesc = sc.next();

				FoodItem appetizer = new FoodItem(foodName,foodPrice,foodDesc);
				appet.add(appetizer);
			}
			while(sc.hasNextLine());
			sc.close();
		}

		public void getDessert(ArrayList<FoodItem> desserts) throws FileNotFoundException
		{
			File file = new File("./Dessert.txt");
			Scanner sc = new Scanner(file);
			sc.useDelimiter("\\s*,\\s*");

			do{
				String foodName = sc.next();
				double foodPrice = sc.nextDouble();
				String foodDesc = sc.next();

				FoodItem dessert = new FoodItem(foodName,foodPrice,foodDesc);
				desserts.add(dessert);
			}
			while(sc.hasNextLine());
			sc.close();
		}

	public void getMainCourse(ArrayList<FoodItem> mainCourses) throws FileNotFoundException
	{
		File file = new File("./MainCourse.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do{
			String foodName = sc.next();
			double foodPrice = sc.nextDouble();
			String foodDesc = sc.next();

			FoodItem mainCourse = new FoodItem(foodName,foodPrice,foodDesc);
			mainCourses.add(mainCourse);
		}
		while(sc.hasNextLine());
		sc.close();
	}

		  public void getReservation(ArrayList<Table> tables) throws FileNotFoundException
	      {
      		  File file = new File("./Reservation.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	int numOfPax = sc.nextInt();
		          	String custName = sc.next();
		          	int custContact = sc.nextInt();
					String reserveTime = sc.next();
					String reserveDate = sc.next();
		            
		            Table table = new Table(numOfPax,  custName,  custContact,  reserveTime,  reserveDate);
					// Shouldn't this be Reservation not table?
		            tables.add(table);
		      }
		      while(sc.hasNextLine());     
		     sc.close();
	      }

		  
		  
	      /*Things to implement
	       * getReservation
	       * getTable
	       * getOrder
	       * getAppetizer
	       * getMainCourse
	       * getDessert
	       * getStaff
	       * getSetPromo
	       */
	      
	     
}

