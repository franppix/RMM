/**
 * Class for create instance of EntityManager
 */
package com.rmm.core.util;

/**
 * @author FJGM
 *
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerRmm {

	/**
	 * Method for create connection to the DB and return the Entity
	 * 
	 * @return EntityManager
	 */
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rmmServices");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

}
