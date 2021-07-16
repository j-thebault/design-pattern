package org.afcepf.pattern.solution.structure.proxy.service;

import java.util.List;

import org.afcepf.pattern.solution.creation.builder.Computer;

public interface ComputerRepository {
	Computer create();
	List<Computer> findAllComputers();
}
