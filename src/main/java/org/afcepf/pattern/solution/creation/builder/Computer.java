package org.afcepf.pattern.solution.creation.builder;

import static java.util.Objects.requireNonNull;

// Toute la logique de domaine est délégué dans les value objects
// La classe computer se comporte comme un Aggregat de ses objets propriété
// Aucune propriété n'est une primitive nue.
// ValueObject Pattern en DDD ou Expert en Information du GRASP
public class Computer {
	private final Processor cpu;
	private final Memory ram; // A simple value object ...
	private final OperatingSystem os;

	Computer(Processor cpu, Memory ram, OperatingSystem operatingSystem) {
		this.cpu = requireNonNull(cpu, "Cpu cannot be null");
		this.ram = requireNonNull(ram, "Ram cannot be null");
		this.os = requireNonNull(operatingSystem, "Operating System cannot be null");
		os.validate(ram);
		os.validate(cpu);
	}

}
