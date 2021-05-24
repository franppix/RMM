package com.rmm.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rmm.core.entity.Service;

public class ServiceTest {

	@Test
	public void test1_setService() {

		Service service = new Service();
		service.setId("CDC");
		service.setServiceName("TEST");
		service.setDescription("TEST");
		service.setServicesCost(null);
		service.setCustomerServices(null);
		assertEquals(service.getId(), "CDC");
		
	}

	@Test
	public void test2_getService() {

		Service service = new Service("TST","Antivirus","Prueba");
		assertNull(service.getServicesCost());
		assertNull(service.getCustomerServices());
		assertEquals(service.getId(), "TST");
		assertEquals(service.getServiceName(), "Antivirus");
		assertEquals(service.getDescription(), "Prueba");

	}

	@Test
	public void test3_toString() {
		Service service = new Service("TST","Antivirus","Prueba");
		service.toString();
		assertTrue(true);

	}

}
