package com.home.questionchallenge.utils;

import com.home.questionchallenge.models.Answer;
import com.home.questionchallenge.models.Category;
import com.home.questionchallenge.models.Question;

import java.util.ArrayList;
import java.util.List;

public final class QuestionReading {
    
    private QuestionReading(){}
    
    public static List<Question> getQuestionsCSV(String fileName) {
        List<Question> questionList = new ArrayList<>();
        List<List<String >> dataList = CsvReading.readCSV(fileName);

        try {
            for (List<String> data : dataList) {
                Question question = new Question(data.get(1));
                question.setCategory(Category.valueOf(data.get(0)));
                question.setCorrectAnswer(data.get(2));

                List<Answer> answerList = new ArrayList<>();
                for (int i = 3, j = 1; i < 7; i++, j++) {
                    Answer answer = new Answer(j, data.get(i));
                    answerList.add(answer);
                }
                question.setAnswerList(answerList);

                questionList.add(question);

            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Ha ocurrido un error en la obtención de las preguntas para el juego: " + e.getMessage() + ". Disculpe las molestias causadas.");
            System.exit(1);
        }
        return questionList;
    }

}
