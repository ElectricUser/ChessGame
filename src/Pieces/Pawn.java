package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(String name, String color) {
        super(name, color);
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        ArrayList<String> validMoves = new ArrayList<>();

        int x = Integer.parseInt(currentPosition.substring(0, 1));
        int y = Integer.parseInt(currentPosition.substring(1, 2));

        // is the piece in it's original place?
        if(!this.hasMoved()){
            // has the option to go 2 squares forward
            if (this.getColor().equals("w")){
                int x1 = x - 2;
                String p = "" + x1 + y;
                validMoves.add(p);
            }else {
                int x1 = x + 2;
                String p = "" + x1 + y;
                validMoves.add(p);
            }
        }
            //has already moved so it can no longer move 2 squares forward
            // 1 square move
            if (this.getColor().equals("w")){
                int x1 = x - 1;
                String p = "" + x1 + y;
                validMoves.add(p);
            }else {
                int x1 = x + 1;
                String p = "" + x1 + y;
                validMoves.add(p);
            }
            // take a piece in a diagonal
            if (this.getColor().equals("w")){
                // does a piece exist at it's left diagonal?
                if(board[x - 1][y + 1] != null){
                    int x1 = x - 1;
                    int y1 = y + 1;
                    String p = "" + x1 + y1;

                    validMoves.add(p);
                }
                // does a piece exist at it's right diagonal?
                if(board[x -1][y - 1] != null){
                    int x1 = x - 1;
                    int y1 = y - 1;
                    String p = "" + x1 + y1;
                    validMoves.add(p);
                }
            }else{
                // does a piece exist at it's left diagonal?
                if(board[x + 1][y + 1] != null){
                    int x1 = x + 1;
                    int y1 = y + 1;
                    String p = "" + x1 + y1;
                    validMoves.add(p);
                }
                // does a piece exist at it's right diagonal?
                if(board[x + 1][y - 1] != null){
                    int x1 = x + 1;
                    int y1 = y - 1;
                    String p = "" + x1 + y1;
                    validMoves.add(p);
                }
            }
            // does a piece exist at it's right diagonal?


        return validMoves;
    }

}
