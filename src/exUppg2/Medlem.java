/*2018-12-11
D0019N Examinationsuppgift 2, Gym WakeUp
Caroline Blomgren, carbol-8@student.ltu.se
Amanda Nordmark, norama-6@student.ltu.se*/

package exUppg2;

import java.util.ArrayList; //import arraylist
import java.util.Scanner; //import scanner

public class Medlem { //class for membership rellated stuff
   
   private ArrayList<String> medlemar = new ArrayList<String>();
   //create ArrayList to keep track of medlemmar
   
   public void setPnr(String pnr) { //method to set a pnr
      medlemar.add(pnr); //adding pnr to ArrayList
   }
   
   public boolean arrayContent(String pnr) { /*method to contol if a member with
      a specific pnr already exists*/
      return medlemar.contains(pnr);
   }
   
   public static String pnrAutent() { //method to control if pnr is valid
      Scanner inPnr = new Scanner(System.in); //Instantiate variable
      String pnr = "";
      int retur = 1;
      
      do {
         try {
            pnr = inPnr.nextLine(); //reed input
            if (pnr.length() != 10) { //control lenght
               throw new IllegalArgumentException ("Personnummer måste "
                       + "innehålla 10 siffror utan bindestreck.");
            }
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //show exception message
         }
         try { int sum = 0; //initiate sum of added numbers
            for (int i = 0; i < pnr.length(); i++){ //iteration
               char charNum = pnr.charAt(i); //returns char at specific index
               int number = charNum - '0'; //translate ascii value into int value
               int product; //initiate product variable
               if (i % 2 != 0){ //for numbers on odd index
                  product = number * 1;
               }
               else{ //for numbers on even index
                  product = number * 2;
               }
               if (product > 9) { //if product is a two didgit number
                  product = product - 9; /*translate into one didgit number
                  (same as adding the two didgits together)*/
               }
               sum = sum + product; // add to total sum
            }
            retur = sum % 10; // result of sum % 10;
      
            if (retur == 0){
               System.out.println("Giltigt personnummer\n"); //if pnr is valid
            }
            else{ //if pnr in not valid
               throw new IllegalArgumentException ("Ej giltigt personnummer. "
                       + "Försök igen:");
            }
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //show exception message
         }
      } while(pnr.length() != 10 || retur != 0);
      
      return pnr;
   }
}
