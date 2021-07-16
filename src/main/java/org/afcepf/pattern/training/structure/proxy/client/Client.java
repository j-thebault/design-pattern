package org.afcepf.pattern.training.structure.proxy.client;

import java.util.List;

import org.afcepf.pattern.training.creation.builder.Computer;
import org.afcepf.pattern.training.structure.proxy.service.ComputerRepository;


//1 - 	Dans la classe ComputerRepositoryImpl, utiliser le builder de l'exercice pécédent pour créer un Computer et le mettre dans la liste. 
//       Ajouter le code pour findAllComputers
//       Le premier test doit passer au vert
//
//2 - Utiliser le pattern proxy pour emballer l'appel de create() avec les methodes start() et commit() de la classe TransactionManager -> Passer le second test au vert
//
//3 - Contraintes  :
//- Interdit de toucher à la classe Client.java, c'est tout l'intéret de l'exercice.
//- Interdit d'injecter directement le TransactionManager dans ComputerRepositoryImpl, vous devez passer par une classe proxy
//- En revanche dans le test, vous pouvez changer l'appel au constructeur de Client.java (Voir fichier de test)


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
