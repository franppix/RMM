package com.rmm.service.integration;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.service.dto.CustomerServiceDto;
import com.rmm.service.manage.impl.ManageServiceImpl;
import com.rmm.util.exception.HandledException;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {


	@Test
	public void test1_addCustomerService() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		CustomerServiceDto serviceDto = new CustomerServiceDto(0,"CLO",LocalDate.now(),"TEST SERVICES");
		try {
			manageService.addService(serviceDto, "H126");
			assertNotNull(serviceDto);
		} catch (HandledException e) {
			e.printStackTrace();
			assertNotNull(null);
		}
		
	}
	
	@Test
	public void test1_addCustomerServiceNoExistServ() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		CustomerServiceDto serviceDto = new CustomerServiceDto(0,"CLX",LocalDate.now(),"TEST SERVICES");
		try {
			manageService.addService(serviceDto, "H126");
			assertNotNull(serviceDto);
		} catch (HandledException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void test1_addCustomerServiceNoExistCus() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		CustomerServiceDto serviceDto = new CustomerServiceDto(0,"CLO",LocalDate.now(),"TEST SERVICES");
		try {
			manageService.addService(serviceDto, "H126AA");
			assertNotNull(serviceDto);
		} catch (HandledException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void test1_addCustomerServiceExist() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		CustomerServiceDto serviceDto = new CustomerServiceDto(0,"CLO",LocalDate.now(),"TEST SERVICES");
		try {
			manageService.addService(serviceDto, "H126");
			assertNotNull(serviceDto);
		} catch (HandledException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void test2_deleteCustomerService() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			List<CustomerServiceDto> serviceList =manageService.getServiceByCustomer("H126");
			manageService.deleteService(serviceList.get(serviceList.size()-1).getId());
			assertTrue(true);
		} catch (HandledException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void test2_deleteCustomerServiceNoExist() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			manageService.deleteService(999);
			assertTrue(true);
		} catch (HandledException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test3_getAllCustomerService() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			List<CustomerServiceDto> serviceList =manageService.getServiceByCustomer("F126");
			for (CustomerServiceDto customerServiceDto : serviceList) {
				assertNotNull(customerServiceDto);
			}
		}catch(HandledException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void test3_getAllCustomerServiceNoExistCust() {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			List<CustomerServiceDto> serviceList =manageService.getServiceByCustomer("F126XXX");
			for (CustomerServiceDto customerServiceDto : serviceList) {
				assertNotNull(customerServiceDto);
			}
		}catch(HandledException e) {
			assertTrue(true);
		}
	}
	
}
