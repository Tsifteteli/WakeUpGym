/*2018-12-11
D0019N Examinationsuppgift 2, Gym WakeUp
Caroline Blomgren, carbol-8@student.ltu.se
Amanda Nordmark, norama-6@student.ltu.se*/

package exUppg2;

import java.util.Scanner; //import scanner

public class Kostnad { //class for price related stuff
   
   public static void prislista() { //show pricelist
      System.out.println("Medlemskap prislista:\n" +
         "1-2 månader – 400 SEK/månad\n" +
         "3-6 månader – 350 SEK/månad\n" +
         "7-12 månader – 300 SEK/månad\n" +
         "Längre än 12 månader – 250 SEK/månad\n" +
         "Administrativ avgift - 100 SEK*\n\n" +
         "*En administrativ engångsavgift för tryck av gymkort " +
         "tillkommer första gången du blir medlem.\n");
   }
   
   public static int kostnad() { //calculate total price
      Scanner input = new Scanner(System.in); //Instantiate the variable input
      int price; //variable for monthly price
      int month = 0; //variable for number of months
      
      System.out.println("Max antal månader möjliga att lösa per gång: 24\n");
      System.out.println("Hur många månader vill du lösa träningskort för?");
      do{
         try{
            month = input.nextInt(); //reed input number
            if (month < 1 || month > 24) { //control if input is a valid choice
               throw new IllegalArgumentException ("Ange ett heltal mellan 1"
                       + " och 24");
            }
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //show exception message
         }
      } while (month < 1 || month > 24); //redo if the choice is not valid
      
      switch (month) { //decide monthly price
         case 1:
            price = 400;
            break;
         case 2:
            price = 400;
            break;
         case 3:
            price = 350;
            break;
         case 4:
            price = 350;
            break;
         case 5:
            price = 350;
            break;
         case 6:
            price = 350;
            break;
         case 7:
            price = 300;
            break;
         case 8:
            price = 300;
            break;
         case 9:
            price = 300;
            break;
         case 10:
            price = 300;
            break;
         case 11:
            price = 300;
            break;
         case 12:
            price = 300;
            break;
         default:
            price = 250;   
      }
      int sum = month * price + 100; //calculate total price
      
      return sum;
   }
}