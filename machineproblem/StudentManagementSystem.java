/**
 * @author markymouseee
 **/
import java.util.Scanner;
import java.util.InputMismatchException;
public class StudentManagementSystem {
    private Scanner scanner = new Scanner(System.in);
    public int row_size;
    public Student[] Students;

    public StudentManagementSystem(int row_size){
        this.Students = new Student[row_size];
    }

    public void addStudent(int row_size) {
        int studentId;
        String studentFirstName;
        String studentLastName;
        int studentGradeLevel;
        double studentGPA;
        System.out.println();
    
        for (int i = 0; i < row_size; i++) {
            while (true) {
                try {
                    System.out.print("Enter Student ID: (" + (i + 1) + "): ");
                    studentId = scanner.nextInt();
                    if (studentId <= 0) {
                        throw new IllegalArgumentException("Student ID must be a positive integer.");
                    }
                    if (isStudentIdExists(studentId)) {
                        throw new IllegalArgumentException("Student ID already exists. Please enter a unique Student ID.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer for Student ID.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
    
            scanner.nextLine();
    
            while (true) {
                System.out.print("Enter Student First Name: (" + (i + 1) + "): ");
                studentFirstName = scanner.nextLine();
                if (!studentFirstName.trim().isEmpty() && studentFirstName.matches("[a-zA-Z]+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid first name containing only letters.");
                }
            }
    
            while (true) {
                System.out.print("Enter Student Last Name: (" + (i + 1) + "): ");
                studentLastName = scanner.nextLine();
                if (!studentLastName.trim().isEmpty() && studentLastName.matches("[a-zA-Z]+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid last name containing only letters.");
                }
            }
    
            while (true) {
                try {
                    System.out.print("Enter Student Grade Level: (" + (i + 1) + "): ");
                    studentGradeLevel = scanner.nextInt();
                    if (studentGradeLevel <= 0 || studentGradeLevel > 12) {
                        throw new IllegalArgumentException("Grade level must be between 1 and 12.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Grade Level.");
                    scanner.nextLine();
                    System.out.println(e.getMessage());
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
    
            while (true) {
                try {
                    System.out.print("Enter Student GPA: (" + (i + 1) + "): ");
                    studentGPA = scanner.nextDouble();
                    if (studentGPA < 0.0 || studentGPA > 4.0) {
                        throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number for GPA.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
    
            Students[i] = new Student(studentId, studentFirstName, studentLastName, studentGradeLevel, studentGPA);
            System.out.println();
            System.out.println("STUDENT ADDED SUCCESSFULLY");
            System.out.println();
        }
    }

    private boolean isStudentIdExists(int studentId) {
        for (Student student : Students) {
            if (student != null && student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public void displayAllStudent(){
        System.out.println(
            "---------------------------------------\n" +
            "\t    LIST OF STUDENTS\n" +
            "---------------------------------------"
        );
        for(int i = 0; i < this.Students.length; i++){
            System.out.println(Students[i]);
        }
    }

    public void removeStudent(int id) {
        // Check if the Students array is empty
        if (Students.length == 0) {
            System.out.println("No students available. Please add students first.");
            return;
        }
    
        int index_to_remove = -1;
        
        // Search for the student with the given ID
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getStudentId() == id) {
                index_to_remove = i;
                break;
            }
        }
    
        // Check if the student was found
        if (index_to_remove == -1) {
            System.out.println("Student with ID " + id + " does not exist.");
            return;
        }
    
        // Handle the case where the array will become empty
        if (Students.length == 1) {
            Students = new Student[0];
            System.out.println("Student removed and array is now empty.");
            return;
        }
    
        // Create a new array with one less element
        Student[] newArray = new Student[Students.length - 1];
    
        // Copy elements except the one to be removed
        for (int i = 0, j = 0; i < Students.length; i++) {
            if (i != index_to_remove) {
                newArray[j++] = Students[i];
            }
        }
    
        // Replace the old array with the new one
        Students = newArray;
    
        System.out.println("Student removal done.");
    }
    

    public void sort_students_by_name(){
        //Bubble sort (Acending)
       
        Student holder;
        for(int i = 0; i < Students.length - 1; i++){
            for(int j = 0; j < Students.length - i - 1; j++){
                if(Students[j].getFirstName().compareTo(Students[j + 1].getFirstName()) > 0){
                    holder = Students[j];
                    Students[j] = Students[j + 1];
                    Students[j + 1] = holder;
                }
            }
        }
        System.out.println();
        System.out.println("SORTED LIST BY FIRSTNAME");
        System.out.println();
    }

    public void sort_students_by_gpa(){
        //Bubble sort (Acending)
        Student holder;
        for(int i = 0; i < Students.length - 1; i++){
            for(int j = 0; j < Students.length - i - 1; j++){
                if(Students[j].getGpa() > Students[j + 1].getGpa()){
                    holder = Students[j];
                    Students[j] = Students[j + 1];
                    Students[j + 1] = holder;
                }
            }
        }
        System.out.println();
        System.out.println("SORTED LIST BY GPA");
        System.out.println();
    }

    public void find_students_by_id(int id){
        //Bubble sort (Acending)
        Student holder;
        for(int i = 0; i < Students.length - 1; i++){
            for(int j = 0; j < Students.length - i - 1; j++){
                if(Students[j].getStudentId() > Students[j + 1].getStudentId()){
                    holder = Students[j];
                    Students[j] = Students[j + 1];
                    Students[j + 1] = holder;
                }
            }
        }
    
        

        //binary search algorithm
        int start_index = 0;
        int end_index = Students.length - 1;
        int middle_index = (start_index + end_index) / 2;

        while(start_index <= end_index){
            middle_index = (start_index + end_index) / 2;
            if(id == Students[middle_index].getStudentId()){
                System.out.println();
                System.out.println("Student Found: \n" + Students[middle_index]);
                return;
            }else if(id < Students[middle_index].getStudentId()){
                end_index = middle_index - 1;
            }else{
                start_index = middle_index + 1;
            }
        }
        System.out.println();
        System.out.println("Student ID not found");
    }
}
