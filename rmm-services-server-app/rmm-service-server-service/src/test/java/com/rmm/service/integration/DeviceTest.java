package com.rmm.service.integration;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.service.dto.DeviceDto;
import com.rmm.service.manage.impl.ManageDeviceImpl;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeDevices;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTest {
	
	@Test
	public void test1_addDevice() {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		DeviceDto device = new DeviceDto("W1458", "Local Machine", TypeDevices.WINDOWS_WORKSTATION, LocalDate.now());
		try {
			manageDevice.addDevice(device, "F126");
			assertNotNull(device);
		} catch (HandledException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1_addDeviceNoCust() {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		DeviceDto device = new DeviceDto("W1458", "Local Machine", TypeDevices.WINDOWS_WORKSTATION, LocalDate.now());
		try {
			manageDevice.addDevice(device, "F126X");
			assertNotNull(device);
		} catch (HandledException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test2_updateDevice() {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		DeviceDto device = new DeviceDto("W1458", "Local Machine Win", TypeDevices.WINDOWS_WORKSTATION, LocalDate.now());
		try {
			manageDevice.updateDevice(device, "F126");
			assertNotNull(device);
		} catch (HandledException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test2_updateDeviceNoCust() {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		DeviceDto device = new DeviceDto("W1458", "Local Machine Win", TypeDevices.WINDOWS_WORKSTATION, LocalDate.now());
		try {
			manageDevice.updateDevice(device, "F126XX");
			assertNotNull(device);
		} catch (HandledException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void test3_deleteDevice() {
		try {
			ManageDeviceImpl manageDevice = new ManageDeviceImpl();
			manageDevice.deleteDevice("W1458");
		} catch (HandledException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test3_deleteDeviceNoExis() {
		try {
			ManageDeviceImpl manageDevice = new ManageDeviceImpl();
			manageDevice.deleteDevice("W1458XX");
		} catch (HandledException e) {
			assertTrue(true); 
		}
		
	}
	
	@Test
	public void test4_getCustomerDevice() {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		try {
			List<DeviceDto> deviceList = manageDevice.getAll("F126");
			for (DeviceDto deviceDto : deviceList) {
				assertNotNull(deviceDto);
			}
		} catch (HandledException e) {
			e.printStackTrace();
		}
		
	}

}
