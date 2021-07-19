package org.afcepf.pattern.solution.behavior.visitor;


// RepairBot contient maintenant l'ensemble de son métier
// Par ailleurs, le pattern visiteur permet de s'affranchir des switch/if, donc de tester plus facileemnt
// et d'être protégé contre les ajouts de nouvelles classes dès la compilation
public class RepairBot implements VehicleVisitor {

    private final int maximumRepairCapacity;
    private int usedRepairCapacity = 0;

    public RepairBot() {
        this(200);
    }

    public RepairBot(int maximumRepairCapacity) {
        this.maximumRepairCapacity = maximumRepairCapacity;
    }

    @Override
    public void visit(Bus bus) {
        System.out.println("Repair a Bus");
        useCapacity(100);
        checkMaximumRepairCapacity();
    }

    private void useCapacity(int i) {
        usedRepairCapacity += i;
    }

    @Override
    public void visit(Car car) {
        System.out.println("Repair a Car");
        useCapacity(10);
        checkMaximumRepairCapacity();
    }

    @Override
    public void visit(Bike bike) {
        System.out.println("Repair a Bike");
        useCapacity(5);
        checkMaximumRepairCapacity();
    }

    @Override
    public void visit(Truck truck) {
        System.out.println("Repair a Truck");
        useCapacity(50);
        checkMaximumRepairCapacity();
    }

    private void checkMaximumRepairCapacity() {
        if(usedRepairCapacity > maximumRepairCapacity){
            throw new IllegalArgumentException("Too many things too repair, i'm a poor and lonely repair bot...");
        }
    }
}
