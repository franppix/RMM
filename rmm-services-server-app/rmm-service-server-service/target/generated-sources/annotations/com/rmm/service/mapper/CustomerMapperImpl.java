package com.rmm.service.mapper;

import com.rmm.core.entity.Customer;
import com.rmm.service.dto.CustomerDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-24T16:12:08-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer convert(CustomerDto customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setIdNumber( customer.getIdNumber() );
        customer1.setName( customer.getName() );
        customer1.setNationality( customer.getNationality() );
        customer1.setPhoneNumber( customer.getPhoneNumber() );
        customer1.setAddress( customer.getAddress() );

        return customer1;
    }

    @Override
    public CustomerDto convert(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setIdNumber( customer.getIdNumber() );
        customerDto.setName( customer.getName() );
        customerDto.setNationality( customer.getNationality() );
        customerDto.setAddress( customer.getAddress() );
        customerDto.setPhoneNumber( customer.getPhoneNumber() );

        return customerDto;
    }
}
