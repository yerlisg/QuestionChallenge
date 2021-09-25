package com.home.questionchallenge.models;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private int roundNumber;
    private int roundScore;
    private List<Question> questionList;

    public Round(int roundNumber, int roundScore, List<Question> questionList) {
        this.roundNumber = roundNumber;
        this.roundScore = roundScore;
        this.questionList = questionList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public List<Question> getQuestionRound() {

        List<Question> questionRound = new ArrayList<>();
        for (Question question : questionList) {
            if (question.getCategory().getRound() == roundNumber){
                questionRound.add(question);
            }
        }
        return questionRound;
    }


}
