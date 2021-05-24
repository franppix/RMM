package com.rmm.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.rmm.core.entity.Customer;
import com.rmm.core.entity.CustomerService;
import com.rmm.core.entity.Service;
import com.rmm.service.dto.CustomerServiceDto;
import com.rmm.service.mapper.CustomerServiceMapper;



/**
 * Unit test for simple App.
 */
public class CustomerServiceTest {


	@Test
	public void mapCustomerServicetoDto() {
		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		Service service = new Service("TST","Antivirus","Prueba");
		CustomerService customerService = new CustomerService(LocalDate.now(), customer, service);
		CustomerServiceMapper customerServiceMap = new CustomerServiceMapper();
		CustomerServiceDto customerServiceDto = customerServiceMap.convert(customerService);  

		assertNotNull(customerServiceDto);
		assertEquals(customerServiceDto.getDateCreate(), customerService.getDateCreate());
		assertEquals(customerServiceDto.getServiceName(), customerService.getService().getServiceName());
		
		
	}
	
	@Test
	public void mapDtoToCustomerService() {
		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		Service service = new Service("TST","Antivirus","Prueba");
		CustomerServiceDto customerServiceDto = new CustomerServiceDto(0,"TST",LocalDate.now(),"Antivirus");
		CustomerServiceMapper customerServiceMap = new CustomerServiceMapper();
		
		CustomerService customerService = customerServiceMap.convert(customerServiceDto, customer, service);

		assertNotNull(customerService);
		assertEquals(customerServiceDto.getDateCreate(), customerService.getDateCreate());
		assertEquals(customerServiceDto.getServiceName(), customerService.getService().getServiceName());
		
	}
	
	@Test
	public void mapListCustomerServicetoDto() {

		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		
		Service service = new Service("TST","Antivirus","Prueba");
		Service service2 = new Service("ANT","Antivirus","Prueba");
		Service service3 = new Service("CLO","Antivirus","Prueba");
		
		CustomerService customerService = new CustomerService(LocalDate.now(), customer, service);
		CustomerService customerService2 = new CustomerService(LocalDate.now(), customer, service2);
		CustomerService customerService3 = new CustomerService(LocalDate.now(), customer, service3);
		
		List<CustomerService> customerServiceLst = new ArrayList<CustomerService>();
		customerServiceLst.add(customerService);
		customerServiceLst.add(customerService2);
		customerServiceLst.add(customerService3);
		
		CustomerServiceMapper customerServiceMap = new CustomerServiceMapper();
		List<CustomerServiceDto> customerServiceDtoList = customerServiceMap.ConverListServiceToDto(customerServiceLst);  
		
		for (CustomerServiceDto customerServiceDto2 : customerServiceDtoList) {
			assertNotNull(customerServiceDto2);
		}
	}
	
	@Test
	public void mapListDtoToCustomerService() {

		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		Service service = new Service("CLO","Antivirus","Prueba");
		CustomerServiceDto customerServiceDto = new CustomerServiceDto(0,"CLO",LocalDate.now(),"Antivirus");
		CustomerServiceDto customerServiceDto2 = new CustomerServiceDto(0,"CLO",LocalDate.now(),"Antivirus");
		CustomerServiceDto customerServiceDto3 = new CustomerServiceDto(0,"CLO",LocalDate.now(),"Antivirus");
		
		List<CustomerServiceDto> customerServiceDtoLst = new ArrayList<CustomerServiceDto>();
		customerServiceDtoLst.add(customerServiceDto);
		customerServiceDtoLst.add(customerServiceDto2);
		customerServiceDtoLst.add(customerServiceDto3);
		
		CustomerServiceMapper customerServiceMap = new CustomerServiceMapper();
		List<CustomerService> customerServiceLst = customerServiceMap.ConverListDtoToService(customerServiceDtoLst, customer, service);

		for (CustomerService customerService2 : customerServiceLst) {
			assertNotNull(customerService2);
		}
		
	}
}
