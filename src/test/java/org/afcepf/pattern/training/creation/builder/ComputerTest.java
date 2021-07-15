package org.afcepf.pattern.training.creation.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void buildComputer() {
		Computer computer = new Computer();
		computer.setCpu("Intel i7");
		computer.setRam(16);
		computer.setOs("Debian");
		Assertions.assertEquals("Intel i7", computer.getCpu());
		Assertions.assertEquals(16, computer.getRam());
		Assertions.assertEquals("Debian", computer.getOs());
	}

}
