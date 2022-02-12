package AP.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class quizAssessment implements assessment{
    private String Q;
    private final int maxMarks=1;
    private int marksReceived;
    private boolean graded=false;
    private static ArrayList<submission> ungradedSubmissions= new ArrayList<>();
    private static ArrayList<submission> gradedSubmissions= new ArrayList<>();
    private boolean closed=false;

    public quizAssessment(String Q){
        this.Q=Q;

    }

    public static void printList() {
        int id=assignmentList.size();
        for(int i=0;i<quizList.size();i++){
            System.out.println("ID:"+(id+i)+" Question: "+quizList.get(i).getQ());
            System.out.println("------------------");
        }

    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public String getQ() {
        return this.Q;
    }

    public void addToList(quizAssessment quiz){
        quizList.add(quiz);
        openQuiz.add(quiz);
    }

    public void AddSubmissions(submission s){
        ungradedSubmissions.add(s);
    }

    public void getSubmissions(instructor currentInstructor) {
        Scanner scan=new Scanner(System.in);
        UpdateSubmissionGraded();
        if (ungradedSubmissions.size()==0){
            System.out.println("No submissions available");
            return;
        }
        System.out.println("Choose  ID from these ungraded submissions");
        for (int i=0;i<ungradedSubmissions.size();i++){
            System.out.println(i+". "+ungradedSubmissions.get(i).getStudent().getName());
        }
        int choice=scan.nextInt();
        submission chosen=ungradedSubmissions.get(choice);
        System.out.println("Submission:");
        System.out.println("Submission:"+chosen.getAns());
        System.out.println("Max Marks:"+ this.getMaxMarks());
        System.out.print("Marks scored:");
        int score=scan.nextInt();
        chosen.setGraded(true);
        chosen.setMarksReceived(score);
        chosen.setGradedBy(currentInstructor);
    }

    public void UpdateSubmissionGraded(){
        for (int i=0;i<ungradedSubmissions.size();i++){
            if (ungradedSubmissions.get(i).isGraded()){
                gradedSubmissions.add(ungradedSubmissions.get(i));
                ungradedSubmissions.remove(i);
            }
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public void UpdateOpenAssessments() {
        for (int i=0;i<openQuiz.size();i++){
            if(openQuiz.get(i).isClosed()){
                openQuiz.remove(i);
            }
        }
    }

    public void CloseAssessment(){
        this.closed=true;
        UpdateOpenAssessments();
    }

}
