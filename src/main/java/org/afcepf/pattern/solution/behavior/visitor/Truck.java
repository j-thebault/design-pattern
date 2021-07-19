package org.afcepf.pattern.solution.behavior.visitor;

public class Truck implements Vehicle {
    public void accept(VehicleVisitor visitor){
        visitor.visit(this);
    }
}
