/**
 * Interface for define the principal methods of entities
 */
package com.rmm.core.dao;

import java.util.List;
import java.util.Optional;

import com.rmm.util.exception.HandledException;

/**
 * @author FJGM
 *
 */
public interface ICrudDao<T> {

	/**
	 * Method for get entity with string id filtering by id
	 * 
	 * @param id String id for entity
	 * @return Optional<T> Entity
	 */
	Optional<T> getForId(String id);

	/**
	 * Method for get entity with int id filtering by id
	 * 
	 * @param id int id for entity
	 * @return Optional<T> Entity
	 */
	Optional<T> getForId(int id);

	/**
	 * Method for get entity with no filtering
	 * 
	 * @return List<T> List Entity
	 */
	List<T> getAll();

	/**
	 * Method for insert a new Entity
	 * 
	 * @param t Entity
	 * @throws HandledException
	 */
	void save(T t) throws HandledException;

	/**
	 * Method for update a new Entity
	 * 
	 * @param t Entity
	 * @throws HandledException
	 */
	void update(T t) throws HandledException;

	/**
	 * Method for delete a new Entity
	 * 
	 * @param t Entity
	 * @throws HandledException
	 */
	void delete(T t) throws HandledException;
}
