package com;

import java.util.Random;

public class Game {
    private Cell[][] board;

    PieceType[] players;

    public Game() {
        players = new PieceType[]{PieceType.X, PieceType.O};
        board = new Cell[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void initialize() {
        Random random = new Random();
        int turn = random.nextInt(2);

        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            if (board[x][y].getPieceType() != null) {
                continue;
            }

            board[x][y].setPieceType(players[turn]);

            System.out.println("Player " + players[turn] + " placed at " + x + ", " + y );

            if (checkThreeInARow(x, y, board[x][y].getPieceType())) {
                System.out.println(players[turn] + " won");
                break;
            }

            turn = (turn + 1) % 2;
        }
    }

    private boolean checkThreeInARow(int x, int y, PieceType pieceType) {
        if (checkDirection(x, y, pieceType, Direction.diagonalUpLeft) + checkDirection(x - 1, y + 1, pieceType, Direction.diagonalDownRight) == 3) return true;
        if (checkDirection(x, y, pieceType, Direction.diagonalUpRight) + checkDirection(x - 1, y - 1, pieceType, Direction.diagonalDownLeft) == 3) return true;
        if (checkDirection(x, y, pieceType, Direction.straightUp) + checkDirection(x - 1, y, pieceType, Direction.straightDown) == 3) return true;
        if (checkDirection(x, y, pieceType, Direction.straightLeft) + checkDirection(x, y + 1, pieceType, Direction.straightRight) == 3) return true;

        return false;
    }

    private int checkDirection(int x, int y, PieceType pieceType, Direction direction) {
        if (x < 0 || y <0 || x == 3 || y == 3) return 0;

        int total = 0;

        if (board[x][y].getPieceType() == pieceType) {
            if (direction == Direction.diagonalUpLeft) return 1 + checkDirection(x + 1, y - 1, pieceType, direction);
            if (direction == Direction.diagonalUpRight) return 1 + checkDirection(x + 1, y + 1, pieceType, direction);
            if (direction == Direction.diagonalDownLeft) return 1 + checkDirection(x - 1, y - 1, pieceType, direction);
            if (direction == Direction.diagonalDownRight) return 1 + checkDirection(x - 1, y + 1, pieceType, direction);
            if (direction == Direction.straightUp) return 1 + checkDirection(x + 1, y, pieceType, direction);
            if (direction == Direction.straightDown) return 1 + checkDirection(x - 1, y, pieceType, direction);
            if (direction == Direction.straightLeft) return 1 + checkDirection(x, y - 1, pieceType, direction);
            if (direction == Direction.straightRight) return 1 + checkDirection(x, y + 1, pieceType, direction);
        }

        return 0;
    }
}
