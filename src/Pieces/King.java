package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class King extends Piece{
    public King(String name, String color) {
        super(name, color);
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        return null;
    }

}
