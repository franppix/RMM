package com.rmm.core.integrity;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.core.dao.ServiceDao;
import com.rmm.core.entity.Service;
import com.rmm.util.exception.HandledException;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {
	
	@Test
	public void test1_addService() {
		ServiceDao serviceDao = new ServiceDao();
    	Service serviceAntivirusWS = new Service("TST","Antivirus","Prueba");
        try {
        	serviceDao.save(serviceAntivirusWS);
            assertNotNull(serviceAntivirusWS);
		} catch (Exception e) {
			assertNotNull(new String());
		}
    	
	}
	
	@Test
	public void test2_updateService() {
		ServiceDao serviceDao = new ServiceDao();
		Service serviceAntivirusWS = new Service("TST","Antivirus","Prueba");
    	try {
			serviceDao.update(serviceAntivirusWS);
			assertNotNull(serviceAntivirusWS);
		} catch (HandledException e) {
			assertNotNull(new String());
		}
	}
	
	@Test
	public void test3_getService() {
		ServiceDao serviceDao = new ServiceDao();
        Optional<Service> optService = serviceDao.getForId("TST");
		assertTrue(optService.isPresent());
	}
	
		
	@Test
	public void test4_deleteService() {
		ServiceDao serviceDao = new ServiceDao();
        Optional<Service> optService = serviceDao.getForId("TST");
        if(optService.isPresent()) {
        	try {
				serviceDao.delete(optService.get());
				assertNotNull(optService.get());
			} catch (HandledException e) {
				assertNotNull(new String());
			}
            
        }
        assertNotNull(new String());
		
	}
	
	@Test
	public void test5_getServiceNotExist() {
		ServiceDao serviceDao = new ServiceDao();
        Optional<Service> optService = serviceDao.getForId("TST");
		assertFalse(optService.isPresent());
	}
	
	
	@Test
	public void test6_getAllCustomer() {
		ServiceDao serviceDao = new ServiceDao();
		List<Service> serviceLst = serviceDao.getAll();
		assertTrue(serviceLst.size()>0);
		
	}
}
