package com.home.questionchallenge.models;

import java.time.LocalDateTime;

public class Player {

    private String name;
    private int score = 0;
    private LocalDateTime gameDate;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getGameDate() { return gameDate; }

    public void setGameDate(LocalDateTime gameDate) { this.gameDate = gameDate; }

}
