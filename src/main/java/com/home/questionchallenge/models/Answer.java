package com.home.questionchallenge.models;

public class Answer {

    private int id;
    private String title;


    public Answer(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
