package com.rmm.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rmm.core.entity.Customer;

public class CustomerTest {

	@Test
	public void test1_setCustomer() {

		Customer customer = new Customer();
		customer.setIdNumber("TST123");
		customer.setPhoneNumber("0000");
		customer.setName("FJGM");
		customer.setNationality("EC");
		customer.setAddress("EC");
		customer.setCustomerServices(null);
		customer.setDevices(null);
		
		assertEquals(customer.getIdNumber(), "TST123");
		
	}

	@Test
	public void test2_getCustomer() {

		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		assertNull(customer.getDevices());
		assertNull(customer.getCustomerServices());
		assertEquals(customer.getIdNumber(), "P126");
		assertEquals(customer.getPhoneNumber(), "098457");
		assertEquals(customer.getName(), "MieleSoft");
		assertEquals(customer.getNationality(), "Ecuador");
		assertEquals(customer.getAddress(), "dirección");

	}

	@Test
	public void test3_toString() {

		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		customer.toString();
		assertTrue(true);

	}

}
