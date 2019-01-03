/*2018-12-11
D0019N Examinationsuppgift 2, Gym WakeUp
Caroline Blomgren, carbol-8@student.ltu.se
Amanda Nordmark, norama-6@student.ltu.se*/

package exUppg2;

import java.util.Scanner; //import scanner

public class Gymmet {
   public static void main(String[] args){//start main method
      
      Scanner input = new Scanner(System.in); //Instantiate variable
      Medlem memberList = new Medlem(); //Instantiate variable
      int menyval; //Initialize menyval
      boolean inloggad = false; //declare and initialize inloggad
      
     
      System.out.println("Välkommen till Gym WakeUp!\n");
      do {
         System.out.print("Meny\n1. Bli medlem\n2. Logga in\n"
                 + "3. Boka plats på aktivitet\n4. Avsluta\n\n"
                 + "Vad vill du göra? Välj ett nummer ur menyn.\n"); //prompt
         menyval = input.nextInt(); //reed input number
         
         if (menyval < 1 || menyval > 4) { //control if valid number
            System.out.println("Var god ange ett giltigt val"); //prompt
         }
         if (menyval == 1) { //become member
            System.out.println("\n1. Bli medlem"); //show selected section
            System.out.println("Ange personnummer utan bindestreck:"); //prompt
     
            String pnr = Medlem.pnrAutent(); //control if pnr is valid
            
            if (memberList.arrayContent(pnr)) { //check if member
               System.out.println("Du är redan medlem.\n");
            }
            else {
               Kostnad.prislista(); //show prislista
               int sum = Kostnad.kostnad();//calculate total price
               System.out.println("\nTotalpris för valt antal månader + "
                       + "engångsavgift är " + sum + " kr\n");
               memberList.setPnr(pnr); //add pnr to member list
               System.out.println("Konto skapat för personnummer " +
                       pnr + "\n");
            }
         }
         if (menyval == 2) {
            System.out.println("\n2. Logga in"); //show selected section
            System.out.println("Ange personnummer utan bindestreck:"); //prompt
            
            String pnr2 = Medlem.pnrAutent(); //control if pnr is valid
            
            if (!memberList.arrayContent(pnr2)) { //check if not member
               System.out.println("Medlemskonto saknas. Var god bli medlem "
                      + "eller försök logga in igen med existerande medlem.\n");
            }
            else {
               inloggad = true; // logg in
               System.out.println("Du är nu inloggad.\n");       
            }
         }
         if (menyval == 3) {
            System.out.println("\n3. Boka plats på aktivitet"); //show selected section
            if (inloggad == false) { //contol if logged in
               System.out.println("För att boka plats på aktivitet krävs"
                       + "att du är medlem och inloggad\n");
            }
            else {
               System.out.println("Vilken aktivitet vill du boka plats på?\n"
                       + "1. Spinning\n" + "2. Aerobics\n" + "3. Yoga\n");
               System.out.println("Välj ett nummer:"); //prompt
               int aktVal;
               do{
                  Scanner input2 = new Scanner(System.in);
                  aktVal = input2.nextInt(); //reed input
               
                  if (aktVal < 1 || aktVal > 3) { //control of value
                     System.out.println("Var god ange ett giltigt val"); //prompt
                  }
                  else {
                     Aktivitet val = new Aktivitet();
                     val.aktVal(aktVal); //chose activity
                     val.visaPlatser(); //show spots
                     val.boka(); //book spot on activity
                  }
               } while (aktVal < 1 || aktVal > 3);
            }
         }
         
      } while (menyval != 4);
      System.out.println("\n4. Avsluta"); //show selected section
      System.out.println("Tack för besöket!"); //End of program
   }
}
