package com.rmm.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.rmm.core.entity.Customer;
import com.rmm.core.entity.Device;
import com.rmm.util.types.TypeDevices;

public class DeviceTest {

	@Test
	public void test1_setDevice() {

		Device device = new Device();
		device.setId("TST123");
		device.setDateCreate(LocalDate.now());
		device.setSystemName("WINDOWS INFO");
		device.setCustomer(null);
		device.setType(TypeDevices.WINDOWS_SERVER );
		assertEquals(device.getId(), "TST123");
		
	}

	@Test
	public void test2_getDevice() {

		Device device = new Device("LP132", "WINDOWS INFO", TypeDevices.WINDOWS_SERVER , LocalDate.now(),null);
		assertNull(device.getCustomer());
		assertEquals(device.getId(), "LP132");
		assertEquals(device.getDateCreate(), LocalDate.now());
		assertEquals(device.getSystemName(), "WINDOWS INFO");
		assertEquals(device.getType(), TypeDevices.WINDOWS_SERVER );

	}

	@Test
	public void test3_toString() {
		Customer customer = new Customer("E126", "Printech", "USA", "dirección 1", "098784");
		Device device = new Device("LP132", "WINDOWS INFO", TypeDevices.WINDOWS_SERVER , LocalDate.now(),customer);
		device.toString();
		assertTrue(true);

	}

}
