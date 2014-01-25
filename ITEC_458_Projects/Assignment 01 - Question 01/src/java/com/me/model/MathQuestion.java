/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.model;

import java.util.Random;

/**
 *
 * @author Saeed
 */
public class MathQuestion {

    private int num1;
    private int num2;
    private int correctAnswer;
    private String userAnswer;
    private Operation operation;
    private String questionString;
    private String result;

    static enum Operation {

        Add(), Subtract(), Multiply(), Divide();

        public String getOperationString(Operation operation) {
            switch (operation) {
                case Add:
                    return ("+");
                case Subtract:
                    return ("-");
                case Multiply:
                    return ("*");
                case Divide:
                    return ("/");
            }
            return null;
        }

        public Operation getOperation(int op) {
            switch (op) {
                case 1:
                    return Add;
                case 2:
                    return Subtract;
                case 3:
                    return Multiply;
                case 4:
                    return Divide;
                default:
                    return Add;
            }
        }
    }

    MathQuestion() {
        Random rnd = new Random();
        num1 = rnd.nextInt(100);
        do {
            num2 = rnd.nextInt(100);
        } while (num2 == 0);
        operation = Operation.Add.getOperation(rnd.nextInt(4));
        correctAnswer = evaluate(num1, num2, operation);
        questionString = getNum1() + " " + operation.getOperationString(operation) + " " + getNum2();
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getQuestionString() {
        return this.questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private int evaluate(int num1, int num2, Operation operation) {

        switch (operation) {
            case Add:
                return (num1 + num2);
            case Subtract:
                return (num1 - num2);
            case Multiply:
                return (num1 * num2);
            case Divide:
                return (num1 / num2);
        }

        return 0;
    }
}
