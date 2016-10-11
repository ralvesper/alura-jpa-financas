package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static JPAUtil instance;
	private EntityManagerFactory entityManagerFactory = null;

	private JPAUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("financas-mysql");
	}

	public static JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
		}

		return instance;
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
