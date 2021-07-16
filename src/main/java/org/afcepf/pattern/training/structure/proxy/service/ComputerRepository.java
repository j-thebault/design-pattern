package org.afcepf.pattern.training.structure.proxy.service;

import java.util.List;

import org.afcepf.pattern.training.creation.builder.Computer;

public interface ComputerRepository {
	Computer create();
	List<Computer> findAllComputers();
}
