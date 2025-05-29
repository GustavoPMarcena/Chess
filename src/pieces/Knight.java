package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import chesslayer.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "N";
    }
}
