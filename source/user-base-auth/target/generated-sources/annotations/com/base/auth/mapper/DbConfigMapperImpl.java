package com.base.auth.mapper;

import com.base.auth.dto.db.config.DbConfigDto;
import com.base.auth.form.db.config.CreateDbConfigForm;
import com.base.auth.form.db.config.UpdateDbConfigForm;
import com.base.auth.model.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T11:08:04+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class DbConfigMapperImpl implements DbConfigMapper {

    @Autowired
    private ServerProviderMapper serverProviderMapper;

    @Override
    public DbConfig fromCreateFormToEntity(CreateDbConfigForm createDbConfigForm) {
        if ( createDbConfigForm == null ) {
            return null;
        }

        DbConfig dbConfig = new DbConfig();

        dbConfig.setService( createDbConfigFormToService( createDbConfigForm ) );
        dbConfig.setMaxConnection( createDbConfigForm.getMaxConnection() );
        dbConfig.setPassword( createDbConfigForm.getPassword() );
        dbConfig.setDriverClassName( createDbConfigForm.getDriverClassName() );
        dbConfig.setInitialize( createDbConfigForm.isInitialize() );
        dbConfig.setUrl( createDbConfigForm.getUrl() );
        dbConfig.setUsername( createDbConfigForm.getUsername() );

        return dbConfig;
    }

    @Override
    public void fromUpdateFormToEntity(UpdateDbConfigForm updateDbConfigForm, DbConfig dbConfig) {
        if ( updateDbConfigForm == null ) {
            return;
        }

        if ( updateDbConfigForm.getMaxConnection() != null ) {
            dbConfig.setMaxConnection( updateDbConfigForm.getMaxConnection() );
        }
        dbConfig.setInitialize( updateDbConfigForm.isInitialize() );
    }

    @Override
    public DbConfigDto fromEntityToDto(DbConfig dbConfig) {
        if ( dbConfig == null ) {
            return null;
        }

        DbConfigDto dbConfigDto = new DbConfigDto();

        dbConfigDto.setMaxConnection( dbConfig.getMaxConnection() );
        dbConfigDto.setPassword( dbConfig.getPassword() );
        dbConfigDto.setName( dbConfig.getName() );
        dbConfigDto.setDriverClassName( dbConfig.getDriverClassName() );
        dbConfigDto.setServerProviderDto( serverProviderMapper.fromEntityToServerProviderDto( dbConfig.getServerProvider() ) );
        dbConfigDto.setId( dbConfig.getId() );
        dbConfigDto.setInitialize( dbConfig.isInitialize() );
        dbConfigDto.setUrl( dbConfig.getUrl() );
        dbConfigDto.setUsername( dbConfig.getUsername() );

        return dbConfigDto;
    }

    @Override
    public List<DbConfigDto> fromEntityListToDtoList(List<DbConfig> dbConfigList) {
        if ( dbConfigList == null ) {
            return null;
        }

        List<DbConfigDto> list = new ArrayList<DbConfigDto>( dbConfigList.size() );
        for ( DbConfig dbConfig : dbConfigList ) {
            list.add( fromEntityToDto( dbConfig ) );
        }

        return list;
    }

    @Override
    public DbConfigDto fromEntityToDetailDto(DbConfig dbConfig) {
        if ( dbConfig == null ) {
            return null;
        }

        DbConfigDto dbConfigDto = new DbConfigDto();

        dbConfigDto.setName( dbConfig.getName() );
        dbConfigDto.setServerProviderDto( serverProviderMapper.fromEntityToPublicServerProviderDto( dbConfig.getServerProvider() ) );
        dbConfigDto.setId( dbConfig.getId() );
        dbConfigDto.setInitialize( dbConfig.isInitialize() );

        return dbConfigDto;
    }

    protected Service createDbConfigFormToService(CreateDbConfigForm createDbConfigForm) {
        if ( createDbConfigForm == null ) {
            return null;
        }

        Service service = new Service();

        service.setId( createDbConfigForm.getServiceId() );

        return service;
    }
}
