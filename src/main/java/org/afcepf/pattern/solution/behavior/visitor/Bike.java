package org.afcepf.pattern.solution.behavior.visitor;

public class Bike implements Vehicle {
    public void accept(VehicleVisitor visitor){
        visitor.visit(this);
    }
}
