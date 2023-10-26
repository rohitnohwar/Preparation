package chess;

import chess.piece.Piece;

import java.io.*;
import java.util.Map;

import static chess.Constants.initalPositions;

public class Board {
    private Cell[][] board;
    public Board() throws IOException, ClassNotFoundException {
        this.board = new Cell[8][8];
        initializeBoard();
    }

    public void initializeBoard() throws IOException, ClassNotFoundException {
        for (Map.Entry<Piece, int[][]> m: initalPositions.entrySet()) {
            for (int[] i: m.getValue()) {
                board[i[0]][i[1]] = new Cell(i[0], i[1]);
                Piece piece = deepCopy(m.getKey());
                piece.setIsWhite(true);
                piece.setIsKilled(false);
                board[i[0]][i[1]].setPiece(piece);

                board[board.length - i[0] - 1][board[0].length - i[1] - 1] = new Cell(board.length - i[0], board[0].length - i[1]);
                Piece oppositePiece = deepCopy(m.getKey());
                oppositePiece.setIsWhite(false);
                oppositePiece.setIsKilled(false);
                board[board.length - i[0] - 1][board[0].length - i[1] - 1].setPiece(oppositePiece);
            }
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public static Piece deepCopy(Piece piece) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(piece);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Piece) ois.readObject();
    }

    public Cell get(int x, int y) {
        return board[x][y];
    }
}