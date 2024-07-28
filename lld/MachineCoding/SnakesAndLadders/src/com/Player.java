package com;

public class Player {
    private int index;
    private Cell currentCell;

    public Player(int index, Cell currentCell) {
        this.index = index;
        this.currentCell = currentCell;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}
