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
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // Nessa parte, verifico a cor da peça, para o movimento ser feito para cima, ou para baixo xd
        int colorCalculation = (getColor() == Color.WHITE) ? -1 : 1;

        // checar movimento para cima
        p.setValues(position.getRow() + colorCalculation, position.getColumn());
        validateInternalMove(p, matriz);
        // checar ataques laterais
        p.setValues(position.getRow() + colorCalculation, position.getColumn() + 1);
        checkEnemyPosition(p, matriz);
        p.setValues(position.getRow() + colorCalculation, position.getColumn() - 1);
        checkEnemyPosition(p, matriz);


        return matriz;
    }

    private void validateInternalMove(Position p, boolean[][] matriz) {
        if ((getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))) {
            matriz[p.getRow()][p.getColumn()] = true;
        }
    }

    private void checkEnemyPosition(Position p, boolean[][] matriz) {
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }
    }

    @Override
    public String toString() {
        return "️️♙";
    }
}
