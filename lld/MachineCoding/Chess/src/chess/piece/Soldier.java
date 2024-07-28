package chess.piece;

import chess.Cell;

public class Soldier extends Piece {
    public boolean isValidMove(Cell fromCell, Cell toCell) {
        if (!outOfBoundCheck(fromCell, toCell)) return false;

        return true;
    }
}
