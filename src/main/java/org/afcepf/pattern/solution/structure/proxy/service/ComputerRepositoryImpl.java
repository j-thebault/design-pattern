package org.afcepf.pattern.solution.structure.proxy.service;

import java.util.ArrayList;
import java.util.List;

import org.afcepf.pattern.solution.creation.builder.Computer;
import org.afcepf.pattern.solution.creation.builder.ComputerBuilder;
import org.afcepf.pattern.solution.creation.builder.OperatingSystem;
import org.afcepf.pattern.solution.creation.builder.Processor;

public class ComputerRepositoryImpl implements ComputerRepository {

	private final List<Computer> computers = new ArrayList<>();

	@Override
	public Computer create() {
		Computer computer = new ComputerBuilder()
		.withCpu(Processor.INTEL_I7)
		.withOperatingSystem(OperatingSystem.DEBIAN)
		.build();
		
		this.computers.add(computer);
		
		return computer;
	}

	@Override
	public List<Computer> findAllComputers() {
		return computers;
	}
}
