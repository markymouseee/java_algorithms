/**
 * @author markymouseee
 **/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Row Size: ");
        int row_size = scanner.nextInt();
        
        StudentManagementSystem sms = new StudentManagementSystem(row_size);
        sms.addStudent(scanner, row_size);

        sms.displayAllStudent();
    }
}
