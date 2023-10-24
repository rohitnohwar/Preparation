package chess;

import chess.piece.Piece;

public class Move {
    Player player;
    Cell fromCell;
    Cell toCell;
    Piece piece;

    public Move(Player player, Cell fromCell, Cell toCell) {
        this.toCell = toCell;
        this.fromCell = fromCell;
        this.player = player;
    }

    public boolean movePiece() {
        this.piece = fromCell.getPiece();

        if(this.piece == null ||
                !this.piece.isValidMove(this.fromCell, this.toCell) ||
                this.player.getIsWhite() != this.piece.getIsWhite() ||
                (this.toCell.getPiece() != null && this.toCell.getPiece().getIsWhite() == this.player.getIsWhite())
        ) return false;



        return true;
    }
}
