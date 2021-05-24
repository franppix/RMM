/**
 * DAO for operation to entity Customer
 */
package com.rmm.core.dao;

import javax.persistence.Query;

import com.rmm.core.entity.CustomerService;

/**
 * @author FJGM
 *
 */
public class CustomerServiceDao extends CrudDao<CustomerService> {

	public CustomerServiceDao() {
		setGenericClass(CustomerService.class);
	}

	/**
	 * Method for validate if exist the service for customer
	 * 
	 * @param customerService CustomerService object
	 * @return boolean True: if exist, False: if not exist
	 */
	public boolean existServiceCustomer(CustomerService customerService) {
		Query query = getEntityManager().createQuery("FROM " + CustomerService.class.getName()
				+ " Where service.id = :serviceId and " + "customer.idNumber = :customerId ");
		query.setParameter("serviceId", customerService.getService().getId());
		query.setParameter("customerId", customerService.getCustomer().getIdNumber());
		return query.getResultList().size() > 0;
	}

}
