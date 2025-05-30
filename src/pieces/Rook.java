package pieces;

import boardgame.Board;
import boardgame.Position;
import chesslayer.ChessPiece;

import chesslayer.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
        //Olhar se dá pra simplificar o código

        Position p = new Position(position.getRow() - 1, position.getColumn());
        // Verificando valores de cima
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()-1);
        }
        checkEnemyPosition(p, matriz);

        // Verificando valores de baixo
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()+1);
        }
        checkEnemyPosition(p, matriz);

        // Verificando para a esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        checkEnemyPosition(p, matriz);

        //Verificando para a direita

        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
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
        return "R";
    }
}
