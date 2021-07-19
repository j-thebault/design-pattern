package org.afcepf.pattern.solution.behavior.visitor;

// L'interface VehicleVisitor possède une méthode pour chaque class concrète
// Celà apporte à la compilation, la garantie qu'aucun type concret ne sera "oublié".
// C'est un énorme avantage par rapport à ces switch/if qui n'offrent aucune sécurité à ce niveau
// Dans un gros programme l'utilisation de visiteurs facilite la maintenance en cas d'ajout d'un nouveau type concret
public interface VehicleVisitor {
    void visit(Bus bus);
    void visit(Car car);
    void visit(Bike bike);
    void visit(Truck truck);
}
