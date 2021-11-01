package Manager;

import java.util.ArrayList;
import java.util.Scanner;
import Entities.Table;
import db.Restaurant;

public class TableMgr {
   
    private static ArrayList<Table> tables = Restaurant.tables;

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

