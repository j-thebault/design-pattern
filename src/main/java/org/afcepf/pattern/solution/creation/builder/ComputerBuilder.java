package org.afcepf.pattern.solution.creation.builder;

// SRP !
// Cette classe ne fait aucune validation métier, son rôle est uniquement de construire un objet de class Computer.
// La validation des règles métiers est du ressort des classes métiers (aka classes du domaine)
public class ComputerBuilder {
    private Processor processor;
    private Memory memory = Memory._1GO;
    private OperatingSystem operatingSystem;

    public ComputerBuilder() {
    }

    public ComputerBuilder withCpu(Processor processor){
        this.processor = processor;
        return this;
    }

    public ComputerBuilder withMemory(Memory memory){
        this.memory = memory;
        return this;
    }

    public ComputerBuilder withOperatingSystem(OperatingSystem operatingSystem){
        this.operatingSystem = operatingSystem;
        return this;
    }

    public Computer build(){
        return new Computer(this.processor, this.memory, this.operatingSystem);
    }
}
