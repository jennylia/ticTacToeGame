import board.Board;

import java.util.Scanner;

import static board.BoardUtils.printAvailablePositions;
import static board.BoardUtils.printBoard;
import static board.BoardUtils.printBoardHint;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean player1 = true;
        Board b = new Board();
        boolean isOver = b.getIsGameOver();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        printBoardHint(b);
        while (isOver == false) {
            printBoard(b);
            printAvailablePositions(b);
            String currentPlayer = player1 ? "1" : "2";
            String currentSymbol = player1 ? "X" : "O";

            System.out.println("Player " + currentPlayer + ": Please make a selection");
            // player makes a position


            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            System.out.println("You have chosen " + n);
            b.setPositionBoard(currentSymbol, n);


            isOver = b.evaluateBoard();
            printBoard(b);
            player1 = !player1;
            System.out.println("TURN OVER===========================");
        }
        reader.close();
        System.out.println("Good Game " + b.getWinner());



    }
}
