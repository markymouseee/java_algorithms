/**
 * @author markymouseee
 **/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            int rowSize = 0;

            while (true) {
                try {
                    System.out.print("Enter Row Size: ");
                    rowSize = scanner.nextInt();
                    if (rowSize <= 0) {
                        throw new IllegalArgumentException("Row size must be a positive integer.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer for row size.");
                    scanner.nextLine(); 
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            StudentManagementSystem sms = new StudentManagementSystem(rowSize);
            sms.addStudent(rowSize);

            sms.displayAllStudent();

            scanner.nextLine();
            System.out.print("Do you want to sort the list? (y) : (n) : ");
            String sortList = scanner.nextLine();

            if (sortList.equalsIgnoreCase("y") || sortList.equalsIgnoreCase("yes")) {
                int sortOption = 0;

                while (true) {
                    try {
                        System.out.println(
                            "1. Sort by Firstname\n" +
                            "2. Sort by GPA"
                        );
                        System.out.print("Enter number: ");
                        sortOption = scanner.nextInt();
                        if (sortOption != 1 && sortOption != 2) {
                            throw new IllegalArgumentException("Invalid option. Please enter 1 or 2.");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number (1 or 2).");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (sortOption == 1) {
                    sms.sort_students_by_name();
                    sms.displayAllStudent();
                } else if (sortOption == 2) {
                    sms.sort_students_by_gpa();
                    sms.displayAllStudent();
                }
            }

            find_student(scanner, sms);

           
            scanner.nextLine(); 
            System.out.print("Do you want to continue? (y) : (n) : ");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("n") || continueChoice.equalsIgnoreCase("no")) {
                continueProgram = false;
                System.out.println("Exiting the program. Goodbye!");
            }
        }

        scanner.close();
    }

    public static void find_student(Scanner scanner, StudentManagementSystem sms) {
        while (true) {
            System.out.print("Find Student? : (y) : (n) : ");
            String find = scanner.nextLine();
            System.out.println();

            if (find.equalsIgnoreCase("y") || find.equalsIgnoreCase("yes")) {
                try {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    sms.find_students_by_id(id);
                    System.out.println();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Student ID.");
                    scanner.nextLine();
                }
            } else if (find.equalsIgnoreCase("n") || find.equalsIgnoreCase("no")) {
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
}
