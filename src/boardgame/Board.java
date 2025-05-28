package boardgame;

public class Board {
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
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
    }

    public Piece removePiece(Position position) {
        Piece removedPiece = pieces[position.getRow()][position.getColumn()];
        pieces[position.getRow()][position.getColumn()] = null;
        return removedPiece;
    }

    public boolean positionExists (Position position) {
        return (position.getRow() > this.rows && position.getRow() < 0)
                &&
                (position.getColumn() > this.columns && position.getColumn() < 0);
    }


}
