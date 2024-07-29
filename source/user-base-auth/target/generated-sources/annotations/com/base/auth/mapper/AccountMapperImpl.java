package com.base.auth.mapper;

import com.base.auth.dto.account.AccountAutoCompleteDto;
import com.base.auth.dto.account.AccountDto;
import com.base.auth.form.user.SignUpUserForm;
import com.base.auth.form.user.UpdateUserForm;
import com.base.auth.model.Account;
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
public class AccountMapperImpl implements AccountMapper {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public AccountDto fromAccountToDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setId( account.getId() );
        accountDto.setKind( account.getKind() );
        accountDto.setUsername( account.getUsername() );
        accountDto.setPhone( account.getPhone() );
        accountDto.setEmail( account.getEmail() );
        accountDto.setFullName( account.getFullName() );
        accountDto.setGroup( groupMapper.fromEntityToGroupDto( account.getGroup() ) );
        accountDto.setLastLogin( account.getLastLogin() );
        accountDto.setAvatar( account.getAvatarPath() );
        accountDto.setIsSuperAdmin( account.getIsSuperAdmin() );

        return accountDto;
    }

    @Override
    public AccountAutoCompleteDto fromAccountToAutoCompleteDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountAutoCompleteDto accountAutoCompleteDto = new AccountAutoCompleteDto();

        if ( account.getId() != null ) {
            accountAutoCompleteDto.setId( account.getId() );
        }
        accountAutoCompleteDto.setAvatarPath( account.getAvatarPath() );
        accountAutoCompleteDto.setFullName( account.getFullName() );

        return accountAutoCompleteDto;
    }

    @Override
    public List<AccountAutoCompleteDto> convertAccountToAutoCompleteDto(List<Account> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountAutoCompleteDto> list1 = new ArrayList<AccountAutoCompleteDto>( list.size() );
        for ( Account account : list ) {
            list1.add( accountToAccountAutoCompleteDto( account ) );
        }

        return list1;
    }

    @Override
    public Account fromSignUpUserToAccount(SignUpUserForm signUpUserForm) {
        if ( signUpUserForm == null ) {
            return null;
        }

        Account account = new Account();

        account.setPhone( signUpUserForm.getPhone() );
        account.setEmail( signUpUserForm.getEmail() );
        account.setFullName( signUpUserForm.getFullName() );
        account.setAvatarPath( signUpUserForm.getAvatarPath() );

        return account;
    }

    @Override
    public void fromUpdateUserFormToEntity(UpdateUserForm updateUserForm, Account account) {
        if ( updateUserForm == null ) {
            return;
        }

        if ( updateUserForm.getPhone() != null ) {
            account.setPhone( updateUserForm.getPhone() );
        }
        if ( updateUserForm.getEmail() != null ) {
            account.setEmail( updateUserForm.getEmail() );
        }
        if ( updateUserForm.getFullName() != null ) {
            account.setFullName( updateUserForm.getFullName() );
        }
        if ( updateUserForm.getAvatarPath() != null ) {
            account.setAvatarPath( updateUserForm.getAvatarPath() );
        }
    }

    protected AccountAutoCompleteDto accountToAccountAutoCompleteDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountAutoCompleteDto accountAutoCompleteDto = new AccountAutoCompleteDto();

        if ( account.getId() != null ) {
            accountAutoCompleteDto.setId( account.getId() );
        }
        accountAutoCompleteDto.setFullName( account.getFullName() );
        accountAutoCompleteDto.setAvatarPath( account.getAvatarPath() );

        return accountAutoCompleteDto;
    }
}
