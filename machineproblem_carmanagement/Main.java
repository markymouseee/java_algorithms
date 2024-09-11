/**
 * @author markymouseee
 **/

package machineproblem_carmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    private static Scanner scanner = new Scanner(System.in);
    private static CarManagementSystem cms;
    
    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice = inputuser(GREEN + "Enter your choice: " + RESET);
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
                System.out.println(RED + "Invalid input, please input a number only." + RESET);
                scanner.nextLine();
            }
        }
    }

    private static void choice(int choice){
        switch (choice) {
            case 1:
                int listOfCars = inputuser(GREEN + "Enter a number of cars to add: " + RESET);
                cms = new CarManagementSystem(listOfCars);
                cms.addCars(listOfCars);
                break;
            case 2:
                if(cms != null){
                    System.out.println();
                    System.out.print(GREEN + "Enter a car brand name: " + RESET);
                    String brandname = scanner.nextLine();
                    cms.startEngine(brandname);
                }else{
                    System.out.println();
                    System.out.println(RED + "No car found, please add a car first" + RESET);
                    System.out.println();
                }
                break;
            case 3:
                if(cms != null){
                    System.out.println();
                    System.out.print(GREEN + "Enter a car brand name: " + RESET);
                    String brandname = scanner.nextLine();
                    cms.stopEngine(brandname);
                }else{
                    System.out.println();
                    System.out.println(RED + "No car found, please add a car first" + RESET);
                    System.out.println();
                }
                break;
            case 4:
                if (cms != null) {
                    System.out.println();
                    cms.displayInfo();
                } else {
                    System.out.println();
                    System.out.println(RED + "No car found, please add a car first" + RESET);
                    System.out.println();
                }
                break;
            case 5:
                if(cms != null){
                    System.out.println();
                    cms.compareAge();
                }else{
                    System.out.println();
                    System.out.println(RED + "No car found, please add a car first" + RESET);
                    System.out.println();
                }
                break;
            case 6:
                System.out.println("BYE BYE BYE!");
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println();
                System.out.println(RED + "Please enter a number between [1-6]" + RESET);
                System.out.println();
                break;
        }
    }

    private static void displayMenu(){
        System.out.println(RED + "========================================" + RESET);
        System.out.println(YELLOW + "\n\tCar Management System\n" + RESET);
        System.out.println(RED + "========================================" + RESET);
        System.out.println("\n1. Add car (brand, model, year, color)");
        System.out.println("2. Start engine");
        System.out.println("3. Stop Engine");
        System.out.println("4. Display Car Info");
        System.out.println("5. Compare Age of Cars");
        System.out.println("6. Exit");
    }
}
