/**
 * Entity for get information of Customer table
 * Information about customer
 */
package com.rmm.core.entity;

/**
 * @author FJGM
 *
 */
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "id_number")
	private String idNumber;

	private String name;

	private String nationality;

	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "customer")
	private List<Device> devices;

	@OneToMany(mappedBy = "customer")
	private List<CustomerService> customerServices;

	public Customer() {

	}

	/**
	 * Customer constructor
	 * 
	 * @param idNumber    unique id for customer
	 * @param name        customer name
	 * @param nationality customer nationality
	 * @param address     customer address
	 * @param phoneNumber customer phone number
	 */
	public Customer(String idNumber, String name, String nationality, String address, String phoneNumber) {
		this.idNumber = idNumber;
		this.name = name;
		this.nationality = nationality;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<CustomerService> getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(List<CustomerService> customerServices) {
		this.customerServices = customerServices;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", nationality=" + nationality + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
