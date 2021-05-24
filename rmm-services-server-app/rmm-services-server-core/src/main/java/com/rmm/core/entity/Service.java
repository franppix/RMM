/**
 * Entity for get information of ServicesCost table
 * Information about differents service
 */
package com.rmm.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author FJGM
 *
 */

@Entity
@Table(name = "service")
public class Service {

	@Id
	private String id;

	@Column(name = "service_name")
	private String serviceName;

	private String description;

	@OneToMany(mappedBy = "service")
	private List<CustomerService> customerServices;

	@OneToMany(mappedBy = "service")
	private List<ServiceCost> servicesCost;

	public Service() {

	}

	/**
	 * Service constructor
	 * 
	 * @param id          service id
	 * @param serviceName service name
	 * @param description description service
	 */
	public Service(String id, String serviceName, String description) {
		this.id = id;
		this.serviceName = serviceName;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CustomerService> getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(List<CustomerService> customerServices) {
		this.customerServices = customerServices;
	}

	public List<ServiceCost> getServicesCost() {
		return servicesCost;
	}

	public void setServicesCost(List<ServiceCost> servicesCost) {
		this.servicesCost = servicesCost;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName + ", description=" + description + "]";
	}

}
