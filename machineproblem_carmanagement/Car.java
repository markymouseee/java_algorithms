package machineproblem_carmanagement;

public class Car {
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean engineStarted;

    public Car(String brand, String model, int year, String color){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineStarted = false;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEngineStarted(){
        return engineStarted;
    }

    public void startEngine(){
        if(!engineStarted){
            engineStarted = true;
            System.out.println(GREEN + "The engine of " + brand + " is started." + RESET);
        }else{
             System.out.println(YELLOW + "The engine of " + brand + " is already running." + RESET);
        }
    }

    public void stopEngine() {
        if (engineStarted) {
            engineStarted = false;
            System.out.println(GREEN + "The engine of " + brand + " is stopped." + RESET);
        } else {
            System.out.println(YELLOW + "The engine of " + brand + " is already off." + RESET);
        }
    }

    public int compareAge(Car otherCar) {
        if (this.year < otherCar.getYear()) {
            return -1;
        } else if (this.year == otherCar.getYear()) {
            return 0;
        } else {
            return 1;
        }
    }
    

   @Override
    public String toString(){
        return(
            YELLOW + "========================================\n" + RESET +
            "Car Brand: " + brand + "\n" +
            "Car Model: " + model + "\n" +
            "Car Year:  " + year + "\n" +
            "Car Color: " + color + "\n" +
            YELLOW + "========================================" + RESET
        );
    }
}
