package org.afcepf.pattern.training.structure.proxy.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.afcepf.pattern.training.creation.builder.Computer;
import org.afcepf.pattern.training.structure.proxy.service.ComputerRepository;
import org.afcepf.pattern.training.structure.proxy.service.ComputerRepositoryImpl;
import org.afcepf.pattern.training.structure.proxy.service.TransactionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientTest {
	
	private Client client;
	private ComputerRepository repository; 
	private TransactionManager transactionManager; 
	
	@BeforeEach
	public void setup() {
		// Ici j'intialise un faux transaction manager, un mock, qui va me permettre de m'assurer que votre proxy appelle bien le TransactionManager
		// Vous pouvez vous servir de ce mock dans votre proxy
		transactionManager = Mockito.mock(TransactionManager.class);
		
		// Vous avez le droit de changer l'implémentation de ComputerRepository donnée à votre client.
		// En condition réelle c'est surement votre conteneur (conteneur JEE, conteneur Spring...) qui fera l'injection pour vous
		repository = new ComputerRepositoryImpl();
		client = new Client(repository);
	}

	@Test
	void shouldAddComputer() {
		Computer computer = client.createAndSaveComputer();
		List<Computer> allComputers = client.findAllComputers();
		assertNotNull(computer);
		assertEquals(1, allComputers.size());
		assertEquals(computer, allComputers.get(0));
	}
	
	@Test
	void proxyShouldWork() {
		client.createAndSaveComputer();
		// Ici, je verifie que mon mock a bien été appellé
		// Votre proxy doit avoir appellé start() et commit()
		Mockito.verify(transactionManager).start();
		Mockito.verify(transactionManager).commit();
	}

}
