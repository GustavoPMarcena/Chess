package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import java.awt.*;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return null;
    }

    @Override
    public boolean possibleMove(Position position) {
        return false;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
