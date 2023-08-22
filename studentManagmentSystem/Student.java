package studentManagmentSystem;

import java.util.Scanner;
public class Student {
    private String firstName;
    private String lastName;
    private int grandeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = sc.nextLine();

        System.out.print("Enter student's last name: ");
        this.lastName = sc.nextLine();

        System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter a studenet class level: ");
        this.grandeYear = sc.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + grandeYear + " " + studentID);
    }

    // Generate an ID
    private void setStudentID() {
        id++;
        this.studentID = grandeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        // Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equals("Q")) {
                courses = courses + "\n    " + course;
                tuitionBalance += costOfCourse;
            }
            else {
                System.out.println("BREAK!");
                break;
            }
        } while (1 != 0);

        System.out.println("ENROLLED IN: " + courses);
        System.out.println("TUITION BALANCE: " + tuitionBalance);
    }

    // View Balance
    public void viewBalance() {
        System.out.println("Your balance: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your payment: ");
        int payment = sc.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for payment of $" + payment);
        viewBalance();
    }

    // Show status
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + grandeYear +
                "\nStudent ID: " + studentID +
                "\nCourse Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
