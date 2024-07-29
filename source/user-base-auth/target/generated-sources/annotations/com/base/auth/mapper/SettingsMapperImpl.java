package com.base.auth.mapper;

import com.base.auth.dto.settings.SettingsAutoCompleteDto;
import com.base.auth.dto.settings.SettingsDto;
import com.base.auth.form.settings.CreateSettingsForm;
import com.base.auth.form.settings.UpdateSettingsForm;
import com.base.auth.model.Settings;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-26T11:52:41+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class SettingsMapperImpl implements SettingsMapper {

    @Override
    public Settings fromCreateSettingsFormToEntity(CreateSettingsForm createSettingsForm) {
        if ( createSettingsForm == null ) {
            return null;
        }

        Settings settings = new Settings();

        settings.setSettingKey( createSettingsForm.getSettingKey() );
        settings.setSettingValue( createSettingsForm.getSettingValue() );
        settings.setGroupName( createSettingsForm.getGroupName() );
        settings.setDescription( createSettingsForm.getDescription() );
        settings.setIsSystem( createSettingsForm.getIsSystem() );
        settings.setIsEditable( createSettingsForm.getIsEditable() );
        if ( createSettingsForm.getStatus() != null ) {
            settings.setStatus( createSettingsForm.getStatus() );
        }

        return settings;
    }

    @Override
    public void fromUpdateSettingsFormToEntity(UpdateSettingsForm updateSettingsForm, Settings settings) {
        if ( updateSettingsForm == null ) {
            return;
        }

        if ( updateSettingsForm.getSettingValue() != null ) {
            settings.setSettingValue( updateSettingsForm.getSettingValue() );
        }
        if ( updateSettingsForm.getDescription() != null ) {
            settings.setDescription( updateSettingsForm.getDescription() );
        }
        if ( updateSettingsForm.getStatus() != null ) {
            settings.setStatus( updateSettingsForm.getStatus() );
        }
    }

    @Override
    public SettingsDto fromEntityToSettingsDto(Settings settings) {
        if ( settings == null ) {
            return null;
        }

        SettingsDto settingsDto = new SettingsDto();

        settingsDto.setId( settings.getId() );
        settingsDto.setSettingKey( settings.getSettingKey() );
        settingsDto.setSettingValue( settings.getSettingValue() );
        settingsDto.setGroupName( settings.getGroupName() );
        settingsDto.setDescription( settings.getDescription() );
        settingsDto.setIsSystem( settings.getIsSystem() );
        settingsDto.setIsEditable( settings.getIsEditable() );
        settingsDto.setStatus( settings.getStatus() );
        if ( settings.getModifiedDate() != null ) {
            settingsDto.setModifiedDate( LocalDateTime.ofInstant( settings.getModifiedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        if ( settings.getCreatedDate() != null ) {
            settingsDto.setCreatedDate( LocalDateTime.ofInstant( settings.getCreatedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return settingsDto;
    }

    @Override
    public List<SettingsDto> fromEntityListToSettingsDtoList(List<Settings> settings) {
        if ( settings == null ) {
            return null;
        }

        List<SettingsDto> list = new ArrayList<SettingsDto>( settings.size() );
        for ( Settings settings1 : settings ) {
            list.add( fromEntityToSettingsDto( settings1 ) );
        }

        return list;
    }

    @Override
    public SettingsAutoCompleteDto fromEntityToSettingsAutoCompleteDto(Settings settings) {
        if ( settings == null ) {
            return null;
        }

        SettingsAutoCompleteDto settingsAutoCompleteDto = new SettingsAutoCompleteDto();

        settingsAutoCompleteDto.setId( settings.getId() );
        settingsAutoCompleteDto.setSettingKey( settings.getSettingKey() );
        settingsAutoCompleteDto.setGroupName( settings.getGroupName() );

        return settingsAutoCompleteDto;
    }

    @Override
    public List<SettingsAutoCompleteDto> fromEntityListToSettingsAutoCompleteDtoList(List<Settings> settings) {
        if ( settings == null ) {
            return null;
        }

        List<SettingsAutoCompleteDto> list = new ArrayList<SettingsAutoCompleteDto>( settings.size() );
        for ( Settings settings1 : settings ) {
            list.add( fromEntityToSettingsAutoCompleteDto( settings1 ) );
        }

        return list;
    }
}
