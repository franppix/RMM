package com.rmm.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rmm.core.entity.ServiceCost;

public class ServiceCostTest {

	@Test
	public void test1_setServiceCost() {

		ServiceCost service = new ServiceCost();
		service.setId(1);
		service.setCost(5.0);
		service.setSystem(1);
		service.setService(null);
		assertEquals(service.getId(), 1);
		
	}

	@Test
	public void test2_getServiceCost() {

		ServiceCost service = new ServiceCost(1,1,5.0,null);
		assertNull(service.getService());
		assertEquals(service.getId(), 1);
		assertEquals(service.getSystem(), 1);
		assertEquals(service.getCost(), 5.0,1);

	}

	@Test
	public void test3_toString() {
		ServiceCost service = new ServiceCost(1,1,5.0,null);
		service.toString();
		assertTrue(true);

	}

}
