
public class Move {

    protected int x;
    protected int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class InfectMove extends Move {

    public InfectMove(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Infect to the" ;
    }
}