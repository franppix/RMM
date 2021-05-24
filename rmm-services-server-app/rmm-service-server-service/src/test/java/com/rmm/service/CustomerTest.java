package com.rmm.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.rmm.core.entity.Customer;
import com.rmm.service.dto.CustomerDto;
import com.rmm.service.mapper.CustomerMapper;



/**
 * Unit test for simple App.
 */
public class CustomerTest {


	@Test
	public void mapCustomertoDto() {
		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");

		CustomerDto customerDto = CustomerMapper.INSTANCE.convert(customer);

		assertNotNull(customerDto);
		assertEquals(customerDto.getIdNumber(), customer.getIdNumber());
		assertEquals(customerDto.getName(), customer.getName());
		assertEquals(customerDto.getNationality(), customer.getNationality());
		assertEquals(customerDto.getAddress(), customer.getAddress());
		assertEquals(customerDto.getPhoneNumber(), customer.getPhoneNumber());
		
	}
	
	@Test
	public void mapDtoCustomerto() {
		CustomerDto customerDto = new CustomerDto("P126", "MieleSoft", "Ecuador", "dirección", "098457");

		Customer customer = CustomerMapper.INSTANCE.convert(customerDto);

		assertNotNull(customerDto);
		assertEquals(customerDto.getIdNumber(), customer.getIdNumber());
		assertEquals(customerDto.getName(), customer.getName());
		assertEquals(customerDto.getNationality(), customer.getNationality());
		assertEquals(customerDto.getAddress(), customer.getAddress());
		assertEquals(customerDto.getPhoneNumber(), customer.getPhoneNumber());
		
	}
	
}
