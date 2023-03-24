import java.util.Arrays;

public class Board {

    final int size;
    int[] possibleStartLocations;
    private char[] board;

    public Board(Speler[] spelers, int size){
        this.size = size;
        possibleStartLocations = new int[]{0, size * size - 1, size - 1, size * (size - 1)};
        board = new char[size * size];
        Arrays.fill(board, '_');
        for (int i = 0; i < spelers.length; i++) {
            board[possibleStartLocations[i]] = spelers[i].getCurrentPlayer();
        }


    }

    public String toString(){
        String str_board = "";
        for (int i = 0; i < board.length; i++){
            if (i % size == 0){
                str_board += "\n";
            }
            str_board += board[i];
        }
        return str_board;
    }

    public void setValue(int x, int y, char value){
        board[x + size * y] = value;
    }

    public char getValue(int x, int y){
        return board[x + size * y];
    }

}
