package Manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Table;
//import db.Restaurant;

public class TableMgr {
   
    private static ArrayList<Table> tables = new ArrayList<Table>();

    //FileReader for Tables 
    public void readTables(ArrayList<Table> tables) throws FileNotFoundException
	      {
      		  File file = new File("/datatxt/Table.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	int tableID = Integer.parseInt(sc.next());
		          	int tableMaxSeats = Integer.parseInt(sc.next());
                    int availStatus = Integer.parseInt(sc.next());
		            
		            Table table = new Table(tableID, tableMaxSeats, availStatus);
		            tables.add(table);
		      }
		      while(sc.hasNextLine());     
		     sc.close();
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
    
    //not sure if need addRestTables 
    public void addRestTables(int num){
        for(int i = 0; i < num; i++){
            int nseats;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of seats: ");
            nseats = sc.nextInt();
            tables.add(new Table(i, nseats, 0));
            sc.close();
        }
    }

    public static ArrayList<Table> findAvailTables(ArrayList<Table> t){
        for(Table table : tables){
            if (table.getAvailStatus() == true){
                t.add(table);
            }
        }
        return t;
    }

    public static void deleteRestTables(int index){
        tables.remove(index-1);
        System.out.println("Table %f has been removed.");
    }

    public static ArrayList<Table> getTableList(){
        return tables;
    }

    public static void editAvailStatus(int idx) throws IOException{
        /* for(Table table : tables){
            if(table.getTableNo() == idx){
            }
        }
        
    */ }

//May need optimisation if have time
    public static Table assignTable(int pax){
        for (int i=0; i < tables.size(); i++)
        {
            if(tables.get(i).getAvailStatus() == true)
            {
                if(tables.get(i).getMaxNumSeats() >= pax){
                    return tables.get(i);
                }
            }
            tables.get(i).setUnavailStatus();
        }

        return null;
    }
}

