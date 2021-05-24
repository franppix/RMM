/**
 * Class for map the object CustomerService
 */
package com.rmm.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.rmm.core.entity.Customer;
import com.rmm.core.entity.CustomerService;
import com.rmm.core.entity.Service;
import com.rmm.service.dto.CustomerServiceDto;

/**
 * @author FJGM
 *
 */
public class CustomerServiceMapper {

	/**
	 * Convert CustomerService to CustomerServiceDto
	 * 
	 * @param customerService CustomerService
	 * @return CustomerServiceDto
	 */
	public CustomerServiceDto convert(CustomerService customerService) {
		try {
			CustomerServiceDto customerServiceDto = new CustomerServiceDto(customerService.getId(),
					customerService.getService().getId(), customerService.getDateCreate(),
					customerService.getService().getServiceName());
			return customerServiceDto;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert CustomerServiceDto to CustomerService
	 * 
	 * @param customerServiceDto CustomerServiceDto
	 * @param customer           Customer
	 * @param service            Service
	 * @return CustomerService
	 */
	public CustomerService convert(CustomerServiceDto customerServiceDto, Customer customer, Service service) {
		try {
			CustomerService customerService = new CustomerService(customerServiceDto.getDateCreate(), customer,
					service);
			return customerService;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Conver List of CustomerServiceDto to List of CustomerService
	 * 
	 * @param customerServiceDtoLst List<CustomerServiceDto>
	 * @param customer              Customer
	 * @param service               Service
	 * @return List<CustomerService>
	 */
	public List<CustomerService> ConverListDtoToService(List<CustomerServiceDto> customerServiceDtoLst,
			Customer customer, Service service) {
		try {
			List<CustomerService> customerServiceLst = new ArrayList<CustomerService>();
			for (CustomerServiceDto customerServiceDto : customerServiceDtoLst) {
				customerServiceLst.add(convert(customerServiceDto, customer, service));
			}
			return customerServiceLst;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Convert list of CustomerService to list of CustomerServiceDto
	 * 
	 * @param customerServiceLst List<CustomerService>
	 * @return List<CustomerServiceDto>
	 */
	public List<CustomerServiceDto> ConverListServiceToDto(List<CustomerService> customerServiceLst) {
		try {
			List<CustomerServiceDto> customerServiceDtoLst = new ArrayList<CustomerServiceDto>();
			for (CustomerService customerService : customerServiceLst) {
				customerServiceDtoLst.add(convert(customerService));
			}
			return customerServiceDtoLst;
		} catch (Exception e) {
			return null;
		}
	}

}
