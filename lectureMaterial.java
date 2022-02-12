package AP.Assignment2;

import java.util.ArrayList;

public interface lectureMaterial {

    String title = null;

    String UploadedBy=null;

    String getTitle();

    String getDate();

    String getUploadedBy();

    void setUploadedBy(String name);

    ArrayList<slides> slidesList = new ArrayList<>();

    ArrayList<video> VideoList = new ArrayList<>();

    ArrayList<lectureMaterial> lectureMaterialList = new ArrayList<>();
}
// INTERFACE 2- MATERIAL
