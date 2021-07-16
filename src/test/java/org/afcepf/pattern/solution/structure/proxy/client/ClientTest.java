package org.afcepf.pattern.solution.structure.proxy.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.afcepf.pattern.solution.creation.builder.Computer;
import org.afcepf.pattern.solution.structure.proxy.service.ComputerRepository;
import org.afcepf.pattern.solution.structure.proxy.service.ComputerRepositoryImpl;
import org.afcepf.pattern.solution.structure.proxy.service.ComputerRepositoryProxy;
import org.afcepf.pattern.solution.structure.proxy.service.TransactionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientTest {
	
	private Client client;
	private ComputerRepository repository; 
	private TransactionManager transactionManager; 
	
	@BeforeEach
	public void setup() {
		transactionManager = Mockito.mock(TransactionManager.class);
		// Ici je change manuellement l'implémentation fournie à mon client
		// une fois de plus en condition réelles c'est le conteneur qui gère
		repository = new ComputerRepositoryProxy(transactionManager, new ComputerRepositoryImpl());
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
		Mockito.verify(transactionManager).start();
		Mockito.verify(transactionManager).commit();
	}

}
