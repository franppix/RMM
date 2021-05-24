package com.rmm.rest.pojo;

import com.rmm.service.dto.CustomerServiceDto;

public class CustomerService {

	private CustomerServiceDto service;
	private String idNumber;

	public CustomerServiceDto getService() {
		return service;
	}

	public void setService(CustomerServiceDto service) {
		this.service = service;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
