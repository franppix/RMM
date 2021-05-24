/**
 * Interface for map the Mapper object using mapstruct
 */
package com.rmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rmm.core.entity.Customer;
import com.rmm.service.dto.CustomerDto;

/**
 * @author FJGM
 *
 */

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
	
	/**
	 * Convert customerDto to Customer
	 * @param customer CustomerDto
	 * @return Customer
	 */
	Customer convert(CustomerDto customer);
	 
	/**
	 * Convert Customer to CustomerDto
	 * @param customer Customer
	 * @return CustomerDto
	 */
	CustomerDto convert(Customer customer);
	
}
