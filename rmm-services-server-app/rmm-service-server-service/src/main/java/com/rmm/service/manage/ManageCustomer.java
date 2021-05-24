/**
 * Interface for business methods to Customer
 */
package com.rmm.service.manage;

import java.util.List;

import com.rmm.service.dto.BillDto;
import com.rmm.service.dto.CustomerDto;
import com.rmm.util.exception.HandledException;

/**
 * @author FJGM
 *
 */
public interface ManageCustomer {

	/**
	 * Method for validate if customer exist
	 * @param idNumber customer id
	 * @return CustomerDto
	 * @throws HandledException
	 */
	public CustomerDto validateCustomer(String idNumber) throws HandledException;
	
	/**
	 * Method 
	 * @param idNumber
	 * @return
	 * @throws HandledException
	 */
	public List<BillDto> getMonthly(String idNumber) throws HandledException;
}
