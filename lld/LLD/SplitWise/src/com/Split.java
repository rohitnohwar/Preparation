package com;

public class Split {
    User user;
    int splitAmount;

    public Split(User userId, int splitAmount) {
        this.user = userId;
        this.splitAmount = splitAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(int splitAmount) {
        this.splitAmount = splitAmount;
    }
}
