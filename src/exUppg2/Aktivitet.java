/*2018-12-11
D0019N Examinationsuppgift 2, Gym WakeUp
Caroline Blomgren, carbol-8@student.ltu.se
Amanda Nordmark, norama-6@student.ltu.se*/

package exUppg2;

import java.util.Scanner; //import scanner

public class Aktivitet { //class for activity booking stuff
   
   private String[][] spinning = {{" ", "X", " "}, {" ", "X", " "}, {"X", " ", " "}};
   private String[][] aerobics = {{"X", "X", " "}, {" ", " ", " "}, {" ", " ", " "}};
   private String[][] yoga = {{" ", " ", "X"}, {" ", " ", " "}, {" ", "X", " "}};
   //multiple arrays for spot overview for each activity
   
   private String[][] aktVal = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
   //multiple array used as tool to apply methods on the other arrys
   
   
   public void aktVal(int aktVal) { /*set the array aktVal to the array of
      chosen activity*/
      if (aktVal == 1) {
         this.aktVal = spinning;
         System.out.println("1. Spinning\n");
      }
      if (aktVal == 2) {
         this.aktVal = aerobics;
         System.out.println("2. Aerobics\n");
      }
      if (aktVal == 3) {
         this.aktVal = yoga;
         System.out.println("3. Yoga\n");
      }
   }
   
   public void visaPlatser() { //show spots in 3 rows, 3 spots on each row.
      System.out.println("Platsöversikt:\n");
      System.out.println("^Frammåt i salen^");
      System.out.println("  | 1 | 2 | 3 |");
      System.out.println("---------------");
      System.out.printf ("A | %s | %s | %s |\n", aktVal[0][0], aktVal[0][1],aktVal[0][2]);
      System.out.println("---------------");
      System.out.printf ("B | %s | %s | %s |\n", aktVal[1][0], aktVal[1][1],aktVal[1][2]);
      System.out.println("---------------");
      System.out.printf ("C | %s | %s | %s |\n", aktVal[2][0], aktVal[2][1],aktVal[2][2]);
      System.out.println("---------------");  
      System.out.println("X = upptaget");
   }

   public void boka() { //book available spot
      Scanner input = new Scanner(System.in);
        int firstIndex = 0; //first index in choice
        int secondIndex = 0; //second index in choice
        boolean bokad = false;        
        
         System.out.println("Välj en ledig plats du vill boka i formatet"
                 + " A1, A2,..., C3");
         do {
            String choice = "";
            choice = input.next(); //reed input from user

            char[] xy = choice.toCharArray(); /*create char array from the
            string choice*/
            
            //check if valid choice
            if(xy.length != 2 || !((xy[0] == 'A' || xy[0] == 'B' || xy[0] == 'C')
                    && (xy[1] == '1' || xy[1] == '2' || xy[1] == '3'))  ){
               System.out.println("Var god ange en existerande plats i formatet"
                       + " A1, A2, ..., C3");
            }
            else {
               firstIndex = xy[0] - 'A'; //convert ascii value to correct int
               secondIndex = xy[1] - '1'; //convert ascii value to correct int
               bokad = kollaLedig(firstIndex, secondIndex);
               if(!bokad) { //if not valid. Prompt for new choice.
                    System.out.println("Platsen är upptagen. "
                            + "Var god välj en ledig plats.");
               }
               else {
                  aktVal[firstIndex][secondIndex] = "X"; //place X at the chosen possition
                  System.out.println("Plats " + choice + " är bokad till dig!\n");
               }
            }
        } while (!bokad);
    }
    
   //check if place is available
   public boolean kollaLedig(int firstIndex, int secondIndex) {
      if((aktVal[firstIndex][secondIndex]).equals(" ")) {
         return true; //if available return "true"
      }
      else {
         return false; //if not return "false"
      }
    }
}
