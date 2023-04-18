import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int currentPlayer = 0;
        int size = 6;
        int[][] possibleStartLocations = new int[][]{{0,0},{size -1,size-1},{0,size-1},{size-1,0}};

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
            spelers[i] = new Speler(scanner.next().charAt(0), possibleStartLocations[i][0], possibleStartLocations[i][1] );
        }


        Board board = new Board(spelers, size);
        boolean playing = true;

        while (playing) {

            System.out.println(board);
            boolean askingMove = true;
            while (askingMove){
                System.out.println("Welke zet wil je doen speler " + spelers[currentPlayer].getCurrentPlayer());
                System.out.println("x:" + spelers[currentPlayer].getX() + " y:" + spelers[currentPlayer].getY() );
                ArrayList<Option> list = spelers[currentPlayer].getMoves(board);

                for (int i = 0; i < list.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + list.get(i) );
                }

                int item = scanner.nextInt();
                item--;
                if (item >= 0 || item < list.size()){
                    list.get(item).excecute(board, spelers[currentPlayer] );
                    askingMove = false;
                }else {
                    System.out.println("please use a value between 1 and " + list.size());
                }


            }

            currentPlayer = (currentPlayer + 1 ) % spelers.length;

        }
    }
}