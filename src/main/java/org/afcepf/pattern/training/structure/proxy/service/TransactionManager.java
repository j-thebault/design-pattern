package org.afcepf.pattern.training.structure.proxy.service;

public class TransactionManager {

	public void start() {
		System.out.println("Start transaction");
	}

	public void commit() {
		System.out.println("Commit transaction");
	}
}
