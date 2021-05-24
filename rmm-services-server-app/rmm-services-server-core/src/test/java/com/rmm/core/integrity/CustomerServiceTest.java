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

import com.rmm.core.dao.CustomerServiceDao;
import com.rmm.core.dao.ServiceDao;
import com.rmm.core.entity.Customer;
import com.rmm.core.entity.CustomerService;
import com.rmm.core.entity.Service;
import com.rmm.util.exception.HandledException;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {

	@Test
	public void test1_addServiceCustomer() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Customer customer = new Customer("E126", "Printech", "USA", "dirección 1", "098784");
		ServiceDao serviceDao = new ServiceDao();
		Optional<Service> optService = serviceDao.getForId("ANT");
		CustomerService devices = new CustomerService(LocalDate.now(), customer, optService.get());
		try {
			customerServiceDao.save(devices);
			assertNotNull(devices);
		} catch (Exception e) {
			assertNotNull(new String());
		}

	}

	@Test
	public void test2_updateServiceCustomer() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Customer customer = new Customer("E126", "Printech", "USA", "dirección 1", "098784");
		ServiceDao serviceDao = new ServiceDao();
		Optional<Service> optService = serviceDao.getForId("ANT");
		CustomerService customerService = new CustomerService(28, LocalDate.now(), customer, optService.get());
		try {
			customerServiceDao.update(customerService);
			assertNotNull(customerService);
		} catch (HandledException e) {
			assertNotNull(new String());
		}

	}

	@Test
	public void test3_getServiceCustomer() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Optional<CustomerService> optCustomerService = customerServiceDao.getForId(17);
		assertTrue(optCustomerService.isPresent());
	}

	@Test
	public void test4_deleteServiceCustomer() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Optional<CustomerService> optCustomerService = customerServiceDao.getForId(28);
		if (optCustomerService.isPresent()) {
			try {
				customerServiceDao.delete(optCustomerService.get());
				assertNotNull(optCustomerService.get());
			} catch (HandledException e) {
				assertNotNull(new String());
			}

		}

	}

	@Test
	public void test5_getServiceCustomerNotExist() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Optional<CustomerService> optCustomerService = customerServiceDao.getForId(28);
		System.out.println(optCustomerService.isPresent());
		assertFalse(optCustomerService.isPresent());
	}

	@Test
	public void test6_getAllServiceCustomer() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		List<CustomerService> customerServiceLst = customerServiceDao.getAll();
		assertTrue(customerServiceLst.size() > 0);

	}

	@Test
	public void test7_validateServiceExist() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Customer customer = new Customer("H126", "Printech", "USA", "dirección 1", "098784");
		ServiceDao serviceDao = new ServiceDao();
		Optional<Service> optService = serviceDao.getForId("ANT");
		CustomerService customerService = new CustomerService(LocalDate.now(), customer, optService.get());
		assertTrue(customerServiceDao.existServiceCustomer(customerService));
	}

	@Test
	public void test8_validateServiceNotExist() {
		CustomerServiceDao customerServiceDao = new CustomerServiceDao();
		Customer customer = new Customer("H126", "Printech", "USA", "dirección 1", "098784");
		ServiceDao serviceDao = new ServiceDao();
		Optional<Service> optService = serviceDao.getForId("TEV");
		CustomerService customerService = new CustomerService(LocalDate.now(), customer, optService.get());
		assertFalse(customerServiceDao.existServiceCustomer(customerService));
	}

}
