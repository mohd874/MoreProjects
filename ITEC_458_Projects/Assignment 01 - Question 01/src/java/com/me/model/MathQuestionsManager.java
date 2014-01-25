/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saeed
 */
public class MathQuestionsManager {

    private static List<MathQuestion> questions;
    private static int correctAnswers;
    private static int numberOfQuestions;
    
    public MathQuestionsManager() {
        
    }

    public static List<MathQuestion> getQuestions() {
        if(questions == null)generateQuestions();
        return questions;
    }

    public static void setQuestions(List<MathQuestion> questionsList) {
        questions = questionsList;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public static void setNumberOfQuestions(int numberOfQuestions) {
        MathQuestionsManager.numberOfQuestions = numberOfQuestions;
    }
    
    private static void generateQuestions() {
        List<MathQuestion> questions = new ArrayList<MathQuestion>();
        for(int i=0;i<10;i++){
            questions.add(new MathQuestion());
        }
        setQuestions(questions);
        setNumberOfQuestions(questions.size());
    }
    
    public static String evaluateAnswer(MathQuestion question, String answer){
        float userAnswer = 0f;
        try {
            question.setUserAnswer(answer.trim());
            userAnswer = Float.parseFloat(answer.trim());
            if(userAnswer == question.getCorrectAnswer()){
                correctAnswers++;
                question.setResult("correct");
                return "correct";
            }else{
                question.setResult("wrong");
                return "wrong";
            }
        } catch (NumberFormatException numberFormatException) {
            question.setResult("Invalid Input");
            return "Invalid Input";
        }
    }
    
    public static String getScore(){
        return correctAnswers+"/"+questions.size();
    }
}
