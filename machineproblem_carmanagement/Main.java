package machineproblem_carmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CarManagementSystem cms;
    
    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice = inputuser("Enter your choice: ");
            choice(choice);
        }
    }

    private static int inputuser(String prompt){
        int input;
        while (true) {
            try {
                if(!prompt.isEmpty()){
                    System.out.println();
                    System.out.print(prompt);
                }

                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid input, please input a number only.");
                scanner.nextLine();
            }
        }
    }

    private static void choice(int choice){
        switch (choice) {
            case 1:
                int listOfCars = inputuser("Enter a number of cars to add: ");
                cms = new CarManagementSystem(listOfCars);
                cms.addCars(listOfCars);
                break;
            case 2:
                if(cms != null){
                    System.out.println();
                    System.out.print("Enter a car brand name: ");
                    String brandname = scanner.nextLine();
                    cms.startEngine(brandname);
                }else{
                    System.out.println();
                    System.out.println("No car found, please add a car first");
                    System.out.println();
                }
                break;
            case 3:
                if(cms != null){
                    System.out.println();
                    System.out.print("Enter a car brand name: ");
                    String brandname = scanner.nextLine();
                    cms.stopEngine(brandname);
                }else{
                    System.out.println();
                    System.out.println("No car found, please add a car first");
                    System.out.println();
                }
                break;
            case 4:
                if (cms != null) {
                    System.out.println();
                    cms.displayInfo();
                } else {
                    System.out.println();
                    System.out.println("No car found, please add a car first");
                }
                break;
            case 5:
                if(cms != null){
                    System.out.println();
                    cms.compareAge();
                }else{
                    System.out.println();
                    System.out.println("No car found, please add a car first");
                }
                break;
            case 6:
                System.out.println("BYE BYE BYE!");
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println();
                System.out.println("Please input a number between 1-5");
                System.out.println();
                break;
        }
    }

    private static void displayMenu(){
        System.out.println("----------------------------------------");
        System.out.println("\n\tCar Management System\n");
        System.out.println("----------------------------------------");
        System.out.println("\n1. Add car (brand, model, year, color)");
        System.out.println("2. Start engine");
        System.out.println("3. Stop Engine");
        System.out.println("4. Display Car Info");
        System.out.println("5. Compare Age of Cars");
        System.out.println("6. Exit");
    }
}
