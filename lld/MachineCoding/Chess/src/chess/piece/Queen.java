package chess.piece;

import chess.Cell;

public class Queen extends Piece {
    public boolean isValidMove(Cell fromCell, Cell toCell) {
        int x = fromCell.getX();
        int y = fromCell.getY();
        int x1 = toCell.getX();
        int y1 = toCell.getY();

        return outOfBoundCheck(fromCell, toCell) &&
                (Math.abs(x1 - x) == Math.abs(y1 - y) || (x == x1 || y == y1));
    }
}
