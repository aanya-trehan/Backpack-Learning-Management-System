package AP.Assignment2;

public class submission {
    private student studentA;
    private assessment a;
    private boolean graded = false;
    private int MarksReceived;
    private String fileName;
    private String ans;
    private String prof;
    private instructor gradedBy;

    submission(assignmentAssessment a, String fileName,student s) {
        this.a = a;
        this.fileName = fileName;
        this.studentA=s;
    }

    submission(quizAssessment a, String ans,student s) {
        this.a = a;
        this.ans = ans;
        this.studentA=s;
    }

    public student getStudent(){
        return this.studentA;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = true;
    }

    public void setMarksReceived(int marks) {
        this.MarksReceived = marks;
    }

    public int getMarksReceived() {
        return this.MarksReceived;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getAns() {
        return this.ans;
    }

    public instructor getGradedBy() {
        return this.gradedBy;
    }

    public void setGradedBy(instructor currentInstructor) {
        this.gradedBy=currentInstructor;
    }
}
