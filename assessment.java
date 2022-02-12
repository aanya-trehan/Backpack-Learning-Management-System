package AP.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public interface assessment {

    ArrayList<assignmentAssessment> assignmentList = new ArrayList<>();

    ArrayList<quizAssessment> quizList = new ArrayList<>();

    ArrayList<assignmentAssessment> openAssignments=new ArrayList<>();

    ArrayList<quizAssessment> openQuiz=new ArrayList<>();

    boolean isClosed();

    void UpdateOpenAssessments();

    void CloseAssessment();

     static void gradeAssesments(instructor currentInstructor) {
        System.out.println("List of assessments");
        Scanner scan = new Scanner(System.in);

        if (assignmentList.size() == 0 || quizList.size() == 0) {
            System.out.println("No assessments");
            return;
        }
        int indexAssign;
        for (indexAssign = 0; indexAssign < assignmentList.size(); indexAssign++) {
            System.out.println("ID: " + indexAssign +" Assignment: "+ assignmentList.get(indexAssign).getProblemStatement() + " Max Marks: " + assignmentList.get(indexAssign).getMaxMarks());
            System.out.println("-----------------------");
        }
        indexAssign = assignmentList.size();
        for (int indexQuiz = 0; indexQuiz < quizList.size(); indexQuiz++) {
            System.out.println("ID: " + (indexQuiz + indexAssign) + " Question: " + quizList.get(indexQuiz).getQ());
            System.out.println("-----------------------");
        }

        System.out.print("Enter ID of assessment to view submissions:");
        int id = scan.nextInt();

        if (id < indexAssign) {
            assignmentAssessment a = assignmentList.get(id);
            a.getSubmissions(currentInstructor);

        } else {
            quizAssessment q = quizList.get(id - indexAssign);
            q.getSubmissions(currentInstructor);

        }
    }

     static void openedAssessments(){
        System.out.println("List of open Assignments:");
        if (openAssignments.size()==0 && openQuiz.size()==0){
            System.out.println("No open assignments");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int indexAssign;
        for (indexAssign = 0; indexAssign < openAssignments.size(); indexAssign++) {
            System.out.println("ID: " + indexAssign + " Assignment: "+openAssignments.get(indexAssign).getProblemStatement() + " Max Marks: " + openAssignments.get(indexAssign).getMaxMarks());
            System.out.println("-----------------------");
        }
        indexAssign = openAssignments.size();
        for (int indexQuiz = 0; indexQuiz < openQuiz.size(); indexQuiz++) {
            System.out.println("ID: " + (indexQuiz + indexAssign) + " Question: " + openQuiz.get(indexQuiz).getQ());
            System.out.println("-----------------------");
        }

        System.out.print("Enter ID of assignment to close:");
        int id = scan.nextInt();

        if (id < indexAssign) {
            assignmentAssessment a = openAssignments.get(id);
            a.CloseAssessment();
        }
        else {
            quizAssessment q = openQuiz.get(id - indexAssign);
            q.CloseAssessment();


        }




    }
}


