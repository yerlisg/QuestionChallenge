package com.home.questionchallenge.models;


import java.util.ArrayList;
import java.util.List;

public class Session {

    private static final int MAXIMUM_NUMBER_ROUNDS = 5;

    private Player player;
    private List<Round> roundList;
    private int maximumScore;

    public Session(Player player, int maximumScore) {
        this.player = player;
        this.maximumScore = maximumScore;
        roundList = new ArrayList<>();
    }

    public Session addRound(Round round){
        if(roundList.size() < MAXIMUM_NUMBER_ROUNDS){
            roundList.add(round);
        }
        return this;
    }

    public List<Round> getRoundList() { return roundList; }

    public int getMaximumScore() { return maximumScore; }

    public Player getPlayer() { return player; }
}
