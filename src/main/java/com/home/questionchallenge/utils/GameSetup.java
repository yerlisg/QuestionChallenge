package com.home.questionchallenge.utils;

import com.home.questionchallenge.models.Question;
import com.home.questionchallenge.models.Round;
import com.home.questionchallenge.models.Session;
import com.home.questionchallenge.models.Player;

import java.util.List;

public final class GameSetup {

    private static final int SCORE_ROUND_1 = 200;
    private static final int SCORE_ROUND_2 = 400;
    private static final int SCORE_ROUND_3 = 600;
    private static final int SCORE_ROUND_4 = 800;
    private static final int SCORE_ROUND_5 = 1000;
    private static final int MAXIMUM_SCORE = 3000;

    private GameSetup(){}

    public static Session setUp(Player player){

        List<Question> questionList = QuestionReading.getQuestionsCSV("src/main/resources/questions.csv");

        Round.setQuestionList(questionList);
        Round round1 = new Round(1,SCORE_ROUND_1);
        Round round2 = new Round(2,SCORE_ROUND_2);
        Round round3 = new Round(3,SCORE_ROUND_3);
        Round round4 = new Round(4,SCORE_ROUND_4);
        Round round5 = new Round(5,SCORE_ROUND_5);

        return new Session(player, MAXIMUM_SCORE)
                .addRound(round1)
                .addRound(round2)
                .addRound(round3)
                .addRound(round4)
                .addRound(round5);
    }

}
