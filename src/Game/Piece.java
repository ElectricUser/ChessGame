package Game;
import java.util.ArrayList;

public abstract class Piece {
    private final String name;
    private final String color;
    private boolean hasMoved = false;


    public Piece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract ArrayList<String> validMoves(Piece[][] board, String currentPosition);

    public String getName() {
        return name;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void moveFirstTime() {
        this.hasMoved = true;
    }

    public String toString() {
        return color + name;
    }
}
