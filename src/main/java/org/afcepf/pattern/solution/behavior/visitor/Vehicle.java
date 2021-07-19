package org.afcepf.pattern.solution.behavior.visitor;

public interface Vehicle {
    void accept(VehicleVisitor visitor);
}
