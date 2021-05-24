/**
 * DAO for operation for entity Customer
 */
package com.rmm.core.dao;

import com.rmm.core.entity.Customer;

/**
 * @author FJGM
 *
 */
public class CustomerDao extends CrudDao<Customer> {
	
	public CustomerDao() {
		setGenericClass(Customer.class);
	}

}
