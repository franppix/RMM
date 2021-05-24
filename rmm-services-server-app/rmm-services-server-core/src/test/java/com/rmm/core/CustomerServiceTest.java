package com.rmm.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.rmm.core.entity.CustomerService;

public class CustomerServiceTest {

	@Test
	public void test1_setCustomerService() {

		CustomerService customerService = new CustomerService();
		customerService.setId(1);
		customerService.setCustomer(null);
		customerService.setDateCreate(LocalDate.now());
		customerService.setService(null);
		assertEquals(customerService.getId(), 1);
		
	}

	@Test
	public void test2_getCustomerService() {

		CustomerService customerService = new CustomerService(LocalDate.now(), null, null);
		assertNull(customerService.getCustomer());
		assertNull(customerService.getService());
		assertEquals(customerService.getId(), 0);
		assertEquals(customerService.getDateCreate(), LocalDate.now());

	}

	@Test
	public void test3_toString() {
		CustomerService customerService = new CustomerService(LocalDate.now(), null, null);
		customerService.toString();
		assertTrue(true);

	}

}
