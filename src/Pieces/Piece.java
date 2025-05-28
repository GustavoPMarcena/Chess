package Pieces;

import Pieces.Positions.Position;

public abstract class Piece {
    private Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public boolean possibleMoves () {
        return false;
    }

    public boolean possibleMoves(Position position) {
        return false;
    }

    public boolean isThereAnyPossibleMove() {
        return false;
    }

}
