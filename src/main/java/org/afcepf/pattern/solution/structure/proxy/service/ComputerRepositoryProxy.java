package org.afcepf.pattern.solution.structure.proxy.service;

import java.util.List;

import org.afcepf.pattern.solution.creation.builder.Computer;

public class ComputerRepositoryProxy implements ComputerRepository {
	
	private final TransactionManager transactionManager;
	private final ComputerRepository proxifiedComputerRepository;
	

	public ComputerRepositoryProxy(TransactionManager transactionManager,
			ComputerRepository proxifiedComputerRepository) {
		super();
		this.transactionManager = transactionManager;
		this.proxifiedComputerRepository = proxifiedComputerRepository;
	}

	// Grace au proxy, j'ai en quelque sorte emballé mes appels à mon ComputerRepository originel
	// Maintenant imaginez un système pour créer automatiquement des proxys et vous obtennez la base de toute la "magie" des frameworks
	// Par exemple les annotations @Transactional, @PreAuthorize...
	// Ou encore les entités Hibernate... 
	// Vous voyez bien que ce ne sont pas vos vraies classes puisqu'elles ont des comportement que vous n'avez pas codé
	// et qu'elles vous lancent des exceptions à la noix (LazyInitialisationException...)
	// Vos entités hibernate sont en fait des proxy, et le comportement du framework vient s'intercaler autour de vos methodes...
	@Override
	public Computer create() {
		transactionManager.start();
		Computer computer = proxifiedComputerRepository.create();
		transactionManager.commit();
		return computer;
	}

	@Override
	public List<Computer> findAllComputers() {
		transactionManager.start();
		List<Computer> computers = proxifiedComputerRepository.findAllComputers();
		transactionManager.commit();
		return computers;
	}

}
