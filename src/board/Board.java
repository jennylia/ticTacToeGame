package board;

public class Board {

    private static final int DEFAULT_DIM = 3;
    private final String[] board;
    private final int dim = DEFAULT_DIM;

    public Board() {
        // Init function
        int len = dim * dim;
        this.board = new String[len]; // TODO, could make this a 2 d matrix

        for (int i = 0; i < len; i ++){
            board[i] = "";
        }
    }

    public int getDim() {
        return dim;
    }

    public String[] getBoard() {
        return board;
    }

}
