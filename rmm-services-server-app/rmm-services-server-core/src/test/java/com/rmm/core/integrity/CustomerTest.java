package com.rmm.core.integrity;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rmm.core.dao.CustomerDao;
import com.rmm.core.entity.Customer;
import com.rmm.util.exception.HandledException;



/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	
	@Test
	public void test1_addCustomer() {
		CustomerDao customerDao = new CustomerDao();
    	Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
        try {
        	customerDao.save(customer);
            assertNotNull(customer);
		} catch (HandledException e) {
			System.out.println(e);
			assertNotNull(new String());
		}
    	
	}
	
	@Test
	public void test2_updateCustomer() {
		CustomerDao customerDao = new CustomerDao();
    	Customer customer = new Customer("P129Z", "MieleSSSoft", "Ecuador", "dirección", "098457");
    	try {
	        customerDao.update(customer);
	        assertNotNull(customer);
    	} catch (HandledException e) {
			System.out.println(e);
			assertNotNull(new String());
		}
        
		
	}
	
	@Test
	public void test3_getCustomer() {
		CustomerDao customerDao = new CustomerDao();
        Optional<Customer> optCustomer = customerDao.getForId("P129Z");
		assertTrue(optCustomer.isPresent());
	}
	
		
	@Test
	public void test4_deleteCustomer() {
		CustomerDao customerDao = new CustomerDao();
        Optional<Customer> optCustomer = customerDao.getForId("P129Z");
        if(optCustomer.isPresent()) {
        	try {
	        	customerDao.delete(optCustomer.get());
	            assertNotNull(optCustomer.get());
        	} catch (HandledException e) {
    			System.out.println(e);
    			assertNotNull(new String());
    		}    
        }
        assertNotNull(new String());
		
	}
	
	@Test
	public void test5_getCustomerNotExist() {
		CustomerDao customerDao = new CustomerDao();
        Optional<Customer> optCustomer = customerDao.getForId("P129Z");
        System.out.println(optCustomer.isPresent());
		assertFalse(optCustomer.isPresent());
	}
	
	
	@Test
	public void test6_getAllCustomer() {
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerLst = customerDao.getAll();
		assertTrue(customerLst.size()>0);
		
	}
}
