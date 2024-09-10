package machineproblem_carmanagement;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;

    public Car(String brand, String model, int year, String color){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
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

    public void startEngine(){
        System.out.println("Engine Started.");
    }

    public void stopEngine(){
        System.out.println("Engine Stopped.");
    }

   @Override
   public String toString(){
    return(
        "Car brand: " + brand + "\n" +
        "Car model: " + model + "\n" +
        "Car year:  " + year + "\n" +
        "Car color: " + color
    );
   }
}
