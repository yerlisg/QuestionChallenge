package com.home.questionchallenge.models;


import java.util.List;

public class Question {


    private String questionTitle;
    private Category category;
    private List<Answer> answerList;
    private String correctAnswer;


    public Question(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean validateWrongAnswer(String idAnswer){
        return !this.correctAnswer.equals(idAnswer);
    }


}
