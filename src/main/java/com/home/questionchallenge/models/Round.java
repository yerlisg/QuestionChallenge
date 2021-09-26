package com.home.questionchallenge.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {

    private int roundNumber;
    private int roundScore;
    private static List<Question> questionList;
    private static Random random = new Random();

    public Round(int roundNumber, int roundScore) {
        this.roundNumber = roundNumber;
        this.roundScore = roundScore;
    }

    public static void setQuestionList(List<Question> questionList) {
        Round.questionList = questionList;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public Question getRoundQuestion() {
        List<Question> roundQuestion = new ArrayList<>();
        for (Question question : questionList) {
            if (question.getCategory().getRound() == roundNumber){
                roundQuestion.add(question);
            }
        }
        return roundQuestion.get(random.nextInt(5));
    }
}
