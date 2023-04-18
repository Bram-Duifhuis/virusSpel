import java.util.ArrayList;


class Option {

}
public class Move {

    protected int x;
    protected int y;

    public Move(int x, int y) {
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
}