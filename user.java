package AP.Assignment2;

import java.util.ArrayList;

public interface user {

    ArrayList<instructor> instructorsList = new ArrayList<>();

    ArrayList<student> studentList = new ArrayList<>();

    String name = null;

    String getName();

    void addToList(user i);

    void Display();

}
