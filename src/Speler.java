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

}
