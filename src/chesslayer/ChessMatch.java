package chesslayer;

import boardgame.Board;
import boardgame.Piece;
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

    public ChessPiece performMove(ChessPosition positionOrigem, ChessPosition positionDestino) {
        Position origem = positionOrigem.toPosition();
        Position destino = positionDestino.toPosition();
        validateOrigin (origem);
        validadeDestiny(origem, destino);
        Piece pecaCapturada = makeMove(origem, destino);
        return (ChessPiece) pecaCapturada;
    }

    public void validateOrigin(Position origem) {
        if (!board.thereIsAPiece(origem)) {
            throw new ChessException("Não Existem peças nessa posição!");
        };
    }

    public void validadeDestiny(Position source, Position destiny) {
        if (!board.piece(source).possibleMove(destiny)) {
            throw new ChessException("Esta peça não pode se mover para esta posição!");
        };
    }



    public Piece makeMove(Position origem, Position destino) {
        Piece pecaASerMovida = board.removePiece(origem);
        Piece pecaCapturada = board.piece(destino);
        board.placePiece(pecaASerMovida, destino);
        return pecaCapturada;

    }

    public void initialSetup () {
        // PEÇAS PRETAS
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));



    }
}
