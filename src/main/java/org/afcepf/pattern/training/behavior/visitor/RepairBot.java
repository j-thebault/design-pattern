package org.afcepf.pattern.training.behavior.visitor;

public class RepairBot {
    // repair a vehicle and return the cost
    int repair(Vehicle vehicle) {
        if(vehicle instanceof Car){
            System.out.println("I repair a car");
            return 10;
        } else {
            System.out.println("I repair a bus");
            return 100;
        }
    }
}
