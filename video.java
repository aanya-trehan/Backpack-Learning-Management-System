package AP.Assignment2;

import java.util.ArrayList;
import java.util.Date;

class video implements lectureMaterial{
    private String title = null;
    private String UploadedBy=null;
    private String FileName;
    private String date;

    public video(String title){
        this.title=title;
        Date d=new Date();
        this.date=d.toString();

    }

    public static ArrayList<video> getVideoList() {
        return VideoList;
    }

    public void addVideo(video v) {
        VideoList.add(v);
    }

    public String getTitle(){
        return this.title;
    }
    public String getDate(){
        return this.date;
    }

    public void setUploadedBy(String name){
        this.UploadedBy=name;
    }

    public static void printList() {
        for (int i = 0; i < VideoList.size(); i++) {
            System.out.println("Title:"+VideoList.get(i).getTitle());
            System.out.println("Video File:"+VideoList.get(i).getFileName());
            System.out.println("Date of upload:"+VideoList.get(i).getDate());
            System.out.println("Uploaded by:"+VideoList.get(i).getUploadedBy());
            System.out.println();
            System.out.println();
        }
    }

    public String getUploadedBy(){
        return this.UploadedBy;
    }

    public void setFileName(String FileName) {
        this.FileName=FileName;
    }

    public String getFileName() {
        return FileName;
    }
}