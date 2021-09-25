package com.home.questionchallenge.models;


import java.util.List;

public class Session {

    private Player player;
    private List<Round> roundList;
    private int maximumScore;


    public Session(Player player, List<Round> roundList, int maximumScore) {
        this.player = player;
        this.roundList = roundList;
        this.maximumScore = maximumScore;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public Player getPlayer() { return player; }

    public int getMaximumScore() {
        return maximumScore;
    }

}
