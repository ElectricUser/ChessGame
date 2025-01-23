package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(String name,String color) {
        super(name, color);
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        return null;
    }

}
