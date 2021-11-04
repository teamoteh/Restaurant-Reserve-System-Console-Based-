package datatxt;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import Entities.FoodItem;
import Entities.Reservation;
import Entities.Table;
import Manager.TableMgr;

import java.util.ArrayList;

public class FileReaderWriter {
  
	    public FileReaderWriter() {
	    	 
	    }
	     public void write(String address, String text) throws IOException {
    		try{
				FileWriter fw = new FileWriter(address, true);
    			BufferedWriter bw = new BufferedWriter(fw);
    			PrintWriter out = new PrintWriter(bw);
				out.println(text);
				out.close();
    			//more code
				} catch (IOException e) {
    			//exception handling left as an exercise for the reader
				}
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
					FoodItem.FoodType fType = FoodItem.FoodType.Drinks;
		            
		            FoodItem drink = new FoodItem(foodName,foodPrice,foodDesc, fType);
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
				FoodItem.FoodType fType = FoodItem.FoodType.Appetizer;

				FoodItem appetizer = new FoodItem(foodName,foodPrice,foodDesc, fType);
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
				FoodItem.FoodType fType = FoodItem.FoodType.Dessert;

				FoodItem dessert = new FoodItem(foodName,foodPrice,foodDesc, fType);
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
			FoodItem.FoodType fType = FoodItem.FoodType.MainCourse;

			FoodItem mainCourse = new FoodItem(foodName,foodPrice,foodDesc,fType);
			mainCourses.add(mainCourse);
		}
		while(sc.hasNextLine());
		sc.close();
	}

		  public static void getReservation(ArrayList<Reservation> Reservations) throws FileNotFoundException
	      {
      		  File file = new File("/Users/ASUS/OneDrive/Documents/GitHub/Restaurant-Reserve-System-Console-Based-/RestaurantReserveSystem/datatxt/Reservation.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	int numOfPax = Integer.parseInt(sc.next());
		          	String custName = sc.next();
		          	int custContact = Integer.parseInt(sc.next());
					LocalTime reserveTime = LocalTime.parse(sc.next());
					LocalDate reserveDate = LocalDate.parse(sc.next());
					Table table = TableMgr.assignTable(numOfPax);
		            
		            Reservation r = new Reservation(reserveTime,  reserveDate,numOfPax,  custName,  custContact, table);
	
		            Reservations.add(r);
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

