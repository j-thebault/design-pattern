package org.afcepf.pattern.training.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/*
 * 1 - Ajouter un autre vehicule, Bike qui vaut 5 et mettre à jour le test
 * 2 - Implémenter le pattern Visiteur et changer le RepairBot en Visiteur. Refactorer les tests.
 * 3 - Ajouter un autre type de Vehicule. Qu'est ce qui change par rapport à l'ajout de Bike ?
 */
public class Garage {

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final RepairBot repairBot = new RepairBot();

    public Garage() {
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Bus());
    }

    public void repairAll() {
        int cost = 0;
        for (Vehicle vehicle : vehicles) {
            cost += repairBot.repair(vehicle);
            if (cost > 200) {
                throw new IllegalArgumentException("Too many things too repair, i'm a poor and lonely repair bot...");
            }
        }
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
}
