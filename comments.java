package AP.Assignment2;

import java.util.ArrayList;
import java.util.Date;

public class comments {
    private final String comment;
    private static ArrayList<comments> commentList = new ArrayList<>();
    private String CommentBy;
    private String date;

    public comments(String comment) {
        this.comment = comment;
        Date d=new Date();
        this.date=d.toString();
    }

    public void AddToList(comments c) {
        commentList.add(c);
    }

    public String getCommentTime() {
        return this.date;
    }

    public void setCommentBy(String user) {
        this.CommentBy = user;
    }

    public String getCommentBy() {
        return this.CommentBy;
    }

    public static void DisplayComments() {
        for (AP.Assignment2.comments comments : commentList) {
            System.out.println(comments.getComment() + " - " + comments.getCommentBy());
            System.out.println(comments.getCommentTime());
            System.out.println();
        }
    }

    private String getComment() {
        return this.comment;
    }

}
