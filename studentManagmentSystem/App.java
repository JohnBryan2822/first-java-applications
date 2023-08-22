package studentManagmentSystem;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        System.out.print("Enter a number of new Students to enroll: ");
        Scanner sc = new Scanner(System.in);
        int numOfStudent = sc.nextInt();
        Student[] student = new Student[numOfStudent];

        // Create a number of new Students
        for(int i=0;i<numOfStudent;i++) {
            student[i] = new Student();
            student[i].enroll();
            student[i].payTuition();
        }

        for(int i=0;i<numOfStudent;i++) {
            System.out.println(student[i].toString());
        }
    }
}
