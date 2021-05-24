package com.rmm.rest.pojo;

import com.rmm.service.dto.DeviceDto;

public class Device {

	private DeviceDto device;
	private String idNumber;

	public DeviceDto getDevice() {
		return device;
	}

	public void setDevice(DeviceDto device) {
		this.device = device;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
