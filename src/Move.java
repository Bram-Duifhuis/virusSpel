import java.util.ArrayList;


abstract class Option {

    private String name;

    Option(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }

    abstract public void excecute(Board board, Speler speler);
}


class Quit extends Option{
    Quit(){
        super("quit");
    }

    public void excecute(Board board, Speler speler){
        System.exit(0);
    }
}



public abstract class Move extends Option {

    protected int x;
    protected int y;

    public Move(int x, int y) {
        super("move");
        this.x = x;
        this.y = y;
    }

    public  String getDirections(){
        ArrayList<String> directions = new ArrayList<>();

        if (y <= -1){
            directions.add("up");
        }
        if (y >= 1){
            directions.add("down");
        }if (x >= 1){
            directions.add("right");
        }if (x <= -1){
            directions.add("left");
        }
        return String.join(" and ", directions);
    }


}


class InfectMove extends Move {

    public InfectMove(int x, int y) {
        super(x, y);
    }


    @Override
    public String toString() {
        return "infect: " + getDirections();
    }

    @Override
    public void excecute(Board board, Speler speler) {
        board.setValue(speler.getX() + this.x,speler.getY() +  this.y, speler.getToken());
    }
}

class MoveMove extends Move {

    public MoveMove(int x, int y) {
        super(x, y);
    }


    @Override
    public String toString() {
        return "move: " + getDirections();
    }

    @Override
    public void excecute(Board board, Speler speler) {
        board.setValue(speler.getX(), speler.getY(), '_');
        board.setValue(speler.getX() + this.x, speler.getY() +this.y, speler.getCurrentPlayer());
    }
}