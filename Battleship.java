
import java.util.Scanner;
import java.io.*;

public class Problem2  {
  public static void main(String[] args) throws IOException {
    int[][] shipsHuman =  {{1,0,0,0,0},
        {1,0,0,0,0},
        {0,0,1,1,1},
        {0,0,0,0,0}};
     int[][] shipsAI =   {{0,0,0,1,0},
        {1,1,0,1,0},
        {0,0,0,1,0},
        {0,0,0,0,0}};
     Human human = new Human(shipsHuman);
     AI ai = new AI(shipsAI);
 
     ai.printGuessed("AI");
     human.printGuessed("Human");
     int input;
     System.out.println("Choose (0=quit, 1=play, 2=save, 3=read): ");
     Scanner scan = new Scanner(System.in);
     input = scan.nextInt();
     while(input != 0) {  
     switch(input) {
       
       case 0:
         break;
       case 1:
        human.play(ai);
       if (human.won(ai.getShips()))
         System.out.println("Congratulations! You won!");
         else {
           ai.play(human);
           if (ai.won(human.getShips()))
             System.out.println("AI won!");
             else {
               ai.printGuessed("AI");
               human.printGuessed("Human");
               
             }
           }
         System.out.println("Choose (0=quit, 1=play, 2=save, 3=read): ");
         input = scan.nextInt();
         break;
       case 2:
         try {
           human.save("humanfile");
           ai.save("AIfile");
         }
         catch(IOException exception) {
           System.out.println("Error saving the file. Data not saved");
         }
         ai.printGuessed("AI");
         human.printGuessed("Human");
         System.out.println("Choose (0=quit, 1=play, 2=save, 3=read): ");
         input = scan.nextInt();
         break;
       case 3:
         try {
           human.read("humanfile");
           ai.read("AIfile");
         }
         catch(IOException exception) {
           System.out.println("Error reading the file. Data not read");
         }
         ai.printGuessed("AI");
         human.printGuessed("Human");
         System.out.println("Choose (0=quit, 1=play, 2=save, 3=read): ");
         input = scan.nextInt();
         break;
       }
     }
  }
}
         