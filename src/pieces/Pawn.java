package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import chesslayer.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] movimentos = new boolean[getBoard().getRows()][getBoard().getColumns()];
        for (int i = 0; i < getBoard().getRows(); i++) {
            for (int j = 0; j < getBoard().getColumns(); j++) {
                movimentos[i][j] = possibleMove(new Position(i, j));
            }
        }
        return movimentos;
    }

    @Override
    public boolean possibleMove(Position position) {
        return true;
    }

    @Override
    public String toString() {
        return "P";
    }
}
