import java.util.ArrayList;

public class Speler {
    private char token;

    private int x;
    private int y;

    public Speler(char token){
        this.token = Character.toLowerCase(token);
    }

    public char getCurrentPlayer() {
        return Character.toUpperCase(token);
    }
    public char getInfected() {
        return token;
    }


    public ArrayList<Move> getMoves(Board board){
        ArrayList<Move> list = new ArrayList<>();
        list.addAll(getMovesForInfecting(board));

    }
    public ArrayList<Move> getMovesForInfecting(Board board){
        ArrayList<Move> list = new ArrayList<>();
//      check right
        if(x != board.size - 1 && board.getValue(x + 1, y) != getInfected()){
            list.add(new InfectMove( 1, 0));
        }
//      check left
        if(x != 0 && board.getValue(x - 1, y) != getInfected()){
            list.add(new InfectMove(-1, 0));
        }
//      check down
        if(y != board.size - 1 && board.getValue(x, y + 1) != getInfected()){
            list.add(new InfectMove(0,  1));
        }
//      check up
        if(y != 0 && board.getValue(x, y -1) != getInfected()){
            list.add(new InfectMove(0,  -1));
        }
//      check top right
        if ( x != board.size - 1 && y != 0 &&  board.getValue(x + 1, y -1) != getInfected()){
            list.add(new InfectMove( 1,  -1));
        }
//      check top left
        if (x != 0 && y != 0 &&  board.getValue(x - 1, y -1) != getInfected()){
            list.add(new InfectMove( - 1,  -1));
        }
//      check bottom right
        if (x != board.size - 1  && y != board.size - 1 &&  board.getValue(x + 1, y + 1) != getInfected()){
            list.add(new InfectMove(  1,  1));
        }

        if (x != 0  && y != board.size - 1 &&  board.getValue(x - 1, y + 1) != getInfected()){
            list.add(new InfectMove(- 1,  1));
        }

        return list;
    }
}

/*

size = w * h
    neighbors = []
    if i - w >= 0:
        neighbors.append(i - w)  # north
    if i % w != 0:
        neighbors.append(i - 1)  # west

    if (i + 1) % w != 0:
        neighbors.append(i + 1)  # east

    if i + w < size:
        neighbors.append(i + w)  # south

    if mode == 8:
        if ((i - w - 1) >= 0) and (i % w != 0):
            neighbors.append(i - w - 1)  # northwest

        if ((i - w + 1) >= 0) and ((i + 1) % w != 0):
            neighbors.append(i - w + 1)  # northeast

        if ((i + w - 1) < size) and (i % w != 0):
            neighbors.append(i + w - 1)  # southwest

        if ((i + w + 1) < size) and ((i + 1) % w != 0):
            neighbors.append(i + w + 1)  # southeast
    return neighbors

 */
