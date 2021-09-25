package com.home.questionchallenge.utils;

import com.home.questionchallenge.models.*;

import java.util.ArrayList;
import java.util.List;

public final class GameSetup {

    private GameSetup(){}

    public static Session setUp(Player player){

        List<Question> questionList = QuestionReading.getQuestionsCSV("src/main/resources/questions.csv");


        Round round1 = new Round(1, 200, questionList);
        Round round2 = new Round(2,400,questionList);
        Round round3 = new Round(3,600,questionList);
        Round round4 = new Round(4,800,questionList);
        Round round5 = new Round(5,1000,questionList);

        List<Round> roundList = new ArrayList<>();
        roundList.add(round1);
        roundList.add(round2);
        roundList.add(round3);
        roundList.add(round4);
        roundList.add(round5);

        return new Session(player, roundList,3000);


    }
}
