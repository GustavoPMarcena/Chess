package boardgame;

import chesslayer.ChessException;

public class Board  {
    private final int rows;
    private final int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece (int row, int column) {
        return pieces[row][column];
    }

    public Piece piece (Position position) {
        validatePosition(position);
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        validatePosition(position);
        pieces[position.getRow()][position.getColumn()] = piece;
    }

    public Piece removePiece(Position position) {
        validatePosition(position);
        Piece removedPiece = pieces[position.getRow()][position.getColumn()];
        pieces[position.getRow()][position.getColumn()] = null;
        return removedPiece;
    }

    public boolean positionExists (int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public boolean positionExists (Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        validatePosition(position);
        return piece(position) != null;
    }

    public void validatePosition(Position position) {
        if(!positionExists(position)) {
            throw new ChessException("Posição não existe!");
        }
    }




}
