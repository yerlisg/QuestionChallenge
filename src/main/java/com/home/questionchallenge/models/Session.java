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

    public Player getPlayer() {
        return player;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public int getMaximumScore() {
        return maximumScore;
    }

}
