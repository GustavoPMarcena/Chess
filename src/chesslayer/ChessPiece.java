package chesslayer;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import java.awt.*;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color ) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[0][];
    }

    @Override
    public boolean possibleMove(Position position) {
        return false;
    }
}
