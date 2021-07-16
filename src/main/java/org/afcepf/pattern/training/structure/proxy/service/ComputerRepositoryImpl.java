package org.afcepf.pattern.training.structure.proxy.service;

import java.util.ArrayList;
import java.util.List;

import org.afcepf.pattern.training.creation.builder.Computer;


public class ComputerRepositoryImpl implements ComputerRepository {

	private final List<Computer> computers = new ArrayList<>();

	@Override
	public Computer create() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Computer> findAllComputers() {
		throw new UnsupportedOperationException();
	}
}
