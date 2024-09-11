package machineproblem_carmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarManagementSystem {
    private final Car[] Cars;
    private static final Scanner scanner = new Scanner(System.in);

    private static final String CYAN = "\u001B[35m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    public CarManagementSystem(int row_size){
        this.Cars = new Car[row_size];
    }

    public void addCars(int row_size){
        String brand;
        String model;
        int year;
        String color;
        System.out.println();

        for(int i = 0; i < row_size; i++){
            System.out.print("Enter a car brand: ");
            brand =  scanner.nextLine();
              
            System.out.print("Enter a car model: ");
            model = scanner.nextLine();

       
           while(true){
                try {
                    System.out.print("Enter a car year : ");
                    year = scanner.nextInt();

                    if(year <= 0){
                        throw new IllegalArgumentException(RED + "Invalid year, please enter a positive number" + RESET);
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(RED + "Invalid input, please input a number" + RESET);
                    scanner.nextLine();
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
           }
                    
            scanner.nextLine();
           
            System.out.print("Enter a car color: ");
            color = scanner.nextLine();
            

            Cars[i] = new Car(brand, model, year, color);
            System.out.println();
            System.out.println(GREEN + "Car added successfully" + RESET);
            System.out.println();
        }
    }

    public void startEngine(String brandname){
        Car temp;
        for(int i = 0; i < Cars.length - 1; i++){
            for(int j = 0; j < Cars.length - i - 1; j++){
                if(Cars[j].getBrand().compareTo(Cars[j + 1].getBrand()) > 0){
                    temp = Cars[j];
                    Cars[j] = Cars[j + 1];
                    Cars[j + 1] = temp;
                }
            }
        }

        int start = 0;
        int end = this.Cars.length - 1;
        while(start <= end){

            int middle = (start + end) / 2;

            if(brandname.equals(Cars[middle].getBrand())){
                System.out.println();
                Cars[middle].startEngine();
                return;
            }else if(brandname.compareTo(Cars[middle].getBrand()) < 0){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        System.out.println(RED + "Car brand not found" + RESET);
    }

    public void stopEngine(String brandname){
        Car temp;
        for(int i = 0; i < Cars.length - 1; i++){
            for(int j = 0; j < Cars.length - i - 1; j++){
                if(Cars[j].getBrand().compareTo(Cars[j + 1].getBrand()) > 0){
                    temp = Cars[j];
                    Cars[j] = Cars[j + 1];
                    Cars[j + 1] = temp;
                }
            }
        }

        int start = 0;
        int end = this.Cars.length - 1;
        while(start <= end){

            int middle = (start + end) / 2;

            if(brandname.equals(Cars[middle].getBrand())){
                System.out.println();
                Cars[middle].stopEngine();
                return;
            }else if(brandname.compareTo(Cars[middle].getBrand()) < 0){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        System.out.println(RED + "Car brand not found" + RESET);
    }

    public void compareAge(){
        if (this.Cars.length < 2) {
            System.out.println(RED + "Not enough cars to compare." + RESET);
            return;
        }
    
        System.out.println("Select two cars to compare by age:");
    
        for (int i = 0; i < Cars.length; i++) {
            System.out.println((i + 1) + ". " + Cars[i].getBrand() + " - " + Cars[i].getModel() + " (" + Cars[i].getYear() + ")");
        }
    
        int firstCarIndex = -1;
        int secondCarIndex = -1;
    
        while (firstCarIndex < 0 || firstCarIndex >= Cars.length) {
            System.out.print("Enter the number of the first car: ");
            try {
                firstCarIndex = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Please enter a number." + RESET);
                scanner.nextLine();
            }
        }
    
        while (secondCarIndex < 0 || secondCarIndex >= Cars.length) {
            System.out.print("Enter the number of the second car: ");
            try {
                secondCarIndex = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Please enter a number." + RESET);
                scanner.nextLine();
            }
        }
    
        Car firstCar = Cars[firstCarIndex];
        Car secondCar = Cars[secondCarIndex];
    
        int comparisonResult = firstCar.compareAge(secondCar);
    
        System.out.println();
        if (comparisonResult == -1) {
            System.out.println(firstCar.getBrand() + " is older than " + secondCar.getBrand());
        } else if (comparisonResult == 0) {
            System.out.println(firstCar.getBrand() + " and " + secondCar.getBrand() + " are from the same year.");
        } else {
            System.out.println(firstCar.getBrand() + " is newer than " + secondCar.getBrand());
        }
    }

    public void displayInfo(){
        System.out.println("----------------------------\n" +
                           CYAN + "\tList of Cars" + RESET +
                           "\n----------------------------");
        for(Car Car : this.Cars) {
            System.out.println(Car);
            System.out.println();
        }
    }
}
