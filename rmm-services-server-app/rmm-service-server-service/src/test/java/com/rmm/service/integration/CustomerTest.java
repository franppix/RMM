package com.rmm.service.integration;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.service.dto.BillDto;
import com.rmm.service.dto.CustomerDto;
import com.rmm.service.manage.impl.ManageCustomerImpl;
import com.rmm.util.exception.HandledException;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	
	@Test
	public void test1_validateCustomer() {
		ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
		CustomerDto customer = manageCustomer.validateCustomer("F126");
		assertNotNull(customer);
		assertEquals(customer.getIdNumber(), "F126");
	}
	
	@Test
	public void test2_validateCustomerNotExist() {
		ManageCustomerImpl manageCustomerNot = new ManageCustomerImpl();
		CustomerDto customer = new CustomerDto();
		customer = manageCustomerNot.validateCustomer("F1262q");
		assertNull(customer);
		
	}
	
	@Test
	public void test3_getMonthlyBill() {
		try {
			ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
			List<BillDto> billDtoLst =  manageCustomer.getMonthly("F126");
			for (BillDto billDto : billDtoLst) {
				assertNotNull(billDto);
			}
		}catch (HandledException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3_getMonthlyBillNoCust() {
		try {
			ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
			List<BillDto> billDtoLst =  manageCustomer.getMonthly("F126XX");
			for (BillDto billDto : billDtoLst) {
				assertNotNull(billDto);
			}
		}catch (HandledException e) {
			assertTrue(true);
		}
	}
}
