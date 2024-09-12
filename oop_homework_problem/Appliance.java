/**
 * @author markymouseee
 **/

package oop_homework_problem;

abstract class Appliance {
    public abstract void turnOn();

    public void turnOff(){
        System.out.println("The appliance is now off.");
    }
}

class WashingMachine extends Appliance{
    @Override
    public void turnOn() {
        System.out.println("The washing machine is washing clothes");
    }
}

class Refrigerator extends Appliance{
    @Override
    public void turnOn() {
        System.out.println("The refrigerator is cooling soft drinks");
    }
}

class MainOfAppliance{
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();
        Refrigerator refrigerator = new Refrigerator();

        washingMachine.turnOn();
        washingMachine.turnOff();

        refrigerator.turnOn();
        refrigerator.turnOff();
    }
}
