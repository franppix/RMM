/**
 * Interface for business methods to Service
 */
package com.rmm.service.manage;

import java.util.List;

import com.rmm.service.dto.CustomerServiceDto;
import com.rmm.util.exception.HandledException;

/**
 * @author FJGM
 *
 */
public interface ManageService {
	
	public CustomerServiceDto addService(CustomerServiceDto device, String idNumber) throws HandledException;
	
	public void deleteService(int id) throws HandledException;
	
	public List<CustomerServiceDto> getServiceByCustomer(String idNumber) throws HandledException;

}
