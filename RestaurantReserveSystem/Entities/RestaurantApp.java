package Entities;

import java.util.Scanner;

public class RestaurantApp{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create/Update/Remove menu item\n"
						+ "2. Create/Update/Remove promotion\n"
						+ "3. Create order\n"
						+ "4. View order\n"
						+ "5. Add/Remove order item/s to/from order\n"
                        + "6. Create reservation booking\n"
                        + "7. Check/Remove reservation booking\n"
                        + "8. Check table availability\n"
                        + "9. Print order invoice\n"
                        + "10. Print sale revenue report by period (eg day or month)");
        
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
    