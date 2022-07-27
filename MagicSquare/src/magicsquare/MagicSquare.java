/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package magicsquare;

import java.util.Scanner;

public class MagicSquare {
    private int[][] arr;
    private int size;
    
    public MagicSquare(int s){
        size = s;
        arr = new int[s][s]; // square array
        
        // init array values
        for(int i = 0; i < s; i++){
            for(int j = 0; j < s; j++){
                arr[i][j] = -1;
            }
        }
        
        construct();
    }
    
    private void construct(){
        int row, col, pRow, pCol;
        
        row = size / 2;
        col = size - 1;
        
        for(int i = 1; i <= size*size; i++){
            arr[row][col] = i;
            
            // keep the previous row and column in case we have a conflict
            pRow = row;
            pCol = col;
            
            row++;
            col++;
            
            // check for conflicts
            if(row > size - 1){
                // out of bounds from the bottom
                row = 0;
            }
            
            if(col > size - 1){
                // out of bounds from the right
                col = 0;
            }
            
            // check if there is a number at current position
            if(arr[row][col] != -1){
                // there is another number here
                row = pRow;
                col = pCol - 1;
            }
        }
    }
    
    public String toString(){
        String s = "";
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                s += String.format("%2d", arr[i][j]) + " ";
            }
            s += "\n";
        }
        
        return s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give square size:");
        size = scanner.nextInt();
        
        MagicSquare magicSquare = new MagicSquare(size);
        System.out.println(magicSquare);
    }
    
}
