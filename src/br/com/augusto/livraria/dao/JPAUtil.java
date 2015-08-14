package br.com.augusto.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory managerFactory = Persistence
			.createEntityManagerFactory("livraria");

	public EntityManager getEntityManager() {
		return managerFactory.createEntityManager();
	}
	
	public void close(EntityManager manager) {
		manager.close();
	}

}
