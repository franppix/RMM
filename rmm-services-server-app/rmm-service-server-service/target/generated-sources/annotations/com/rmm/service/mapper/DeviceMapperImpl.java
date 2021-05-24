package com.rmm.service.mapper;

import com.rmm.core.entity.Device;
import com.rmm.service.dto.DeviceDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-24T16:12:08-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device convert(DeviceDto device) {
        if ( device == null ) {
            return null;
        }

        Device device1 = new Device();

        device1.setId( device.getId() );
        device1.setSystemName( device.getSystemName() );
        device1.setType( device.getType() );
        device1.setDateCreate( device.getDateCreate() );

        return device1;
    }

    @Override
    public DeviceDto convert(Device device) {
        if ( device == null ) {
            return null;
        }

        DeviceDto deviceDto = new DeviceDto();

        deviceDto.setId( device.getId() );
        deviceDto.setSystemName( device.getSystemName() );
        deviceDto.setType( device.getType() );
        deviceDto.setDateCreate( device.getDateCreate() );

        return deviceDto;
    }

    @Override
    public List<Device> ConverListDtoToDivice(List<DeviceDto> device) {
        if ( device == null ) {
            return null;
        }

        List<Device> list = new ArrayList<Device>( device.size() );
        for ( DeviceDto deviceDto : device ) {
            list.add( convert( deviceDto ) );
        }

        return list;
    }

    @Override
    public List<DeviceDto> ConverListDeviceToDto(List<Device> device) {
        if ( device == null ) {
            return null;
        }

        List<DeviceDto> list = new ArrayList<DeviceDto>( device.size() );
        for ( Device device1 : device ) {
            list.add( convert( device1 ) );
        }

        return list;
    }
}
