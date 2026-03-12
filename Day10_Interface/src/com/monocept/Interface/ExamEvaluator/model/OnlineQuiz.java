package com.monocept.Interface.ExamEvaluator.model;

public class OnlineQuiz implements Exam {

    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {

        if (marks >= 80)
            return "Pass";
        else
            return "Fail";
    }
}
