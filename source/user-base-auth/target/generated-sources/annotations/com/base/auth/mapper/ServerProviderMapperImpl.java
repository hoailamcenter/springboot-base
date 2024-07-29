package com.base.auth.mapper;

import com.base.auth.dto.provider.ServerProviderDto;
import com.base.auth.form.provider.CreateServerProviderForm;
import com.base.auth.form.provider.UpdateServerProviderForm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T11:08:04+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ServerProviderMapperImpl implements ServerProviderMapper {

    @Override
    public ServerProvider fromCreateServerProviderFormToEntity(CreateServerProviderForm createServerProviderForm) {
        if ( createServerProviderForm == null ) {
            return null;
        }

        ServerProvider serverProvider = new ServerProvider();

        serverProvider.setUrl( createServerProviderForm.getUrl() );
        serverProvider.setMaxTenant( createServerProviderForm.getMaxTenant() );
        serverProvider.setMySqlJdbcUrl( createServerProviderForm.getMySqlJdbcUrl() );
        serverProvider.setMySqlRootUser( createServerProviderForm.getMySqlRootUser() );
        serverProvider.setName( createServerProviderForm.getName() );
        serverProvider.setDriverClassName( createServerProviderForm.getDriverClassName() );
        serverProvider.setMySqlRootPassword( createServerProviderForm.getMySqlRootPassword() );

        return serverProvider;
    }

    @Override
    public void fromUpdateFormToEntity(UpdateServerProviderForm updateServerProviderForm, ServerProvider serverProvider) {
        if ( updateServerProviderForm == null ) {
            return;
        }

        serverProvider.setMaxTenant( updateServerProviderForm.getMaxTenant() );
        serverProvider.setMySqlJdbcUrl( updateServerProviderForm.getMySqlJdbcUrl() );
        serverProvider.setMySqlRootUser( updateServerProviderForm.getMySqlRootUser() );
        serverProvider.setDriverClassName( updateServerProviderForm.getDriverClassName() );
        serverProvider.setMySqlRootPassword( updateServerProviderForm.getMySqlRootPassword() );
    }

    @Override
    public ServerProviderDto fromEntityToServerProviderDto(ServerProvider serverProvider) {
        if ( serverProvider == null ) {
            return null;
        }

        ServerProviderDto serverProviderDto = new ServerProviderDto();

        serverProviderDto.setMaxTenant( serverProvider.getMaxTenant() );
        serverProviderDto.setMySqlJdbcUrl( serverProvider.getMySqlJdbcUrl() );
        serverProviderDto.setMySqlRootUser( serverProvider.getMySqlRootUser() );
        serverProviderDto.setName( serverProvider.getName() );
        serverProviderDto.setDriverClassName( serverProvider.getDriverClassName() );
        serverProviderDto.setCurrentTenantCount( serverProvider.getCurrentTenantCount() );
        serverProviderDto.setId( serverProvider.getId() );
        serverProviderDto.setMySqlRootPassword( serverProvider.getMySqlRootPassword() );
        serverProviderDto.setUrl( serverProvider.getUrl() );

        return serverProviderDto;
    }

    @Override
    public List<ServerProviderDto> fromEntityToServerProviderDtoList(List<ServerProvider> serverProviderList) {
        if ( serverProviderList == null ) {
            return null;
        }

        List<ServerProviderDto> list = new ArrayList<ServerProviderDto>( serverProviderList.size() );
        for ( ServerProvider serverProvider : serverProviderList ) {
            list.add( fromEntityToServerProviderDto( serverProvider ) );
        }

        return list;
    }

    @Override
    public ServerProviderDto fromEntityToPublicServerProviderDto(ServerProvider serverProvider) {
        if ( serverProvider == null ) {
            return null;
        }

        ServerProviderDto serverProviderDto = new ServerProviderDto();

        serverProviderDto.setId( serverProvider.getId() );
        serverProviderDto.setUrl( serverProvider.getUrl() );

        return serverProviderDto;
    }
}
