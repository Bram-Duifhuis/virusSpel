import java.util.ArrayList;

public class Speler {
    private char token;

    public char getToken() {
        return token;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public Speler(char token, int x, int y) {
        this.token = Character.toLowerCase(token);
        this.x = x;
        this.y = y;
    }

    public char getCurrentPlayer() {
        return Character.toUpperCase(token);
    }

    public char getInfected() {
        return token;
    }

    public ArrayList<Option> getMoves(Board board) {
        ArrayList<Option> list = new ArrayList<>();
        list.addAll(getMovesForInfecting(board));
        list.addAll(getMovesForMoving(board));
        list.add(new Quit());

        return list;
    }

    public ArrayList<Move> getMovesForInfecting(Board board) {
        ArrayList<Move> list = new ArrayList<>();
        // check right
        if (x != board.size - 1 && board.getValue(x + 1, y) != getInfected()) {
            list.add(new InfectMove(1, 0));
        }
        // check left
        if (x != 0 && board.getValue(x - 1, y) != getInfected()) {
            list.add(new InfectMove(-1, 0));
        }
        // check down
        if (y != board.size - 1 && board.getValue(x, y + 1) != getInfected()) {
            list.add(new InfectMove(0, 1));
        }
        // check up
        if (y != 0 && board.getValue(x, y - 1) != getInfected()) {
            list.add(new InfectMove(0, -1));
        }
        // check top right
        if (x != board.size - 1 && y != 0 && board.getValue(x + 1, y - 1) != getInfected()) {
            list.add(new InfectMove(1, -1));
        }
        // check top left
        if (x != 0 && y != 0 && board.getValue(x - 1, y - 1) != getInfected()) {
            list.add(new InfectMove(-1, -1));
        }
        // check bottom right
        if (x != board.size - 1 && y != board.size - 1 && board.getValue(x + 1, y + 1) != getInfected()) {
            list.add(new InfectMove(1, 1));
        }

        if (x != 0 && y != board.size - 1 && board.getValue(x - 1, y + 1) != getInfected()) {
            list.add(new InfectMove(-1, 1));
        }

        return list;
    }

    public ArrayList<Option> getMovesForMoving(Board board) {
        ArrayList<Option> list = new ArrayList<>();
        // check right
        if (x < board.size - 2 && board.getValue(x + 2, y) == '_') {
            list.add(new MoveMove(2, 0));
        }
        // check left
        if (x > 1 && board.getValue(x - 2, y) == '_') {
            list.add(new MoveMove(-2, 0));
        }
        // check down
        if (y < board.size - 2 && board.getValue(x, y + 2) == '_') {
            list.add(new MoveMove(0, 2));
        }
        // check up
        if (y > 1 && board.getValue(x, y - 2) == '_') {
            list.add(new MoveMove(0, -2));
        }
        // check top right
        if (x < board.size - 2 && y > 1 && board.getValue(x + 2, y - 2) == '_') {
            list.add(new MoveMove(2, -1));
        }
        // check top left
        if (x > 1 && y > 1 && board.getValue(x - 2, y - 2) == '_') {
            list.add(new MoveMove(-2, -2));
        }
        // check bottom right
        if (x < board.size - 2 && y < board.size - 2 && board.getValue(x + 2, y + 2) == '_') {
            list.add(new MoveMove(2, 2));
        }

        if (x > 1 && y < board.size - 2 && board.getValue(x - 2, y + 2) == '_') {
            list.add(new MoveMove(-2, 2));
        }

        return list;
    }
}
