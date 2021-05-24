/**
 * Implementation of ManageService
 */
package com.rmm.service.manage.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.rmm.core.dao.CustomerDao;
import com.rmm.core.dao.CustomerServiceDao;
import com.rmm.core.dao.ServiceDao;
import com.rmm.core.entity.Customer;
import com.rmm.core.entity.CustomerService;
import com.rmm.core.entity.Service;
import com.rmm.service.dto.CustomerServiceDto;
import com.rmm.service.manage.ManageService;
import com.rmm.service.mapper.CustomerServiceMapper;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

/**
 * @author FJGM
 *
 */
public class ManageServiceImpl implements ManageService {

	@Override
	public CustomerServiceDto addService(CustomerServiceDto serviceDto, String idNumber) throws HandledException {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		CustomerServiceMapper serviceMapper = new CustomerServiceMapper();
		ServiceDao serviceDao = new ServiceDao();
		CustomerDao customerDao = new CustomerDao();
		CustomerService service;
		Optional<Customer> optCliente = customerDao.getForId(idNumber);
		if (optCliente.isPresent()) {
			Optional<Service> optService = serviceDao.getForId(serviceDto.getServiceId());
			if (!optService.isPresent()) {
				throw new HandledException(TypeError.NO_SERVICE.getErrorCode(), TypeError.NO_SERVICE.getErrorDesc());
			}
			service = new CustomerService(LocalDate.now(), optCliente.get(), optService.get());
			if (customerServiceDao.existServiceCustomer(service)) {
				throw new HandledException(TypeError.SERVICE_EXIST.getErrorCode(),
						TypeError.SERVICE_EXIST.getErrorDesc());
			}
			customerServiceDao.save(service);
			return serviceMapper.convert(service);
		} else {
			throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(), TypeError.NO_CUSTOMER.getErrorDesc());
		}
	}

	@Override
	public void deleteService(int id) throws HandledException {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Optional<CustomerService> optCustomerService = customerServiceDao.getForId(id);
		if (optCustomerService.isPresent()) {
			customerServiceDao.delete(optCustomerService.get());
		} else {
			throw new HandledException(TypeError.NO_SERVICE.getErrorCode(), TypeError.NO_SERVICE.getErrorDesc());
		}
	}

	@Override
	public List<CustomerServiceDto> getServiceByCustomer(String idNumber) throws HandledException {
		CustomerDao customerDao = new CustomerDao();
		Optional<Customer> optCliente = customerDao.getForId(idNumber);
		CustomerServiceMapper customerServiceMapper = new CustomerServiceMapper();
		if (optCliente.isPresent()) {
			List<CustomerServiceDto> customerServiceDtoLst = customerServiceMapper
					.ConverListServiceToDto(optCliente.get().getCustomerServices());
			return customerServiceDtoLst;
		} else {
			throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(), TypeError.NO_CUSTOMER.getErrorDesc());
		}
	}

}
