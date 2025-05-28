package Pieces;

import Pieces.Positions.Position;

public abstract class ChessPiece extends Piece{

    private Color color;
    private int moveCount;

    public ChessPiece(Position position, Color color) {
        super(position);
        this.color = color;
    }

    public boolean isThereOpponentPiece (Position position) {
        return false;
    }

    public void increaseMoveCount() {
        moveCount += 1;
    }

    public void decreaseMoveCount() {
        moveCount -= 1;
    }

}
