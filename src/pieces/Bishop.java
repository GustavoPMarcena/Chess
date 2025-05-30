package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import chesslayer.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        // direita cima
        Position p = new Position(getPosition().getRow() - 1, getPosition().getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        checkEnemyPosition(p, matriz);

        //  esquerda cima
        p.setValues(getPosition().getRow() - 1, getPosition().getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        checkEnemyPosition(p, matriz);

        // diagonal esquerda baixo
        p.setValues(getPosition().getRow() + 1, getPosition().getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        checkEnemyPosition(p, matriz);

        // diagonal direita baixo
        p.setValues(getPosition().getRow() + 1, getPosition().getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        checkEnemyPosition(p, matriz);

        return matriz;
    }

    private void checkEnemyPosition(Position p, boolean[][] matriz) {
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }
    }

    @Override
    public String toString() {
        return "️♗️" ;
    }
}
