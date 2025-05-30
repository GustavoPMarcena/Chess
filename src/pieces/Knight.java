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
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        // cima direita
        Position p = new Position(position.getRow() - 2, position.getColumn() + 1);
        validateInternalMove(p, matriz);

        // direita cima
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        validateInternalMove(p, matriz);

        // cima esquerda
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        validateInternalMove(p, matriz);

        // esquerca cima
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        validateInternalMove(p, matriz);

        // baixo direita
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        validateInternalMove(p, matriz);

        // direita baixo

        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        validateInternalMove(p, matriz);

        // esquerda baixo

        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        validateInternalMove(p, matriz);

        // baixo esquerda

        p.setValues(position.getRow() + 2, position.getColumn() - 1);
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
        return "️️♘";
    }
}
