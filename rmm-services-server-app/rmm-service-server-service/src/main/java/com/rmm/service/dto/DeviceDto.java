/**
 * POJO Object For Customer Device
 */
package com.rmm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.rmm.util.types.TypeDevices;

/**
 * @author FJGM
 *
 */
public class DeviceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String systemName;
	private TypeDevices type;
	private LocalDate dateCreate;

	public DeviceDto() {

	}

	/**
	 * DeviceDto constructor
	 * 
	 * @param id         device id
	 * @param systemName device name
	 * @param type       device type enum
	 * @param dateCreate creation date
	 */
	public DeviceDto(String id, String systemName, TypeDevices type, LocalDate dateCreate) {
		super();
		this.id = id;
		this.systemName = systemName;
		this.type = type;
		this.dateCreate = dateCreate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public TypeDevices getType() {
		return type;
	}

	public void setType(TypeDevices type) {
		this.type = type;
	}

	public LocalDate getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

}
