package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Table;
import db.Restaurant;

public class TableMgr {
   
    private static ArrayList<Table> tables = new ArrayList<Table>();

    //FileReader for Tables 
    public void readTables(ArrayList<Table> tables) throws FileNotFoundException
	      {
      		  File file = new File("//datatxt/Table.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	int tableID = Integer.parseInt(sc.next());
		          	int tableMaxSeats = Integer.parseInt(sc.next());
		            
		            Table table = new Table(tableID, tableMaxSeats);
		            tables.add(table);
		      }
		      while(sc.hasNextLine());     
		     sc.close();
	      }
    //not sure if need addRestTables 
    public static void addRestTables(int num){
        for(int i = 0; i < num; i++){
            int nseats;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of seats: ");
            nseats = sc.nextInt();
            tables.add(new Table(i, nseats));
        }
    }

    public static void showTableList(){
        System.out.println(tables);
    }

    public static void deleteRestTables(int index){
        tables.remove(index-1);
        System.out.println("Table %f has been removed.");
    }
}

