package com.rmm.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.rmm.core.entity.Customer;
import com.rmm.core.entity.Device;
import com.rmm.service.dto.DeviceDto;
import com.rmm.service.mapper.DeviceMapper;
import com.rmm.util.types.TypeDevices;



/**
 * Unit test for simple App.
 */
public class DeviceTest {


	@Test
	public void mapDevicetoDto() {
		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		Device device = new Device("LP128", "MAC", TypeDevices.MAC , LocalDate.now(),customer);

		DeviceDto deviceDto = DeviceMapper.INSTANCE.convert(device);

		assertNotNull(deviceDto);
		assertEquals(deviceDto.getId(), device.getId());
		assertEquals(deviceDto.getSystemName(), device.getSystemName());
		assertEquals(deviceDto.getType(), device.getType());
		assertEquals(deviceDto.getDateCreate(), device.getDateCreate());
		
	}
	
	@Test
	public void mapDtoToDevice() {
		DeviceDto deviceDto = new DeviceDto("LP128", "MAC", TypeDevices.MAC , LocalDate.now());

		Device device = DeviceMapper.INSTANCE.convert(deviceDto);

		assertNotNull(device);
		assertEquals(deviceDto.getId(), device.getId());
		assertEquals(deviceDto.getSystemName(), device.getSystemName());
		assertEquals(deviceDto.getType(), device.getType());
		assertEquals(deviceDto.getDateCreate(), device.getDateCreate());
		
	}
	
	@Test
	public void mapListDevicetoDto() {
		Customer customer = new Customer("P126", "MieleSoft", "Ecuador", "dirección", "098457");
		Device device = new Device("LP128", "WINDOWS", TypeDevices.MAC , LocalDate.now(),customer);
		Device devicew = new Device("LP129", "WINDOWS", TypeDevices.WINDOWS_SERVER , LocalDate.now(),customer);
		
		List<Device> deviceLst = new ArrayList<Device>();
		deviceLst.add(device);
		deviceLst.add(devicew);

		List<DeviceDto> deviceDtoLst = DeviceMapper.INSTANCE.ConverListDeviceToDto(deviceLst);
		
		for (DeviceDto deviceDto2 : deviceDtoLst) {
			System.out.println(deviceDto2.getId()+" "+deviceDto2.getSystemName());
			assertNotNull(deviceDto2);
			assertEquals("WINDOWS",deviceDto2.getSystemName());
		}

	}
	
	@Test
	public void mapDtoToDeviceLst() {
		DeviceDto deviceDto = new DeviceDto("LP128", "MAC", TypeDevices.MAC , LocalDate.now());
		DeviceDto deviceDto2 = new DeviceDto("LP129", "MAC", TypeDevices.MAC , LocalDate.now());
		
		List<DeviceDto> deviceDtoLst = new ArrayList<DeviceDto>();
		deviceDtoLst.add(deviceDto);
		deviceDtoLst.add(deviceDto2);
		
		List<Device> deviceList = DeviceMapper.INSTANCE.ConverListDtoToDivice(deviceDtoLst);
		
		for (Device device2 : deviceList) {
			System.out.println(device2);
			assertNotNull(device2);
			assertEquals("MAC",device2.getSystemName());
		}
		
	}
}
