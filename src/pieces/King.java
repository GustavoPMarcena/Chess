package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;
import chesslayer.Color;

import chesslayer.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(getPosition().getRow() - 1, getPosition().getColumn());


        return matriz;

    }

    @Override
    public String toString() {
        return "k";
    }
}
