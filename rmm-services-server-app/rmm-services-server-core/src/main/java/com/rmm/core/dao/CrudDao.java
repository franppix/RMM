/**
 * Implementation class for interface ICrudDao
 */
package com.rmm.core.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.rmm.core.util.EntityManagerRmm;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

/**
 * @author FJGM
 * @param <T> Entity
 *
 */
public abstract class CrudDao<T> implements ICrudDao<T> {

	private EntityManager entityManager = EntityManagerRmm.getEntityManager();

	private Class<T> genericClass;

	@Override
	public Optional<T> getForId(String id) {
		return Optional.ofNullable(entityManager.find(genericClass, id));
	}

	@Override
	public Optional<T> getForId(int id) {
		return Optional.ofNullable(entityManager.find(genericClass, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Query query = entityManager.createQuery("FROM " + genericClass.getName());
		return query.getResultList();
	}

	@Override
	public void save(T t) throws HandledException {
		try {
			executeTransaction(entityManager -> entityManager.persist(t));
		} catch (Exception e) {
			throw new HandledException(TypeError.ERROR_INSERT.getErrorCode(), TypeError.ERROR_INSERT.getErrorDesc(), e);
		}
	}

	@Override
	public void update(T t) throws HandledException {
		try {
			executeTransaction(entityManager -> entityManager.merge(t));
		} catch (Exception e) {
			throw new HandledException(TypeError.ERROR_UPDATE.getErrorCode(), TypeError.ERROR_UPDATE.getErrorDesc(), e);
		}
	}

	@Override
	public void delete(T t) throws HandledException {
		try {
			executeTransaction(entityManager -> entityManager.remove(t));
		} catch (Exception e) {
			throw new HandledException(TypeError.ERROR_DELETE.getErrorCode(), TypeError.ERROR_DELETE.getErrorDesc(), e);
		}
	}

	public void setGenericClass(Class<T> genericClass) {
		this.genericClass = genericClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Generic method for insert, update and delete objects in the table
	 * 
	 * @param action Entity action
	 */
	private void executeTransaction(Consumer<EntityManager> action) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			action.accept(entityManager);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

}
