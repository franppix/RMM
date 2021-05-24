/**
 * Implementation of ManageCustomer
 */
package com.rmm.service.manage.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rmm.core.dao.CustomerDao;
import com.rmm.core.entity.Customer;
import com.rmm.core.entity.CustomerService;
import com.rmm.core.entity.Device;
import com.rmm.core.entity.ServiceCost;
import com.rmm.service.dto.BillDto;
import com.rmm.service.dto.CustomerDto;
import com.rmm.service.manage.ManageCustomer;
import com.rmm.service.mapper.CustomerMapper;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.Const;
import com.rmm.util.types.TypeError;

/**
 * @author FJGM
 *
 */
public class ManageCustomerImpl implements ManageCustomer {

	@Override
	public CustomerDto validateCustomer(String idNumber) {
		CustomerDao customerDao = new CustomerDao();
		Optional<Customer> optCliente = customerDao.getForId(idNumber);
		CustomerDto customerDto = optCliente.isPresent() ? CustomerMapper.INSTANCE.convert(optCliente.get()) : null;
		return customerDto;
	}

	@Override
	public List<BillDto> getMonthly(String idNumber) throws HandledException {

		CustomerDao customerDao = new CustomerDao();
		Optional<Customer> optCliente = customerDao.getForId(idNumber);
		List<BillDto> billList = new ArrayList<BillDto>();
		if (optCliente.isPresent()) {
			Customer customer = optCliente.get();
			billList = getServicesCost(customer);
			return billList;
		} else {
			throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(), TypeError.NO_CUSTOMER.getErrorDesc());
		}
	}

	/**
	 * Method for get the list of service and cost
	 * 
	 * @param customer Customer
	 * @return List<BillDto>
	 */
	private List<BillDto> getServicesCost(Customer customer) {
		int winDeviceNumber = 0;
		int macDeviceNumber = 0;
		double total = 0.0;
		List<BillDto> billList = new ArrayList<BillDto>();
		BillDto billDto = new BillDto(Const.DEVICES, customer.getDevices().size() * Const.DEVICE_COST);
		total += customer.getDevices().size() * Const.DEVICE_COST;
		billList.add(billDto);
		for (Device device : customer.getDevices()) {
			switch (device.getType().getSystemCode()) {
			case Const.WIN_CODE:
				winDeviceNumber++;
				break;
			case Const.MAC_CODE:
				macDeviceNumber++;
				break;
			default:
				break;
			}
		}
		for (CustomerService customerService : customer.getCustomerServices()) {
			double totalService = 0.0;
			if (customerService.getService().getServicesCost().size() > 1) {
				for (ServiceCost serviceCost : customerService.getService().getServicesCost()) {
					totalService += serviceCost.getSystem() == Const.WIN_CODE ? serviceCost.getCost() * winDeviceNumber
							: serviceCost.getCost() * macDeviceNumber;
				}
			} else {
				totalService = customerService.getService().getServicesCost().get(0).getCost()
						* (winDeviceNumber + macDeviceNumber);
			}
			total += totalService;
			billDto = new BillDto(customerService.getService().getServiceName(), totalService);
			billList.add(billDto);
		}

		billDto = new BillDto(Const.TOTAL, total);
		billList.add(billDto);
		return billList;
	}

}
