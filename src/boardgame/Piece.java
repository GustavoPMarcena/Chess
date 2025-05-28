package boardgame;

public class Piece {
    private Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    public Position getPosition() {
        return position;
    }

    public boolean[][] possibleMoves() {
        return null;
    }

    public boolean possibleMove(Position position) {
        return false;
    }


}
