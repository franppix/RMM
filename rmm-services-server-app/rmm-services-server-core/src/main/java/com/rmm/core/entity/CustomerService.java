/**
 * Entity for get information of Customer Service table
 * Information about customer services
 */
package com.rmm.core.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author FJGM
 *
 */
@Entity
@Table(name = "customer_service")
public class CustomerService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date_create")
	private LocalDate dateCreate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	public CustomerService() {

	}

	/**
	 * CustomerService constructor
	 * 
	 * @param dateCreate creation date
	 * @param customer   Customer object
	 * @param service    Service object
	 */
	public CustomerService(LocalDate dateCreate, Customer customer, Service service) {
		super();
		this.dateCreate = dateCreate;
		this.customer = customer;
		this.service = service;
	}

	/**
	 * 
	 * CustomerService constructor
	 * 
	 * @param id         id Customer Service
	 * @param dateCreate creation date
	 * @param customer   Customer object
	 * @param service    Service object
	 */
	public CustomerService(int id, LocalDate dateCreate, Customer customer, Service service) {
		super();
		this.id = id;
		this.dateCreate = dateCreate;
		this.customer = customer;
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "CustomerService [id=" + id + ", dateCreate=" + dateCreate + "]";
	}

}
