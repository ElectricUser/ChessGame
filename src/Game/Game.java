package Game;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        boolean winner = false;
        int turn = 1;
        ArrayList<String> moveHistory = new ArrayList<>();

        // Enroll users

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Chess Game");

        String player1Name = "";
        String player2Name = "";

        while (player1Name.equals("")) {
            System.out.println("What's the name of white player?");
            player1Name = sc.nextLine();
        }

        while (player2Name.equals("")) {
            System.out.println("What's the name of black player?");
            player2Name = sc.nextLine();
        }

        System.out.println("The game has begun!");

        Board board = new Board();
        board.movePiece("P5", "w", "e4");

        // Define play loop
        while(!winner){
            System.out.println(board.printBoard());
            if(turn % 2 != 0){
                System.out.println("White to move: ");
                // verify if move is valid
                String move = sc.nextLine();
                // move format: [pieceName][destinedPosition]
                String pieceName = move.split(" ")[0];
                String destination = move.split(" ")[1];
                System.out.println(pieceName);
                System.out.println(destination);
                moveHistory.add(move);
                // update board
                turn++;
            }else {
                System.out.println("Black to move: ");
                // verify if move is valid
                String move = sc.nextLine();
                System.out.println(move);
                //movesHistory.add(move);
                turn++;
            }

        }

    }
}
