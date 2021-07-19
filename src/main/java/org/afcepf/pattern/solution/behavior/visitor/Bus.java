package org.afcepf.pattern.solution.behavior.visitor;

public class Bus implements Vehicle {
    public void accept(VehicleVisitor visitor){
        visitor.visit(this);
    }
}
