/**
 * DAO for operation to entity Service
 */
package com.rmm.core.dao;

import com.rmm.core.entity.Service;

/**
 * @author FJGM
 *
 */
public class ServiceDao extends CrudDao<Service> {

	public ServiceDao() {
		setGenericClass(Service.class);
	}

}
