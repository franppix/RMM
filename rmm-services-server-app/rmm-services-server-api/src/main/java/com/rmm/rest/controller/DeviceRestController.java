package com.rmm.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.rest.pojo.Device;
import com.rmm.rest.pojo.ResponseListRmm;
import com.rmm.rest.pojo.ResponseRmm;
import com.rmm.service.dto.DeviceDto;
import com.rmm.service.manage.impl.ManageDeviceImpl;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

@RestController
@RequestMapping("/api")
public class DeviceRestController {
	
	
	@GetMapping("/device/{customerId}")
	public ResponseListRmm<DeviceDto> getCustomerDevice(@PathVariable String customerId){
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		try {
			List<DeviceDto> deviceList =  manageDevice.getAll(customerId);
			ResponseListRmm<DeviceDto> responseRmm = new ResponseListRmm<DeviceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponseList(deviceList);
			return responseRmm;
		} catch (HandledException e) {
			ResponseListRmm<DeviceDto> responseRmm = new ResponseListRmm<DeviceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
	}
	
	@PostMapping(path = "/device", consumes = "application/json")
	public ResponseRmm<DeviceDto> addDevice(@RequestBody Device device) {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		try {
			DeviceDto deviceDto = manageDevice.addDevice(device.getDevice(), device.getIdNumber());
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponse(deviceDto);
			return responseRmm;
		} catch (HandledException e) {
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
		
	}
	
	@PutMapping(path = "/device", consumes = "application/json")
	public ResponseRmm<DeviceDto> updateDevice(@RequestBody Device device) {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		try {
			DeviceDto deviceDto = manageDevice.updateDevice(device.getDevice(), device.getIdNumber());
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponse(deviceDto);
			return responseRmm;
		} catch (HandledException e) {
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
		
	}
	
	@DeleteMapping("/device/{deviceId}")
	public ResponseRmm<DeviceDto> deleteDevice(@PathVariable String deviceId) {
		ManageDeviceImpl manageDevice = new ManageDeviceImpl();
		try {
			manageDevice.deleteDevice(deviceId);
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			return responseRmm;
		} catch (HandledException e) {
			ResponseRmm<DeviceDto> responseRmm = new ResponseRmm<DeviceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
		
	}
}
