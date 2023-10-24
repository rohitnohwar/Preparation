package chess;

import chess.piece.Piece;

public class Cell {
    int x;
    int y;

    Piece piece;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }
}
