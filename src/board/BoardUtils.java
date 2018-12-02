package board;

public class BoardUtils {


    public static void printBoard(Board b) {
        System.out.println("Start processing existing user input");
        int row = 0;
        int dim = b.getDim();
        while (row < dim) {
            for (int i = 0; i < dim; i++) {
                int pos = row * dim + i;
                System.out.print(b.getBoard()[pos] + "|");
            }
            row++;
            System.out.println();
        }
        System.out.println("DONE processing existing user input");

    }


    public static void printBoardHint(Board b) {
        System.out.println("print all the positions on the board");
        int row = 0;
        int dim = b.getDim();
        while (row < dim) {
            for (int i = 0; i < dim; i++) {
                int pos = row * dim + i;
                System.out.print(" " + pos + " |");
            }
            row++;
            System.out.println();
        }
    }

    public static void printAvailablePositions(Board b) {
        System.out.println("print all the valid positions on the board");
        int row = 0;
        int dim = b.getDim();
        while (row < dim) {
            for (int i = 0; i < dim; i++) {
                int pos = row * dim + i;
                String posVal = b.getBoard()[pos];
                if (posVal.isEmpty()) {
                    System.out.print(" " + pos + " |");
                } else {
                    System.out.print(" " + posVal + " |");
                }

            }
            row++;
            System.out.println();
        }
    }

}
