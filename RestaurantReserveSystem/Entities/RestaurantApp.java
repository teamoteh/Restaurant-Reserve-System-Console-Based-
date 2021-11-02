package Entities;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestaurantApp{
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter today's date in the format of YYYY-MM-DD: ");
         LocalDate date	= LocalDate.parse(sc.nextLine());

         System.out.println("What would you like to do? ");
       
        System.out.println("1. Check Available Tables\n" 
                            + "2. Create New Order\n"
                            + "3. View Current Orders\n"
                            + "4. Edit Current Orders\n"
                            + "5. Make A Reservation\n"
                            + "6. Check Reservation Booking\n"
                            + "7. Remove Reservation Booking\n"
                            + "8. Print order invoice\n"
                            + "9. Print sale revenue report by period (eg day or month)"
                            + "10. End The Day" );
            
        do 
        {
            System.out.println("Input a choice:");
			
			switch(sc.nextInt())
			{
				case 1:
					
					break;
				
				case 2:

                    break;

                case 3:

                    break;
                
                case 4:

                    break;
                    
                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 10:

                    break;

            }
        } while (1)
    
    }
    
    public String currentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    