package AP.Assignment2;


import java.util.*;

public class Backpack {


    public static void menu() {

        instructor.DemoInstructors();
        student.DemoStudents();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");

            int option = scan.nextInt();
            if (option == 1) {
                instructorOption();
            } else if (option == 2) {
                studentOption();
            } else if (option == 3) {
                return;
            } else {
                System.out.println("Error: Invalid Option");
            }
        }


    }

    public static void instructorOption() {

        instructor currentInstructor= instructor.Login();
        String name = currentInstructor.getName();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welcome " + name);
            System.out.println("INSTRUCTOR MENU");
            System.out.println("1. Add class material");
            System.out.println("2. Add assessments");
            System.out.println("3. View lecture materials");
            System.out.println("4. View assessments");
            System.out.println("5. Grade assessments");
            System.out.println("6. Close assessments");
            System.out.println("7. View comments");
            System.out.println("8. Add comments");
            System.out.println("9. Logout");

            int option = scan.nextInt();
//"1. Add class material"
            if (option == 1) {
                System.out.println("1. Add Lecture slide ");
                System.out.println("2. Add Lecture video ");
                int option2 = scan.nextInt();
                scan.nextLine();

                if (option2 == 1) {
                    System.out.print("Enter topic of slides:");
                    String title = scan.nextLine();
                    slides newSlide = new slides(title);
                    newSlide.addSlide(newSlide);
                    System.out.print("Enter number of slides:");
                    int number = scan.nextInt();
                    //scan.nextLine();
                    newSlide.setNumberOfSlides(number);
                    newSlide.setContent(number);
                    newSlide.setUploadedBy(name);

                } else if (option2 == 2) {
                    System.out.print("Enter topic of video:");
                    String title = scan.nextLine();
                    video newVideo = new video(title);
                    System.out.print("Enter filename of Video:");
                    String vidName = scan.next();
                    String[] checkName = vidName.split("[.]", 0);
                    if (checkName[1].equals("mp4")) {
                        newVideo.setFileName(vidName);
                        newVideo.addVideo(newVideo);
                        newVideo.setUploadedBy(name);
                       // video.printList();
                    } else {
                        System.out.println("Invalid file format");
                    }
                } else {
                    System.out.println("Invalid");
                }

            }
//2. Add assessments
            else if (option == 2) {
                System.out.println("1. Add Assignment ");
                System.out.println("2. Add Quiz ");
                int option2 = scan.nextInt();
                scan.nextLine();

                if (option2 == 1) {
                    System.out.print("Enter Problem Statement:");
                    String probStatement=scan.nextLine();
                    System.out.print("Enter Max marks:");
                    int maxMarks=scan.nextInt();
                    assignmentAssessment newAssignment= new assignmentAssessment(probStatement,maxMarks);
                    newAssignment.addToList(newAssignment);


                }
                else if(option2==2){
                    System.out.print("Enter quiz question:");
                    String q=scan.nextLine();
                    quizAssessment newQuiz= new quizAssessment(q);
                    newQuiz.addToList(newQuiz);

                }
                else{
                    System.out.println("Invalid");
                }

//"3. View lecture materials"
            } else if (option == 3) {

                slides.printList();
                video.printList();

//4. View assessments
            } else if (option == 4) {
                assignmentAssessment.printList();
                quizAssessment.printList();

//5. Grade assessments
            } else if (option == 5) {
                assessment.gradeAssesments(currentInstructor);


            } else if (option == 6) {
                assessment.openedAssessments();

//7. View comments
            } else if (option == 7) {
                comments.DisplayComments();

//8. Add comments
            } else if (option == 8) {
                scan.nextLine();
                System.out.print("Enter comment:");
                String comment=scan.nextLine();
                comments newComment= new comments(comment);
                newComment.setCommentBy(name);
                newComment.AddToList(newComment);

            } else if (option == 9) {
                return;
            } else {
                System.out.println("Invalid option: Enter again");
            }

        }

    }

    public static void studentOption() {

        student currentStudent=student.Login();
        String name=currentStudent.getName();
        Scanner scan= new Scanner(System.in);

        while (true) {

            System.out.println("----------------------------------------------");
            System.out.println("Welcome "+name);
            System.out.println("STUDENT MENU");
            System.out.println("1. View lecture materials");
            System.out.println("2. View assessments");
            System.out.println("3. Submit assessments");
            System.out.println("4. View Grades");
            System.out.println("5. View comments");
            System.out.println("6. Add comments");
            System.out.println("7. Logout");

            int option = scan.nextInt();

            if (option == 1) {
                slides.printList();
                video.printList();

            } else if (option == 2) {
                assignmentAssessment.printList();
                quizAssessment.printList();

//3. Submit assessments
            } else if (option == 3) {
                currentStudent.pendingSubmissions(currentStudent);

//4. View Grades
            } else if (option == 4) {
                currentStudent.GradedSubmissions();


            } else if (option == 5) {
                comments.DisplayComments();

            } else if (option == 6) {
                scan.nextLine();
                System.out.print("Enter comment:");
                String comment=scan.nextLine();
                comments newComment= new comments(comment);
                newComment.setCommentBy(name);
                newComment.AddToList(newComment);

            } else if (option == 7) {
                return;
            } else {
                System.out.println("Invalid option: Enter again");
            }


        }

    }

}
