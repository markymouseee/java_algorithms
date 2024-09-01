/**
 * @author markymouseee
 **/

import java.util.Scanner;

public class StudentManagementSystem {

    public int row_size;
    public Student[] Students;

    public StudentManagementSystem(int row_size){
        this.Students = new Student[row_size];
    }

    public void addStudent(Scanner scanner, int row_size){
        int studentId;
        String studentFirstName;
        String studentLastName;
        int studentGradeLevel;
        double studentGPA;
        System.out.println();
        for(int i = 0; i < row_size; i++){
            System.out.print("Enter Student ID: (" + (i + 1) + "): ");
            studentId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Student First Name: (" + (i + 1) + "): ");
            studentFirstName = scanner.nextLine();
            System.out.print("Enter Student Last Name: (" + (i + 1) + "): ");
            studentLastName = scanner.nextLine();
            System.out.print("Enter Student Grade Level: (" + (i + 1) + "): ");
            studentGradeLevel = scanner.nextInt();
            System.out.print("Enter Student GPA: (" + (i + 1) + "): ");
            studentGPA = scanner.nextDouble();

            Students[i] = new Student(studentId, studentFirstName, studentLastName, studentGradeLevel, studentGPA);
            System.out.println();
            System.out.println("STUDENT ADDED TO RECORD LIST SUCCESSFULLY");
            System.out.println();
        }
    }

    public void displayAllStudent(){
        System.out.println(
            "---------------------------------------\n" +
            "\t    STUDENTS RECORD LIST\n" +
            "---------------------------------------"
        );
        for(int i = 0; i < this.Students.length; i++){
            System.out.println(Students[i]);
        }
    }
}
