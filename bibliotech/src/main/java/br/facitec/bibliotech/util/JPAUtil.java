package br.facitec.bibliotech.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManagerFactory  entityManager;

	public EntityManager getEntityManager(){
		if (entityManager == null){
			entityManager = Persistence.createEntityManagerFactory("bibliotech");
		}
		return entityManager.createEntityManager();
	}
	
}
