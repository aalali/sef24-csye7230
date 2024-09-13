/**
    Northeastern University
	CSYE 7230 Software Engineering 
    Fall 2024
    Project #1
    Tic Tac Toe
    tictactoe-v0.9.java
    Author: 
*/

import java.util.*;
 
public class TicTacToeGame {
   
    static String[] brd;
    static String turn;
   
   
    static String chkW()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = brd[0] + brd[1] + brd[2];
                break;
            case 1:
                line = brd[3] + brd[4] + brd[5];
                break;
            case 2:
                line = brd[6] + brd[7] + brd[8];
                break;
            case 3:
                line = brd[0] + brd[3] + brd[6];
                break;
            case 4:
                line = brd[1] + brd[4] + brd[7];
                break;
            case 5:
                line = brd[2] + brd[5] + brd[8];
                break;
            case 6:
                line = brd[0] + brd[4] + brd[8];
                break;
            case 7:
                line = brd[2] + brd[4] + brd[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
             
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
         
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(brd).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
 
        System.out.println(
            turn + "'s turn; enter a slot number to place "
            + turn + " in:");
        return null;
    }
     
    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
   
    static void printB()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + brd[0] + " | "
                           + brd[1] + " | " + brd[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + brd[3] + " | "
                           + brd[4] + " | " + brd[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + brd[6] + " | "
                           + brd[7] + " | " + brd[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        brd = new String[9];
        turn = "X";
        String winner = null;
 
        for (int a = 0; a < 9; a++) {
            brd[a] = String.valueOf(a + 1);
        }
 
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printB();
 
        System.out.println(
            "X will play first. Enter a slot number to place X in:");
 
        while (winner == null) {
            int num;
           
           
            try {
                num = in.nextInt();
                if (!(num > 0 && num <= 9)) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }
             
            brd[num - 1] = turn;

            if (turn.equals("X")) {
                turn = "O";
            }
            else {
                turn = "X";
            }

            printB();
            winner = chkW();
        }
       
        if (winner.equalsIgnoreCase("X")||
        winner.equalsIgnoreCase("O")) {
            System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
        }
      in.close();
    }
}
