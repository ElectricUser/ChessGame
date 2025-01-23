package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(String name, String color) {
        super(name, color);
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        return null;
    }

}
