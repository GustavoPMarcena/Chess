package chesslayer;

import boardgame.Board;
import boardgame.Piece;

import java.awt.*;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color ) {
        super(board);
        this.color = color;
    }
}
