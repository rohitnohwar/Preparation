package com;

public class Board {
    private Cell[][] board;
    private int dimension;

    private void setCells() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public Board() {
        this.dimension = 10;
        board = new Cell[this.dimension][this.dimension];
        setCells();
    }
    public Board(int n) {
        this.dimension = n;
        board = new Cell[this.dimension][this.dimension];
        setCells();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
