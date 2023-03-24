import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int currentPlayer = 0;
        int totaleSpelers;
        while (true) {
            System.out.println("Hoeveel spelers zijn er?");
            totaleSpelers = scanner.nextInt();
            if ( totaleSpelers >= 2 && totaleSpelers <= 4){
                break;
            }

            System.out.println("Totale spelers moeten tussen de 2 en 4 spelers zijn");
        }
        Speler[] spelers = new Speler[totaleSpelers];
        for(int i = 0; i < spelers.length; i++){
            System.out.println("Voer caracter in voor speler: " + (i+1));
            spelers[i] = new Speler(scanner.next().charAt(0));
        }


        Board board = new Board(spelers, 10);
        boolean playing = true;

        while (playing) {

            System.out.println(board);
            boolean askingMove = true;
            while (askingMove){
                System.out.println("Welke zet wil je doen speler " + spelers[currentPlayer].getCurrentPlayer());
                ArrayList<Move> list = spelers[currentPlayer].getMoves(board);

                for (int i = 0; i < list.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + list.get(i) );
                }
                break;



            }

            currentPlayer = (currentPlayer + 1 ) % spelers.length;
            break;

        }
    }
}