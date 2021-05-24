/**
 * Entity for get information of Device table
 * Information about customer devices
 */
package com.rmm.core.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rmm.util.types.TypeDevices;

/**
 * @author FJGM
 *
 */
@Entity
@Table (name="device")
public class Device {
	
	@Id
	private String id;
	
	@Column(name="system_name")
	private String systemName;
	
	private TypeDevices type;
	
	@Column(name="date_create")
	private LocalDate dateCreate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	

	
	public Device() {
		
	}
	
	
	/**
	 * Device constructor
	 * 
	 * @param id			id device (MAC ADRESS)
	 * @param systemName	Device name
	 * @param type			Device Type
	 * @param dateCreate	creation Date
	 * @param customer		Customer object
	 * @param services		Service object
	 */
	public Device(String id, String systemName, TypeDevices type, LocalDate dateCreate, Customer customer) {
		this.id = id;
		this.systemName = systemName;
		this.type = type;
		this.dateCreate = dateCreate;
		this.customer = customer;
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public TypeDevices getType() {
		return type;
	}
	
	public void setType(TypeDevices type) {
		this.type = type;
	}

	public LocalDate getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	@Override
	public String toString() {
		return "Device [id=" + id + ", systemName=" + systemName + ", type=" + type + ", dateCreate=" + dateCreate
				+ "]";
	}
	
	
	
	
}
