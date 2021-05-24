/**
 * POJO Object For Customer Service
 */
package com.rmm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author FJGM
 *
 */
public class CustomerServiceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private LocalDate dateCreate;
	private String serviceId;
	private String serviceName;

	public CustomerServiceDto() {

	}

	/**
	 * CustomerServiceDto constructor
	 * 
	 * @param id          customer service id
	 * @param serviceId   service id
	 * @param dateCreate  creation date
	 * @param serviceName service name
	 */
	public CustomerServiceDto(int id, String serviceId, LocalDate dateCreate, String serviceName) {
		super();
		this.id = id;
		this.serviceId = serviceId;
		this.dateCreate = dateCreate;
		this.serviceName = serviceName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public LocalDate getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
