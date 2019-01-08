
import java.util.Scanner;

public class Human extends Player {
 public Human(int[][] ships) {
  super(ships);
 }
 
 public void play(AI ai) {
  Scanner input = new Scanner(System.in);
  System.out.print("Enter row: ");
  int row = input.nextInt();
  System.out.print("Enter column: ");
  int col = input.nextInt();
  check(row, col, ai.getShips());
 }
}
