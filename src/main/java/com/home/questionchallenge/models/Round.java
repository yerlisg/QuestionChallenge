package com.home.questionchallenge.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Round {

    private int roundNumber;
    private int roundScore;
    private List<Question> questionList;

    public Round(int roundNumber, int roundScore, List<Question> questionList) {
        this.roundNumber = roundNumber;
        this.roundScore = roundScore;
        this.questionList = questionList;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public Question getQuestionRound() {

        List<Question> questionRound = new ArrayList<>();
        for (Question question : questionList) {
            if (question.getCategory().getRound() == roundNumber){
                questionRound.add(question);
            }
        }
        Random random = new Random();
        return questionRound.get(random.nextInt(5));
    }


}
