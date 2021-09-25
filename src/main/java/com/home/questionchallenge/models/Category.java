package com.home.questionchallenge.models;

public enum Category {

    BEGINNER(1),
    EASY(2),
    INTERMEDIATE(3),
    HARD(4) ,
    ADVANCED(5);

    private int round;

    Category(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

}
