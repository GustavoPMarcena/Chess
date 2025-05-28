package chesslayer;

import boardgame.Board;
import boardgame.Piece;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] novoVetor = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i<board.getRows(); i++) {
            for (int j = 0; i< board.getColumns(); j++) {
                novoVetor[i][j] = (ChessPiece) board.piece(board.getRows(), board.getColumns());
            }
        }
        return novoVetor;
    }
}
