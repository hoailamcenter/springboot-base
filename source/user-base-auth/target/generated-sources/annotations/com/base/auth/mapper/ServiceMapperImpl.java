package com.base.auth.mapper;

import com.base.auth.dto.service.ServiceDto;
import com.base.auth.dto.service.ServicePublicDto;
import com.base.auth.form.service.CreateServiceForm;
import com.base.auth.form.service.UpdateServiceByCustomerForm;
import com.base.auth.form.service.UpdateServiceForm;
import com.base.auth.model.Account;
import com.base.auth.model.Service;
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
public class ServiceMapperImpl implements ServiceMapper {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public ServiceDto fromServiceToDto(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceDto serviceDto = new ServiceDto();

        serviceDto.setId( service.getId() );
        serviceDto.setServiceName( service.getServiceName() );
        serviceDto.setLogoPath( service.getLogoPath() );
        serviceDto.setBannerPath( service.getBannerPath() );
        serviceDto.setHotline( service.getHotline() );
        serviceDto.setSettings( service.getSettings() );
        serviceDto.setLang( service.getLang() );
        serviceDto.setStatus( service.getStatus() );
        serviceDto.setAccountDto( accountMapper.fromAccountToDto( service.getAccount() ) );

        return serviceDto;
    }

    @Override
    public ServicePublicDto fromServiceToPublicDto(Service service) {
        if ( service == null ) {
            return null;
        }

        ServicePublicDto servicePublicDto = new ServicePublicDto();

        servicePublicDto.setId( service.getId() );
        servicePublicDto.setServiceName( service.getServiceName() );
        servicePublicDto.setLogoPath( service.getLogoPath() );
        servicePublicDto.setBannerPath( service.getBannerPath() );
        servicePublicDto.setHotline( service.getHotline() );
        servicePublicDto.setSettings( service.getSettings() );
        servicePublicDto.setLang( service.getLang() );

        return servicePublicDto;
    }

    @Override
    public Service fromServiceFromToEntity(CreateServiceForm form) {
        if ( form == null ) {
            return null;
        }

        Service service = new Service();

        service.setServiceName( form.getServiceName() );
        service.setLogoPath( form.getLogoPath() );
        service.setBannerPath( form.getBannerPath() );
        service.setHotline( form.getHotline() );
        service.setSettings( form.getSettings() );
        service.setLang( form.getLang() );
        if ( form.getStatus() != null ) {
            service.setStatus( form.getStatus() );
        }

        return service;
    }

    @Override
    public void fromAdminUpdateFormToEntity(UpdateServiceForm updateServiceForm, Service service) {
        if ( updateServiceForm == null ) {
            return;
        }

        if ( service.getAccount() == null ) {
            service.setAccount( new Account() );
        }
        updateServiceFormToAccount( updateServiceForm, service.getAccount() );
        if ( updateServiceForm.getServiceName() != null ) {
            service.setServiceName( updateServiceForm.getServiceName() );
        }
        if ( updateServiceForm.getLogoPath() != null ) {
            service.setLogoPath( updateServiceForm.getLogoPath() );
        }
        if ( updateServiceForm.getBannerPath() != null ) {
            service.setBannerPath( updateServiceForm.getBannerPath() );
        }
        if ( updateServiceForm.getHotline() != null ) {
            service.setHotline( updateServiceForm.getHotline() );
        }
        if ( updateServiceForm.getSettings() != null ) {
            service.setSettings( updateServiceForm.getSettings() );
        }
        if ( updateServiceForm.getLang() != null ) {
            service.setLang( updateServiceForm.getLang() );
        }
        if ( updateServiceForm.getStatus() != null ) {
            service.setStatus( updateServiceForm.getStatus() );
        }
        if ( updateServiceForm.getTenantId() != null ) {
            service.setTenantId( updateServiceForm.getTenantId() );
        }
    }

    @Override
    public void fromCustomerUpdateFormToEntity(UpdateServiceByCustomerForm updateServiceByCustomerForm, Service service) {
        if ( updateServiceByCustomerForm == null ) {
            return;
        }

        if ( updateServiceByCustomerForm.getServiceName() != null ) {
            service.setServiceName( updateServiceByCustomerForm.getServiceName() );
        }
        if ( updateServiceByCustomerForm.getBannerPath() != null ) {
            service.setBannerPath( updateServiceByCustomerForm.getBannerPath() );
        }
        if ( updateServiceByCustomerForm.getHotline() != null ) {
            service.setHotline( updateServiceByCustomerForm.getHotline() );
        }
        if ( updateServiceByCustomerForm.getSettings() != null ) {
            service.setSettings( updateServiceByCustomerForm.getSettings() );
        }
    }

    @Override
    public List<ServiceDto> fromEntityToCustomerDtoList(List<Service> list) {
        if ( list == null ) {
            return null;
        }

        List<ServiceDto> list1 = new ArrayList<ServiceDto>( list.size() );
        for ( Service service : list ) {
            list1.add( fromServiceToDto( service ) );
        }

        return list1;
    }

    protected void updateServiceFormToAccount(UpdateServiceForm updateServiceForm, Account mappingTarget) {
        if ( updateServiceForm == null ) {
            return;
        }

        if ( updateServiceForm.getFullName() != null ) {
            mappingTarget.setFullName( updateServiceForm.getFullName() );
        }
        if ( updateServiceForm.getPhone() != null ) {
            mappingTarget.setPhone( updateServiceForm.getPhone() );
        }
    }
}
