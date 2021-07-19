package org.afcepf.pattern.solution.behavior.visitor;

public class RepairBot {
    // repair a vehicle and return the cost
    int repair(Vehicle vehicle) {
        if(vehicle instanceof Car){
            return 10;
        } else {
            return 100;
        }
    }
}
