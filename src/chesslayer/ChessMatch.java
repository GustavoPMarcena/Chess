package chesslayer;

import boardgame.Board;
import boardgame.Position;
import pieces.*;

import java.awt.*;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] novoVetor = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i<board.getRows(); i++) {
            for (int j = 0; j< board.getColumns(); j++) {
                novoVetor[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return novoVetor;
    }

    public void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition()) ;
    }

    public void initialSetup () {
        // PEÇAS PRETAS
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));



    }
}
