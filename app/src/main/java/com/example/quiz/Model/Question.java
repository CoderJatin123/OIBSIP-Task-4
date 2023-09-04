package com.example.quiz.Model;

public class Question {
    public Question(String question, String answer, String op1, String op2, String op3, String op4) {
        this.question = question;
        this.answer = answer;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    String question,answer;
    String op1,op2,op3,op4;
}
