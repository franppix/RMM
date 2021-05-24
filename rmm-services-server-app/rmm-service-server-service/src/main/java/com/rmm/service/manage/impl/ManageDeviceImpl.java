/**
 * Implementation of ManageDevice
 */
package com.rmm.service.manage.impl;

import java.util.List;
import java.util.Optional;

import com.rmm.core.dao.CustomerDao;
import com.rmm.core.dao.DeviceDao;
import com.rmm.core.entity.Customer;
import com.rmm.core.entity.Device;
import com.rmm.service.dto.CustomerDto;
import com.rmm.service.dto.DeviceDto;
import com.rmm.service.manage.ManageDevice;
import com.rmm.service.mapper.CustomerMapper;
import com.rmm.service.mapper.DeviceMapper;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

/**
 * @author FJGM
 *
 */
public class ManageDeviceImpl implements ManageDevice {

	@Override
	public DeviceDto addDevice(DeviceDto deviceDto, String idNumber) throws HandledException {
			ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
			CustomerDto customerDto =manageCustomer.validateCustomer(idNumber);
			if ( customerDto ==null) {
				throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(),TypeError.NO_CUSTOMER.getErrorDesc());
			}
			Device device = DeviceMapper.INSTANCE.convert(deviceDto);
			device.setCustomer(CustomerMapper.INSTANCE.convert(customerDto));
			DeviceDao deviceDao = new DeviceDao();
			deviceDao.save(device);
			return DeviceMapper.INSTANCE.convert(device);
		
	}

	@Override
	public DeviceDto updateDevice(DeviceDto deviceDto, String idNumber) throws HandledException{
		try {
			ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
			CustomerDto customerDto =manageCustomer.validateCustomer(idNumber);
			if ( customerDto ==null) {
				throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(),TypeError.NO_CUSTOMER.getErrorDesc());
			}
			Device device = DeviceMapper.INSTANCE.convert(deviceDto);
			device.setCustomer(CustomerMapper.INSTANCE.convert(customerDto));
			DeviceDao deviceDao = new DeviceDao();
			deviceDao.update(device);
			return DeviceMapper.INSTANCE.convert(device);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteDevice(String id) throws HandledException{
			DeviceDao deviceDao = new DeviceDao();
		    Optional<Device> optDevice = deviceDao.getForId(id);
		    if(optDevice.isPresent()) {
		    	deviceDao.delete(optDevice.get());
		    }else {
		    	throw new HandledException(TypeError.NO_DEVICE.getErrorCode(),TypeError.NO_DEVICE.getErrorDesc());
		    }
	}
	

	@Override
	public List<DeviceDto> getAll(String idNumber) throws HandledException {
		CustomerDao customerDao = new CustomerDao();
		Optional<Customer> optCliente = customerDao.getForId(idNumber);
		if(optCliente.isPresent()) {
			List<DeviceDto> deviceDtoLst = DeviceMapper.INSTANCE.ConverListDeviceToDto(optCliente.get().getDevices());
			return deviceDtoLst;
		}else {
			throw new HandledException(TypeError.NO_CUSTOMER.getErrorCode(),TypeError.NO_CUSTOMER.getErrorDesc());
		}
	}

}
