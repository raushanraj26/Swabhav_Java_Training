package com.monocept.Interface.ExamEvaluator.model;

public class TheoryExam implements Exam {

    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {

        if (marks >= 90)
            return "Grade A";
        else if (marks >= 75)
            return "Grade B";
        else if (marks >= 50)
            return "Grade C";
        else
            return "Fail";
    }
}