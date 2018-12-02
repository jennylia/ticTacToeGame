import board.Board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean player1 = true;
        Board b = new Board();
        boolean isOver = b.getIsGameOver();
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (isOver == false) {
            b.printBoard();
            String currentPlayer = player1 ? "1" : "2";
            String currentSymbol = player1 ? "X" : "O";

            System.out.println("Player " + currentPlayer + ": Please make a selection");
            // player makes a position


            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            System.out.println("You have chosen " + n);
            b.setPositionBoard(currentSymbol, n);


            isOver = b.evaluateBoard();
            b.printBoard();
            player1 = !player1;
            System.out.println("TURN OVER===========================");
        }
        reader.close();
        System.out.println("Good Game " + b.getWinner());



    }
}
