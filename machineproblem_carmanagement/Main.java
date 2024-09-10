package machineproblem_carmanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static Car car;
    private static Scanner scanner = new Scanner(System.in);
    private static CarManagementSystem cms;
    
    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println();
                inputuser(scanner);
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid input, please input a number");
                scanner.nextLine();
            }
        }
    }

    private static void inputuser(Scanner scanner){
        displayMenu();
        System.out.println();
        System.out.print("Enter Number: ");
        int choice = scanner.nextInt();
        choice(choice, scanner);
    }

    private static void choice(int choice, Scanner scanner){
        switch (choice) {
            case 1:
                System.out.print("Enter a number of cars to add: ");
                int add = scanner.nextInt();
                cms = new CarManagementSystem(add);
                cms.addCars(add);
                System.out.println();
                break;
            case 2:
                if(cms != null){
                    System.out.println();
                    car.startEngine();
                }else{
                    System.out.println();
                    System.out.println("Add a car first");
                }
                break;
            case 3:
                System.out.println();
                car.stopEngine();
                break;
            case 4:
                if (cms != null) {
                    System.out.println();
                    cms.displayInfo();
                } else {
                    System.out.println();
                    System.out.println("Add a car first");
                }
                break;
            case 5:
                System.out.println("BYE BYE BYE!");
                System.exit(0);
                scanner.close();
            default:
                System.out.println();
                System.out.println("Please input a number between 1-5");
                inputuser(scanner);
                break;
        }
    }

    private static void displayMenu(){
        System.out.println("1. Add car (brand, model, year, color)");
        System.out.println("2. Start engine");
        System.out.println("3. Stop engine");
        System.out.println("4. Display car info");
        System.out.println("5. Exit");
    }
}
