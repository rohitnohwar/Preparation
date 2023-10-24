package chess.piece;

import chess.Cell;

public class Horse extends Piece {
    public boolean isValidMove(Cell fromCell, Cell toCell) {
        int x = fromCell.getX();
        int y = fromCell.getY();
        int x1 = toCell.getX();
        int y1 = toCell.getY();

        return outOfBoundCheck(fromCell, toCell) &&
                (Math.abs(x1 - x) == 1 || Math.abs(y1 - y) ==1);
    }
}
