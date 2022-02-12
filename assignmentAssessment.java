package AP.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class assignmentAssessment implements assessment{
    private String problemStatement;
    private int maxMarks;
    private int marksReceived;
    private boolean graded=false;
    private static ArrayList<submission> ungradedSubmissions= new ArrayList<>();
    private static ArrayList<submission> gradedSubmissions= new ArrayList<>();
    private boolean closed;


    public assignmentAssessment(String probStatement, int maxMarks) {
        this.maxMarks=maxMarks;
        this.problemStatement=probStatement;
    }

    public static void printList() {
        for(int i=0;i<assignmentList.size();i++){
            System.out.println("ID:"+i+" Assignment: "+assignmentList.get(i).getProblemStatement()+" Max Marks:"+assignmentList.get(i).maxMarks);
            System.out.println("------------------");
        }

    }

    public void AddSubmissions(submission s){
        ungradedSubmissions.add(s);
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks){
        this.maxMarks=maxMarks;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void addToList(assignmentAssessment assignment){
        assignmentList.add(assignment);
        openAssignments.add(assignment);
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
        System.out.println("Submission:"+chosen.getFileName());
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

    public void CloseAssessment(){
        this.closed=true;
        UpdateOpenAssessments();
    }

    @Override
    public void UpdateOpenAssessments() {
        for (int i=0;i<openAssignments.size();i++){
            if(openAssignments.get(i).isClosed()){
                openAssignments.remove(i);
            }
        }
    }
}