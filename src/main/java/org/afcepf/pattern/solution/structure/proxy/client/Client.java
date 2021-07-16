package org.afcepf.pattern.solution.structure.proxy.client;

import java.util.List;

import org.afcepf.pattern.solution.creation.builder.Computer;
import org.afcepf.pattern.solution.structure.proxy.service.ComputerRepository;


// Interdit de toucher à cette classe, c'est le principe du proxy
public class Client {

	private final ComputerRepository repository;

	
	// Injection par constructeur, toujours préférable à une injection par setter ou pire par field
	// Réserver les injection par setter à des cas spécifique (dépendances circulaires...) et eviter autant que possible les injections par annotation sur les champs
	// Dans le test on la fera à la main
	// Dans une application JEE ou Spring c'est le conteneur qui la fera.
	public Client(ComputerRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Computer createAndSaveComputer() {
		return this.repository.create();
	}
	
	public List<Computer> findAllComputers() {
		return this.repository.findAllComputers();
	}
	
}
