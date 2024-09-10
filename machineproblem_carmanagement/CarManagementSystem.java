package machineproblem_carmanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CarManagementSystem {
    private Car[] Cars;
    private int row_size;
    private static Scanner scanner = new Scanner(System.in);

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

       
            System.out.print("Enter a car year: ");
            year = scanner.nextInt();
                    
            scanner.nextLine();
           
            System.out.print("Enter a car color: ");
            color = scanner.nextLine();
            

            Cars[i] = new Car(brand, model, year, color);
            System.out.println();
            System.out.println("Car Added Successfully");
            System.out.println();
        }
    }

    public void displayInfo(){
        for(int i = 0; i < this.Cars.length; i++){
            System.out.println(Cars[i]);
            System.out.println();
        }
    }
}
