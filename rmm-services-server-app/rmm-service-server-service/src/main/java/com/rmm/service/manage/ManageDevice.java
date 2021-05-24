/**
 * Interface for business methods to Device
 */
package com.rmm.service.manage;

import java.util.List;

import com.rmm.service.dto.DeviceDto;
import com.rmm.util.exception.HandledException;

/**
 * @author fgonz
 *
 */
public interface ManageDevice {
	
	public DeviceDto addDevice(DeviceDto device, String idNumber) throws HandledException;
	
	public DeviceDto updateDevice(DeviceDto device, String idNumber) throws HandledException;
	
	public void deleteDevice(String id) throws HandledException;
	
	public List<DeviceDto> getAll(String idNumber) throws HandledException;

}
