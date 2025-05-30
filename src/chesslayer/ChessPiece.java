package chesslayer;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import chesslayer.Color;

public abstract class ChessPiece extends Piece {
    private Color color;
    protected int movementNumber;

    public ChessPiece(Board board, Color color ) {
        super(board);
        this.color = color;
        movementNumber = 0;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }

    public int getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber() {
        this.movementNumber += 1;
    }
}
