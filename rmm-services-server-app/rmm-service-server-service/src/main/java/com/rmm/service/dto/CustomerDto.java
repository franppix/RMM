/**
 * POJO Object For return Monthly bill
 */
package com.rmm.service.dto;

import java.io.Serializable;

/**
 * @author FJGM
 *
 */
public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idNumber;
	private String name;
	private String nationality;
	private String address;
	private String phoneNumber;

	public CustomerDto() {

	}

	/**
	 * CustomerDTO constructos
	 * 
	 * @param idNumber    customer id
	 * @param name        customer name
	 * @param nationality customer nationality
	 * @param address     customer address
	 * @param phoneNumber customer phone number
	 */
	public CustomerDto(String idNumber, String name, String nationality, String address, String phoneNumber) {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
