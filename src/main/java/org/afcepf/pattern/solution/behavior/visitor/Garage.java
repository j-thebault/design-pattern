package org.afcepf.pattern.solution.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

// La classe Garage n'est plus responsable de gérer les limites interne du RepairBot (SRP)
// une instance neuve de repair bot est crée à chaque nouvel appel de la fonction repairAll
public class Garage {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public Garage() {
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Bus());
    }

    public void repairAll() {
        RepairBot repairBot = new RepairBot();
        for (Vehicle vehicle : vehicles) {
            vehicle.accept(repairBot);
        }
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
}
