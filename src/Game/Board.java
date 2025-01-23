package Game;
import Pieces.*;
import utils.Utils;

import java.util.ArrayList;
public class Board {
    private Piece[][] board;

    public Board() {
        String COLOR_BLACK = "b";
        String COLOR_WHITE = "w";
        board = new Piece[8][8];

        // Initiate Board
        //[[BLACK PIECES],
        // [BLACK PAWNS],
        // ...
        // [WHITE PAWNS],
        // [WHITE PIECES]]

        // Initiate black pieces
        Piece blackRook1 = new Rook("lR",COLOR_BLACK);
        Piece blackKnight1 = new Knight("lK", COLOR_BLACK);
        Piece blackBishop1 = new Bishop("lB", COLOR_BLACK);
        Piece blackQueen = new Queen("Q", COLOR_BLACK);
        Piece blackKing = new King("K" ,COLOR_BLACK);
        Piece blackBishop2 = new Bishop("rB" ,COLOR_BLACK);
        Piece blackKnight2 = new Knight("rK", COLOR_BLACK);
        Piece blackRook2 = new Rook("rR", COLOR_BLACK);

        Piece blackPawn1 = new Pawn("P1", COLOR_BLACK);
        Piece blackPawn2 = new Pawn("P2", COLOR_BLACK);
        Piece blackPawn3 = new Pawn("P3", COLOR_BLACK);
        Piece blackPawn4 = new Pawn("P4", COLOR_BLACK);
        Piece blackPawn5 = new Pawn("P5", COLOR_BLACK);
        Piece blackPawn6 = new Pawn("P6", COLOR_BLACK);
        Piece blackPawn7 = new Pawn("P7", COLOR_BLACK);
        Piece blackPawn8 = new Pawn("P8", COLOR_BLACK);

        board[0][0] = blackRook1;
        board[0][1] = blackKnight1;
        board[0][2] = blackBishop1;
        board[0][3] = blackQueen;
        board[0][4] = blackKing;
        board[0][5] = blackBishop2;
        board[0][6] = blackKnight2;
        board[0][7] = blackRook2;
        board[1][0] = blackPawn1;
        board[1][1] = blackPawn2;
        board[1][2] = blackPawn3;
        board[1][3] = blackPawn4;
        board[1][4] = blackPawn5;
        board[1][5] = blackPawn6;
        board[1][6] = blackPawn7;
        board[1][7] = blackPawn8;

        // Initiate white pieces

        Piece whiteRook1 = new Rook("lR",COLOR_WHITE);
        Piece whiteKnight1 = new Knight("lK", COLOR_WHITE);
        Piece whiteBishop1 = new Bishop("lB", COLOR_WHITE);
        Piece whiteQueen = new Queen("Q", COLOR_WHITE);
        Piece whiteKing = new King("K" ,COLOR_WHITE);
        Piece whiteBishop2 = new Bishop("rB" ,COLOR_WHITE);
        Piece whiteKnight2 = new Knight("rK", COLOR_WHITE);
        Piece whiteRook2 = new Rook("rR", COLOR_WHITE);

        Piece whitePawn1 = new Pawn("P1", COLOR_WHITE);
        Piece whitePawn2 = new Pawn("P2", COLOR_WHITE);
        Piece whitePawn3 = new Pawn("P3", COLOR_WHITE);
        Piece whitePawn4 = new Pawn("P4", COLOR_WHITE);
        Piece whitePawn5 = new Pawn("P5", COLOR_WHITE);
        Piece whitePawn6 = new Pawn("P6", COLOR_WHITE);
        Piece whitePawn7 = new Pawn("P7", COLOR_WHITE);
        Piece whitePawn8 = new Pawn("P8", COLOR_WHITE);

        board[7][0] = whiteRook1;
        board[7][1] = whiteKnight1;
        board[7][2] = whiteBishop1;
        board[7][3] = whiteQueen;
        board[7][4] = whiteKing;
        board[7][5] = whiteBishop2;
        board[7][6] = whiteKnight2;
        board[7][7] = whiteRook2;

        board[6][0] = whitePawn1;
        board[6][1] = whitePawn2;
        board[6][2] = whitePawn3;
        board[6][3] = whitePawn4;
        board[6][4] = whitePawn5;
        board[6][5] = whitePawn6;
        board[6][6] = whitePawn7;
        board[6][7] = whitePawn8;

    }

    public String printBoard() {
        int counter = 8;
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    boardString.append(" x ");
                }else{
                    boardString.append(board[i][j]);
                }
                if (j == 7){
                    boardString.append(" |");
                    boardString.append(counter);
                    boardString.append("|\n");
                }else {
                    boardString.append("|");
                }

            }
            counter--;
        }
        boardString.append("################################\n");
        boardString.append(" A | B | C | D | E | F | G | H |");
        return boardString.toString();

    }

    /**
     * returns the coordinates of a piece on the board array
     * @param piece a piece of chess
     * @return the position on the board array (e.g 03)
     */
    public String getPiecePosition(Piece piece){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] != null){
                    if(board[i][j].toString().equals(piece.toString())){
                        return "" + i + j;
                    }
                }
            }
        }
        // in case the piece is no longer in the board
        return "";
    }


    /**
     * returns the piece on a certain position of the board
     * @param position position in the chess board (e.g e4)
     * @return the piece on that position on the board
     */
    public Piece getPieceAt(String position){
        Utils utils = new Utils();
        String currentPosition = utils.convertGamePositionToArrayPosition(position);
        int x = Integer.parseInt(currentPosition.substring(0, 1));
        int y = Integer.parseInt(currentPosition.substring(1, 2));
        return board[x][y];
    }

    // piece name ex: lR -> left rook
    public boolean movePiece(String pieceName, String pieceColor, String destination) {
        //get the piece's current position
        String currentPosition = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (board[i][j] == null){
                    continue;
                }
               if (board[i][j].getName().equals(pieceName) && board[i][j].getColor().equals(pieceColor)){
                   // it's found the piece
                   currentPosition = getPiecePosition(board[i][j]);
                   Piece piece = board[i][j];
                   ArrayList<String> validMoves = piece.validMoves(board, currentPosition);
                   // is the destination a valid move?
                   System.out.println("valid moves: " + validMoves.toString());
                   // is the destination in the list of available moves?
                   // yes -> move it and update the board
                   // no -> return false
               }
            }
        }
        // in case the piece is no longer on the board
        return false;
    }
}
