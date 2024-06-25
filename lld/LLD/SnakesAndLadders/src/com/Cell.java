package com;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cell {
    private int xCord;
    private int yCord;

    private Set<Integer> players;

    private Snake snake;
    private Ladder ladder;

    public Cell(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
        players = new HashSet<>();
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public Set<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Integer> players) {
        this.players = players;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
