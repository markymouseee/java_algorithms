/**
 * @author markymouseee
 **/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem sms;

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management System!");

        while (true) {
            displayMainMenu();
            int choice = getValidIntegerInput("Enter your choice: ");
            handleMenuChoice(choice);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Sort Students");
        System.out.println("4. Find Student by ID");
        System.out.println("5. Exit");
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println();
                System.out.print("Enter number of Students to add: ");
                int rowSize = getValidIntegerInput("");
                sms = new StudentManagementSystem(rowSize);
                sms.addStudent(rowSize);
                break;
            case 2:
                if (sms != null) {
                    sms.displayAllStudent();
                } else {
                    System.out.println("No students available. Please add students first.");
                }
                break;
            case 3:
                if (sms != null) {
                    displaySortMenu();
                } else {
                    System.out.println("No students available to sort. Please add students first.");
                }
                break;
            case 4:
                if (sms != null) {
                    findStudentById();
                } else {
                    System.out.println("No students available. Please add students first.");
                }
                break;
            case 5:
                System.out.println("Exiting the program. Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                break;
        }
    }

    private static void displaySortMenu() {
        System.out.println(
            "1. Sort by Firstname\n" +
            "2. Sort by GPA"
        );
        int sortChoice = getValidIntegerInput("Enter number: ");
        if (sortChoice == 1) {
            sms.sort_students_by_name();
            sms.displayAllStudent();
        } else if (sortChoice == 2) {
            sms.sort_students_by_gpa();
            sms.displayAllStudent();
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static void findStudentById() {
        int id = getValidIntegerInput("Enter Student ID to find: ");
        sms.find_students_by_id(id);
    }

    private static int getValidIntegerInput(String prompt) {
        int input;
        while (true) {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }
}
