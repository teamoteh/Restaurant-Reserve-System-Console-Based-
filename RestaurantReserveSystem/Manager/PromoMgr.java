package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.SetPromo;
import MenuClass.Appetizer;
import MenuClass.Dessert;
import MenuClass.Drink;
import MenuClass.MainCourse;

public class PromoMgr{
    
    public static ArrayList<SetPromo> setPromoList;
    
    public static void readStaffs(ArrayList<SetPromo> promoList) throws FileNotFoundException {
		File file = new File("/datatxt/SetPromo.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");
        SetPromo set = new SetPromo();
        String itemName, itemDesc;
        double itemPrice;
		do {
            //Using '~' as a separator between the other Promo Packages
            if (sc.next() != "~"){
                String foodName = sc.next();
                //Identifying the classification of the FoodTypes
                if(foodName == "Appetizer"){
			        itemName = sc.next();
			        itemPrice= Double.parseDouble(sc.next());
			        itemDesc = sc.next();
			        Appetizer appet = new Appetizer(itemName, itemPrice, itemDesc);
                    set.updatePromoAppet(itemName, itemPrice, itemDesc);
                    break;
                }
                if(foodName == "Main"){
			        itemName = sc.next();
			        itemPrice= Double.parseDouble(sc.next());
			        itemDesc = sc.next();
			        MainCourse course = new MainCourse(itemName, itemPrice, itemDesc);
                    set.updatePromoMain(itemName, itemPrice, itemDesc);
                    break;
                }
                if(foodName == "Drink"){
			        itemName = sc.next();
			        itemPrice= Double.parseDouble(sc.next());
			        itemDesc = sc.next();
			        Drink drink = new Drink(itemName, itemPrice, itemDesc);
                    set.updatePromoDrink(itemName, itemPrice, itemDesc);
                    break;
                }
                if(foodName == "Dessert"){
			        itemName = sc.next();
			        itemPrice= Double.parseDouble(sc.next());
			        itemDesc = sc.next();
			        Dessert sweet = new Dessert(itemName, itemPrice, itemDesc);
                    set.updatePromoDessert(itemName, itemPrice, itemDesc);
                    break;
                }
            }
            else{
                setPromoList.add(set);
            }
		} while (sc.hasNextLine());
		sc.close();
	}

    public void getSetPromo(){
        for(int i = 0; i < setPromoList.size(); i++){
            SetPromo set = setPromoList.get(i);
            ((SetPromo) set).getPromo();
        }
    }
}