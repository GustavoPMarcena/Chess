package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import chesslayer.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
