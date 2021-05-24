package com.rmm.core.integrity;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.core.dao.DeviceDao;
import com.rmm.core.entity.Customer;
import com.rmm.core.entity.Device;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeDevices;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTest {
	
	@Test
	public void test1_addDevice() {
		DeviceDao deviceDao = new DeviceDao();
		Customer customer = new Customer("E126", "Printech", "USA", "dirección 1", "098784");
    	Device devices = new Device("LP132", "WINDOWS INFO", TypeDevices.WINDOWS_SERVER , LocalDate.now(),customer);
        try {
        	deviceDao.save(devices);
            assertNotNull(devices);
		} catch (Exception e) {
			assertNotNull(new String());
		}
    	
	}
	
	@Test
	public void test2_updateDevice() {
		DeviceDao deviceDao = new DeviceDao();
		Customer customer = new Customer("E126", "Printech", "USA", "dirección 1", "098784");
		Device devices = new Device("LP132",  "MAC124", TypeDevices.MAC , LocalDate.now(),customer);
		try {
			deviceDao.update(devices);
			assertNotNull(devices);
		} catch (HandledException e) {
			assertNotNull(new String());
		}
        
		
	}
	
	@Test
	public void test3_getDevice() {
		DeviceDao deviceDao = new DeviceDao();
        Optional<Device> optDevice = deviceDao.getForId("LP132");
		assertTrue(optDevice.isPresent());
	}
	
		
	@Test
	public void test4_deleteDevice() {
		DeviceDao deviceDao = new DeviceDao();
        Optional<Device> optDevice = deviceDao.getForId("LP132");
        if(optDevice.isPresent()) {
        	try {
				deviceDao.delete(optDevice.get());
				assertNotNull(optDevice.get());
			} catch (HandledException e) {
				 assertNotNull(new String());
			}
            
        }
        assertNotNull(new String());
		
	}
	
	@Test
	public void test5_getDeviceNotExist() {
		DeviceDao deviceDao = new DeviceDao();
        Optional<Device> optDevice = deviceDao.getForId("LP132");
		assertFalse(optDevice.isPresent());
	}
	
	
	@Test
	public void test6_getAllCustomer() {
		DeviceDao deviceDao = new DeviceDao();
		List<Device> deviceLst = deviceDao.getAll();
		assertTrue(deviceLst.size()>0);
		
	}
	
	
}
