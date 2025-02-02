package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(String name,String color) {
        super(name, color);
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        ArrayList<String> moves = new ArrayList<>();

        int row = Integer.parseInt(currentPosition.substring(0, 1));
        int column = Integer.parseInt(currentPosition.substring(1, 2));

        // verify is position exists on the board
        // if yes add to list else ignore

        // possible coordinates

        int r1 = row - 2;
        int c1 = column + 1;
        if (r1 <= 7 && c1 <= 7) {
            moves.add("" + r1 + c1);
        }

        int r2 = row - 1;
        int c2 = column + 2;
        if (r2 <= 7 && c2 <= 7) {
            moves.add("" + r2 + c2);
        }

        int r3 = row + 1;
        int c3 = column + 2;
        if (r3 <= 7 && c3 <= 7) {
            moves.add("" + r3 + c3);
        }

        int r4 = row + 2;
        int c4 = column + 1;
        if (r4 <= 7 && c4 <= 7) {
            moves.add("" + r4 + c4);
        }

        int r5 = row + 2;
        int c5 = column - 1;
        if (r5 <= 7 && c5 <= 7) {
            moves.add("" + r5 + c5);
        }

        int r6 = row + 1;
        int c6 = column - 2;
        if (r6 <= 7 && c6 <= 7) {
            moves.add("" + r6 + c6);
        }

        int r7 = row - 1;
        int c7 = column - 2;
        if (r7 <= 7 && c7 <= 7) {
            moves.add("" + r7 + c7);
        }

        int r8 = row - 2;
        int c8 = column - 1;
        if (r8 <= 7 && c8 <= 7) {
            moves.add("" + r8 + c8);
        }

        return moves;
    }

}
