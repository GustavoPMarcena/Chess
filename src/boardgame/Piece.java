package boardgame;

public abstract class Piece {
    private Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    public Position getPosition() {
        return position;
    }

    public Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public abstract boolean possibleMove(Position position) ;


}
