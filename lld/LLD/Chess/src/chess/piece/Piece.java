package chess.piece;

import chess.Cell;

public abstract class Piece {
    private boolean isWhite;

    private boolean isKilled;

    public boolean getIsWhite() {
        return isWhite;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean getIsKilled() {
        return isKilled;
    }

    public void setIsKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    protected boolean outOfBoundCheck(Cell fromCell, Cell toCell) {
        if (fromCell.getX() < 0 || fromCell.getX() >= 8 || fromCell.getY() < 0 || fromCell.getY() >= 8) return false;
        return true;
    }

    public abstract boolean isValidMove(Cell fromCell, Cell toCell);
}
