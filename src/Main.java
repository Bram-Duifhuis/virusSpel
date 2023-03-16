import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int currentPlayer = 0;

        System.out.println("Hoeveel spelers zijn er?");
        int totaleSpelers = scanner.nextInt();

        Speler[] spelers = new Speler[totaleSpelers];
        for(int i = 0; i < spelers.length; i++){
            System.out.println("Voer caracter in voor speler: " + (i+1));
            spelers[i] = new Speler(scanner.next().charAt(0));
        }


        Board board = new Board(spelers);
        boolean playing = true;

        while (playing) {
            System.out.println("Welke zet wil je doen speler " + spelers[currentPlayer].getCurrentPlayer());
            System.out.println(board);
            currentPlayer = (currentPlayer + 1 ) % spelers.length;
            break;

        }
    }
}