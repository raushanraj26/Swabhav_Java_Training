package com.monocept.Interface.ExamEvaluator.model;

public class PracticalExam implements Exam {

    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {

        if (marks >= 85)
            return "Grade A";
        else if (marks >= 70)
            return "Grade B";
        else if (marks >= 60)
            return "Grade C";
        else
            return "Fail";
    }
}