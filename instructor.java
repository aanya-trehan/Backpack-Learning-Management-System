package AP.Assignment2;

import java.util.Scanner;

class instructor implements user{
    private final String name;

    public instructor(String name){
        this.name=name;
    }

    public static void DemoInstructors(){
        instructor l0 = new instructor("l0");
        instructorsList.add(l0);
        instructor l1 = new instructor("l1");
        instructorsList.add(l1);
    }

    public static instructor Login() {
        for (int i = 0; i < instructorsList.size(); i++) {
            System.out.println(i + " - " + instructorsList.get(i).getName());
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose id: ");
        int id = scan.nextInt();

        return instructorsList.get(id);
    }

    public String getName(){
        return this.name;
    }

    public void addToList(user i) {
        instructorsList.add((instructor) i);
    }

    public void Display() {
        for (int i = 0; i < instructorsList.size(); i++) {
            System.out.println(i + " - " + instructorsList.get(i).getName());
        }
    }

}
