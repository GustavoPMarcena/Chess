package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import java.awt.*;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        return matriz;
    }

    @Override
    public String toString() {
        return "R";
    }
}
