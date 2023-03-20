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

    public String getMoves(Board board){
        String string = "";

//      check right
        if(x != board.size - 1 && board.getValue(x + 1, y) != getInfected()){
            string += "You can infect right\n";
        }
//      check left
        if(x != 0 && board.getValue(x - 1, y) != getInfected()){
            string += "You can infect left\n";
        }
//      check down
        if(y != board.size - 1 && board.getValue(x, y+ 1) != getInfected()){
            string += "You can infect down\n";
        }
//      check up
        if(y != 0 && board.getValue(x, y -1) != getInfected()){
            string += "You can infect up\n";
        }

        return string;
    }

}
