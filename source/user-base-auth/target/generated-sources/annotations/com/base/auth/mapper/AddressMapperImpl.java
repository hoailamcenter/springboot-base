package com.base.auth.mapper;

import com.base.auth.dto.address.AddressAdminDto;
import com.base.auth.dto.address.AddressDto;
import com.base.auth.form.address.CreateAddressForm;
import com.base.auth.form.address.UpdateAddressForm;
import com.base.auth.model.Address;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-26T11:52:41+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Autowired
    private NationMapper nationMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Address fromCreateAddressFormToEntity(CreateAddressForm createAddressForm) {
        if ( createAddressForm == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddress( createAddressForm.getAddress() );
        address.setName( createAddressForm.getName() );
        address.setPhone( createAddressForm.getPhone() );
        if ( createAddressForm.getStatus() != null ) {
            address.setStatus( createAddressForm.getStatus() );
        }

        return address;
    }

    @Override
    public void fromUpdateAddressFormToEntity(UpdateAddressForm updateAddressForm, Address address) {
        if ( updateAddressForm == null ) {
            return;
        }

        if ( updateAddressForm.getAddress() != null ) {
            address.setAddress( updateAddressForm.getAddress() );
        }
        if ( updateAddressForm.getName() != null ) {
            address.setName( updateAddressForm.getName() );
        }
        if ( updateAddressForm.getPhone() != null ) {
            address.setPhone( updateAddressForm.getPhone() );
        }
        if ( updateAddressForm.getStatus() != null ) {
            address.setStatus( updateAddressForm.getStatus() );
        }
    }

    @Override
    public AddressDto fromEntityToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setAddress( address.getAddress() );
        addressDto.setWardInfo( nationMapper.fromEntityToAutoCompleteDto( address.getWard() ) );
        addressDto.setDistrictInfo( nationMapper.fromEntityToAutoCompleteDto( address.getDistrict() ) );
        addressDto.setProvinceInfo( nationMapper.fromEntityToAutoCompleteDto( address.getProvince() ) );
        addressDto.setName( address.getName() );
        addressDto.setPhone( address.getPhone() );

        return addressDto;
    }

    @Override
    public AddressAdminDto fromEntityToAddressAdminDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressAdminDto addressAdminDto = new AddressAdminDto();

        addressAdminDto.setId( address.getId() );
        addressAdminDto.setAddress( address.getAddress() );
        addressAdminDto.setWardInfo( nationMapper.fromEntityToAdminDto( address.getWard() ) );
        addressAdminDto.setDistrictInfo( nationMapper.fromEntityToAdminDto( address.getDistrict() ) );
        addressAdminDto.setProvinceInfo( nationMapper.fromEntityToAdminDto( address.getProvince() ) );
        addressAdminDto.setName( address.getName() );
        addressAdminDto.setPhone( address.getPhone() );
        addressAdminDto.setStatus( address.getStatus() );
        if ( address.getModifiedDate() != null ) {
            addressAdminDto.setModifiedDate( LocalDateTime.ofInstant( address.getModifiedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        if ( address.getCreatedDate() != null ) {
            addressAdminDto.setCreatedDate( LocalDateTime.ofInstant( address.getCreatedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        addressAdminDto.setUserInfo( userMapper.fromEntityToUserDto( address.getUser() ) );

        return addressAdminDto;
    }

    @Override
    public List<AddressAdminDto> fromEntityToAddressAdminDtoList(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressAdminDto> list = new ArrayList<AddressAdminDto>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( fromEntityToAddressAdminDto( address ) );
        }

        return list;
    }

    @Override
    public AddressDto fromEntityToAddressDtoAutoComplete(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setAddress( address.getAddress() );
        addressDto.setName( address.getName() );
        addressDto.setPhone( address.getPhone() );
        addressDto.setStatus( address.getStatus() );

        return addressDto;
    }

    @Override
    public List<AddressDto> fromEntityToAddressDtoAutoCompleteList(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( fromEntityToAddressDtoAutoComplete( address ) );
        }

        return list;
    }
}
