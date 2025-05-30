package chesslayer;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import pieces.*;

public class ChessMatch {
    private Board board;
    private Color turn;
    private boolean checkmate;
    private String mensagemVitoria;

    public ChessMatch() {
        this.board = new Board(8, 8);
        turn = Color.WHITE;
        checkmate = false;
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] novoVetor = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                novoVetor[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return novoVetor;
    }

    public void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public ChessPiece performMove(ChessPosition positionOrigem, ChessPosition positionDestino) {
        Position origem = positionOrigem.toPosition();
        Position destino = positionDestino.toPosition();
        validateOrigin(origem);
        validadeDestiny(origem, destino);
        Piece pecaCapturada = makeMove(origem, destino);
        ChessPiece pecaASerMovida = (ChessPiece) board.piece(origem);
        validateCheckmate(pecaCapturada);
        if(pecaCapturada != null) {
            if (((ChessPiece) pecaCapturada).getColor() == Color.WHITE) {
                board.addPecasCapturadasBrancas(pecaCapturada);
            } else {
                board.addPecasCapturadasPretas(pecaCapturada);
            }
        }

        if (pecaASerMovida != null) pecaASerMovida.setMovementNumber();
        changeTurn();
        return (ChessPiece) pecaCapturada;
    }

    public void validateOrigin(Position origem) {
        ChessPiece piece = (ChessPiece) board.piece(origem);
        if (piece.getColor() != turn) {
            throw new ChessException("Esta peça pertence ao turno do outros jogador!");
        }
        if (!board.thereIsAPiece(origem)) {
            throw new ChessException("Não Existem peças nessa posição!");
        }
        ;
    }

    public void validadeDestiny(Position source, Position destiny) {
        if (!board.piece(source).possibleMove(destiny)) {
            throw new ChessException("Esta peça não pode se mover para esta posição!");
        }
        ;
    }

    public void changeTurn() {
        if (turn == Color.WHITE) setTurn(Color.BLACK);
        else setTurn(Color.WHITE);
    }

    public Piece makeMove(Position origem, Position destino) {
        Piece pecaASerMovida = board.removePiece(origem);
        Piece pecaCapturada = board.piece(destino);
        board.placePiece(pecaASerMovida, destino);
        return pecaCapturada;

    }

    public void initialSetup() {
        // PEÇAS PRETAS
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));

        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));

        // PEÇAS BRANCAS
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));

        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
    }

    public Color getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public void setTurn(Color turn) {
        this.turn = turn;
    }

    public boolean isCheckmate() {
        return checkmate;
    }

    public String getMensagemVitoria() {
        return mensagemVitoria;
    }

    public void validateCheckmate(Piece piece) {
        if (piece instanceof King) {
            checkmate = true;
            if (((ChessPiece) piece).getColor() == Color.WHITE) {
                mensagemVitoria = "Vitória das Pretas";
            } else {
                mensagemVitoria = "Vitória das Brancas";
            }
        }
    }




}
