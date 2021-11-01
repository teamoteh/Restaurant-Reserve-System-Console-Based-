package datatxt;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.FoodItem;

public class FileReaderWriter {
  
	      public FileReaderWriter() {
	    	 
	      }
	      
	      
	      public void getDrinks(ArrayList<FoodItem> drinks) throws FileNotFoundException
	      {
      		  File file = new File("/Users/pranwanth/eclipse-workspace/assignmentTest/src/assignmentTest/drinks.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	String foodname = sc.next();
		          	String foodprice = sc.next();
		          	String fooddesc = sc.next();
		            
		            FoodItem drink = new FoodItem(foodname,foodprice,fooddesc);
		            drinks.add(drink);
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

