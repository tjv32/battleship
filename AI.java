
import java.util.Scanner;

public class AI extends Player {
 public AI(int[][] ships) {
  super(ships);
 }
 
 public void play(Human human) {
  int row = (int) (Math.random() * guessed.length);
  int col = (int) (Math.random() * guessed[0].length);
  System.out.println("\nAI is checking (" + row + ", " + col + ")");
  check(row, col, human.getShips());
 }
}
