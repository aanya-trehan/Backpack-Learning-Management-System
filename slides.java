package AP.Assignment2;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class slides implements lectureMaterial{
    private String title = null;
    private String UploadedBy=null;
    private int numberOfSlides;
    private ArrayList<String> slideContent=new ArrayList<>();
    private String date;

    public slides(String title) {
        this.title=title;
        Date d=new Date();
        this.date=d.toString();
    }

    public String getDate(){
        return this.date;

    }

    public void setContent(int numberOfSlides) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter content of slides");
        for (int i=0;i<numberOfSlides;i++){
            System.out.print("Content of slide "+(i+1)+":");
            String SlideC=scan.nextLine();
            this.slideContent.add(SlideC);
        }
    }

    public static void printList(){
        for (int i=0;i<slidesList.size();i++) {
            System.out.println("Title:" + slidesList.get(i).getTitle());
            for (int j = 0; j < slidesList.get(i).slideContent.size(); j++) {
                System.out.println("Slide " + (j + 1) + ":" + slidesList.get(i).slideContent.get(j));
            }
            System.out.println("Number of slides:" + slidesList.get(i).getNumberOfSlides());
            System.out.println("Date of upload:" + slidesList.get(i).getDate());
            System.out.println("Uploaded by:" + slidesList.get(i).getUploadedBy());
        }
        System.out.println();
    }

    public void setNumberOfSlides(int number){
        this.numberOfSlides=number;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }

    public String getUploadedBy() {
        return UploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        UploadedBy = uploadedBy;
    }


    public String getTitle() {
        return title;
    }

    public void addSlide(slides newSlide) {
        slidesList.add(newSlide);
    }
}

