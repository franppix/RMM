/**
 * DAO for operation to entity Device
 */
package com.rmm.core.dao;

import com.rmm.core.entity.Device;

/**
 * @author FJGM
 *
 */
public class DeviceDao extends CrudDao<Device> {

	public DeviceDao() {
		setGenericClass(Device.class);
	}

}
