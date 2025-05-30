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

        p.setValues(position.getRow() + 1, position.getColumn());
        validateInternalMove(p, matriz);
        p.setValues(position.getRow() - 1 , position.getColumn());
        validateInternalMove(p, matriz);
        p.setValues(position.getRow(), position.getColumn() + 1);
        validateInternalMove(p, matriz);
        p.setValues(position.getRow(), position.getColumn() - 1);
        validateInternalMove(p, matriz);
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        validateInternalMove(p, matriz);
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        validateInternalMove(p, matriz);
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        validateInternalMove(p, matriz);
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        validateInternalMove(p, matriz);

        return matriz;

    }

    private void validateInternalMove(Position p, boolean[][] matriz) {
        if (getBoard().positionExists(p) && (isThereOpponentPiece(p) || !getBoard().thereIsAPiece(p))) {
            matriz[p.getRow()][p.getColumn()] = true;
        }
    }

    @Override
    public String toString() {
        return "K" ;
    }
}
