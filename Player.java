
import java.util.Scanner;
import java.io.*;

public class Player {
 private int[][] ships;
 protected int[][] guessed;
 
 public Player(int[][] ships) {
  this.ships = ships;
  guessed = new int[ships.length][ships[0].length];
 }
 
 public int[][] getShips() {
  return ships;
 }
 
 public void check(int row, int col, int[][] opponentShips) {
  if (opponentShips[row][col] == 1) {
   guessed[row][col] = 1;
   System.out.println("Hit!");
  }
  else {
   guessed[row][col] = -1;
   System.out.println("Miss");
  }
 }
 
 public boolean won(int[][] opponentShips) {
  for (int row = 0; row < ships.length; row++)
   for (int col = 0; col < ships[0].length; col++)
    if (guessed[row][col] != 1 && opponentShips[row][col] == 1)
     return false;
  return true;
 }

 public void printGuessed(String name) {
  System.out.println(name + ":");
  System.out.print(" ");
  for (int col = 0; col < guessed[0].length; col++)
   System.out.print(col);
  System.out.println();
  for (int row = 0; row < guessed.length; row++) {
   System.out.print(row);
   for (int col = 0; col < guessed[0].length; col++) {
    if (guessed[row][col] == 1)
     System.out.print("X");
    else if (guessed[row][col] == -1)
     System.out.print("O");
    else
     System.out.print(" ");
   }
   System.out.println();
  }
  System.out.println();
 }
 public void save(String fileName) throws IOException {
   
   PrintWriter outFile = new PrintWriter(fileName);
   for(int i = 0; i < guessed.length; i++) {
     for(int j = 0; j < guessed[i].length; j++) {
       outFile.print(guessed[i][j] + " ");
     }
   }
   for(int i = 0; i < ships.length; i++) {
     for(int j = 0; j < ships[i].length; j++) {
       outFile.print(ships[i][j] + " ");
     }
    
   }
   outFile.close();
 }
 public void read(String fileName) throws IOException {
   File inFile = new File(fileName);
   Scanner scan = new Scanner(inFile);
   for(int i = 0; i < guessed.length; i++) {
     for(int j = 0; j < guessed[i].length; j++) {
       guessed[i][j] = scan.nextInt();
     }
    
   }
   for(int i = 0; i < ships.length; i++) {
     for(int j = 0; j < ships[i].length; j++) {
        ships[i][j] = scan.nextInt();
     }
      
   }
   scan.close();
  }
}