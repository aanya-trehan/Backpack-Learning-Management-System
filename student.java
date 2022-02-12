package AP.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class student implements user {
    private final String name;
    private ArrayList<submission> studentSubmissions = new ArrayList<>();
    private ArrayList<assignmentAssessment> pendingAssign = new ArrayList<>();
    private ArrayList<quizAssessment> pendingquiz = new ArrayList<>();
    private ArrayList<assignmentAssessment> doneAssign = new ArrayList<>();
    private ArrayList<quizAssessment> doneQuiz = new ArrayList<>();

    public student(String name) {
        this.name = name;
    }

    public static void DemoStudents() {
        student S0 = new student("S0");
        studentList.add(S0);
        student S1 = new student("S1");
        studentList.add(S1);
        student S2 = new student("S2");
        studentList.add(S2);
    }

    public void Display() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i + " - " + studentList.get(i).getName());
        }
    }

    public static student Login() {
        System.out.println("Students:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i + " - " + studentList.get(i).getName());
        }
        System.out.print("Choose id: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        student currentStudent = studentList.get(id);
        return currentStudent;
    }

    public String getName() {
        return this.name;
    }

    public void addToList(user i) {
        studentList.add((student) i);
    }

    public void addSubmissions(submission sub) {
        this.studentSubmissions.add(sub);
    }

    public void pendingSubmissions(student studenta) {
        updatePending();
        Scanner scan = new Scanner(System.in);
        System.out.println("Pending Assessments");
        if (this.pendingquiz.size()==0 && this.pendingAssign.size()==0){
            System.out.println("No pending assessments");
            return;
        }
        int indexAssign;
        for (indexAssign = 0; indexAssign < this.pendingAssign.size(); indexAssign++) {
            System.out.println("ID: " + indexAssign +" Assignment:"+ pendingAssign.get(indexAssign).getProblemStatement() + " Max Marks: " + pendingAssign.get(indexAssign).getMaxMarks());
//            System.out.println("-----------------------");
        }
        indexAssign = pendingAssign.size();
        for (int indexQuiz = 0; indexQuiz < this.pendingquiz.size(); indexQuiz++) {
            System.out.println("ID: " + (indexQuiz + indexAssign) + " Question: " + this.pendingquiz.get(indexQuiz).getQ());
//            System.out.println("-----------------------");
        }

        System.out.print("Enter ID of assessment:");
        int id = scan.nextInt();
        if (id < indexAssign) {
            assignmentAssessment a = pendingAssign.get(id);
            System.out.print("Enter filename of assessment:");
            String filename = scan.next();
            String[] checkName = filename.split("[.]", 0);
            if (checkName[1].equals("zip")) {
                submission sub = new submission(a, filename,studenta);
                this.addSubmissions(sub);
                this.doneAssign.add(a);
                this.pendingAssign.remove(id);
                a.AddSubmissions(sub);

            }
            else{
                System.out.println("Invalid file type");
            }
        }
        else {
            quizAssessment q = pendingquiz.get(id - indexAssign);
            System.out.print(q.getQ()+" ");
            String ans = scan.next();
            submission sub = new submission(q, ans,studenta);
            this.addSubmissions(sub);
            this.doneQuiz.add(q);
            this.pendingquiz.remove(id - indexAssign);
            q.AddSubmissions(sub);
            }

    }


    public void updatePending() {
        for (int i = 0; i < assignmentAssessment.assignmentList.size(); i++) {
            if (!(this.doneAssign.contains(assignmentAssessment.assignmentList.get(i)))) {
                if (!(this.pendingAssign.contains(assignmentAssessment.assignmentList.get(i))) && !assignmentAssessment.assignmentList.get(i).isClosed()) {
                    this.pendingAssign.add(assignmentAssessment.assignmentList.get(i));
                }
            }
        }
        for (int i = 0; i < quizAssessment.quizList.size(); i++) {
            if (!(this.doneQuiz.contains(quizAssessment.quizList.get(i)))) {
                if (!(this.pendingquiz.contains(quizAssessment.quizList.get(i))) && !assignmentAssessment.assignmentList.get(i).isClosed()) {
                    this.pendingquiz.add(quizAssessment.quizList.get(i));
                }
            }
        }
        for (int i=0;i<pendingAssign.size();i++){
            if (pendingAssign.get(i).isClosed()){
                pendingAssign.remove(i);
            }
        }
        for (int i=0;i<pendingquiz.size();i++){
            if (pendingquiz.get(i).isClosed()){
                pendingquiz.remove(i);
            }
        }
    }

    public void GradedSubmissions() {
        System.out.println("Graded Submissions");
        for (int i=0;i<studentSubmissions.size();i++){
            if(studentSubmissions.get(i).isGraded()){
                if(studentSubmissions.get(i).getFileName()!=null) {
                    System.out.println("Submission:" + studentSubmissions.get(i).getFileName());
                    System.out.println("Marks Scored:" + studentSubmissions.get(i).getMarksReceived());
                    System.out.println("Graded by:" + studentSubmissions.get(i).getGradedBy().getName());
                }
                else{
                    System.out.println("Submission:" + studentSubmissions.get(i).getAns());
                    System.out.println("Marks Scored:" + studentSubmissions.get(i).getMarksReceived());
                    System.out.println("Graded by:" + studentSubmissions.get(i).getGradedBy().getName());
                }
            }
        }
        System.out.println("-----------------------");
        System.out.println("Ungraded Submissions");
        for (int i=0;i<studentSubmissions.size();i++){
            if(!studentSubmissions.get(i).isGraded()){
                if (studentSubmissions.get(i).getFileName()!=null) {
                    System.out.println("Submission:" + studentSubmissions.get(i).getFileName());
                }
                else{
                    System.out.println("Submission:" + studentSubmissions.get(i).getAns());
                }
            }
        }
    }
}

