/**
 * Interface for map the Device object using mapstruct
 */
package com.rmm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rmm.core.entity.Device;
import com.rmm.service.dto.DeviceDto;

/**
 * @author FJGM
 *
 */

@Mapper
public interface DeviceMapper {

	DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

	/**
	 * Convert DeviceDto to Device
	 * 
	 * @param device DeviceDto
	 * @return Device
	 */
	Device convert(DeviceDto device);

	/**
	 * Convert Device to DeviceDto
	 * 
	 * @param device Device
	 * @return DeviceDto
	 */
	DeviceDto convert(Device device);

	/**
	 * Convert List of DeviceDto to List of Device
	 * 
	 * @param device List<DeviceDto>
	 * @return List<Device>
	 */
	List<Device> ConverListDtoToDivice(List<DeviceDto> device);

	/**
	 * Convert List of Device to List of DeviceDto
	 * 
	 * @param device List<Device>
	 * @return List<DeviceDto>
	 */
	List<DeviceDto> ConverListDeviceToDto(List<Device> device);

}
