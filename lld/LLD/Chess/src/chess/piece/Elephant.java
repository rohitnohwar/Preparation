package chess.piece;

import chess.Cell;

public class Elephant extends Piece {
    public boolean isValidMove(Cell fromCell, Cell toCell) {
        int x = fromCell.getX();
        int y = fromCell.getY();
        int x1 = toCell.getX();
        int y1 = toCell.getY();

        return outOfBoundCheck(fromCell, toCell) &&
                (x == x1 || y == y1);
    }
}
