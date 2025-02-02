package Pieces;
import Game.Piece;

import java.util.ArrayList;

public class Pawn extends Piece {
    public boolean hasMoved;

    public Pawn(String name, String color) {
        super(name, color);
        this.hasMoved = false;
    }

    @Override
    public ArrayList<String> validMoves(Piece[][] board, String currentPosition) {
        ArrayList<String> validMoves = new ArrayList<>();

        int row = Integer.parseInt(currentPosition.substring(0, 1));
        int column = Integer.parseInt(currentPosition.substring(1, 2));

        // is the piece in it is original place?
        if(!hasMoved){
            // has the option to go 2 squares forward
            if (this.getColor().equals("w")){
                int pt1 = row - 2;
                String p = "" + pt1 + column;
                validMoves.add(p);
            }else {
                int pt1 = row + 2;
                String p = "" + pt1 + column;
                validMoves.add(p);
            }
        }
            //has already moved so it can no longer move 2 squares forward
            // 1 square move
            if (this.getColor().equals("w")){
                int pt1 = row - 1;
                String p = "" + pt1 + column;
                validMoves.add(p);
            }else {
                int pt1 = row + 1;
                String p = "" + pt1 + column;
                validMoves.add(p);
            }
            // take a piece in a diagonal
            if (this.getColor().equals("w")){
                // does a piece exist at it's left diagonal? and is it of the opposite color?
                if(board[row - 1][column + 1] != null && board[row - 1][column + 1].getColor().equals("b")){
                    int pt1 = row - 1;
                    int pt2 = column + 1;
                    String p = "" + pt1 + pt2;
                    validMoves.add(p);
                }
                // does a piece exist at it's right diagonal?
                if(board[row - 1][column - 1] != null && board[row - 1][column - 1].getColor().equals("b")){
                    int pt1 = row - 1;
                    int pt2 = column - 1;
                    String p = "" + pt1 + pt2;
                    validMoves.add(p);
                }
            }else{
                // does a piece exist at it's left diagonal?
                if(board[row + 1][column + 1] != null && board[row + 1][column + 1].getColor().equals("w")){
                    int pt1 = row + 1;
                    int pt2 = column + 1;
                    String p = "" + pt1 + pt2;
                    validMoves.add(p);
                }
                // does a piece exist at it's right diagonal?
                if(board[row + 1][column - 1] != null && board[row + 1][column - 1].getColor().equals("w")){
                    int pt1 = row + 1;
                    int pt2 = column - 1;
                    String p = "" + pt1 + pt2;
                    validMoves.add(p);
                }
            }

        return validMoves;
    }

}
