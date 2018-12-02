package board;

public class Board {
    private String[] board;
    private int dim = 3;
    private boolean isGameOver;
    private boolean player1Win; // Could be tied
    private boolean player2Win;

    public String getWinner(){
        if (player1Win){
            return "Player1 Win";
        }else if (player2Win){
            return "Player2 Win";
        }else{
            return "No winner";
        }

    }

    public Board() {
        // Init function
        int len = dim * dim;
        this.board = new String[len]; // TODO, could make this a 2 d matrix

        for (int i = 0; i < len; i ++){
            board[i] = "";
        }

        isGameOver = false;
        player1Win = false;
        player2Win = false;

    }

    public boolean evaluateBoard() {
        if (isGameOver) {
            return isGameOver;
        }

        boolean boardFull = isFull(board);
        if (boardFull) {
            isGameOver = true;
            return isGameOver;
        }

        boolean currentPlayer1Status = didPlayerWin("X"); // TODO could make this a separate class
        boolean currentPlayer2Status = didPlayerWin("O");


        if (currentPlayer1Status) {
            player1Win = true;
            isGameOver = true;
            return isGameOver;
        } else if (currentPlayer2Status) {
            player1Win = true;
            isGameOver = true;
            return isGameOver;
        }

        return isGameOver;

    }

    private boolean didPlayerWin(String x) {
        // scan row.
        for (int i = 0; i < dim; i++) {
            if (board[i].equals(x) && board[i + 1].equals(x) && board[i + 2].equals(x)) {
                return true;
            }
        }
        // scan col.
        for (int j = 0; j < dim; j++) {
            if (board[j].equals(x) && board[j + dim * 1].equals(x) && board[j + dim * 2].equals(x)) {
                return true;
            }
        }
        // scan a left diagonal (generalize, 0 + (dim + 1))
        if (board[0].equals(x) && board[4].equals(x) && board[8].equals(x)) {
            return true;
        }
        // scan a left diagonal (generalize, corner + (dim -  1))

        if (board[2].equals(x) && board[4].equals(x) && board[6].equals(x)) {
            return true;
        }
        return false;
    }

    private boolean isFull(String[] board) {
        for (String s : board) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public void setPositionBoard(String val, int position) {
        if (position < 0 || position >= dim * dim){
            System.out.printf("INVALID position, forfeit turn");
            return;
        }

        if (board[position].isEmpty() == false){
            System.out.printf("PRE OCCUPIED position, forfeit turn");
            return;
        }


        board[position] = val;
    }


    public void printBoard() {
        System.out.println("printing the board...");
        int row = 0;
        while (row < dim) {
            for (int i = 0; i < dim; i++) {
                int pos = row * dim + i;
                System.out.print(board[pos] + "|");
            }
            row++;
            System.out.println();

        }
    }


    public boolean getIsGameOver() {
        return isGameOver;
    }
}
