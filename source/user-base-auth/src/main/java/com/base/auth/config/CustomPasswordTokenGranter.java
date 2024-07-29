package com.base.auth.config;

import com.base.auth.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.HashMap;
import java.util.Map;

public class CustomPasswordTokenGranter extends ResourceOwnerPasswordTokenGranter {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;

    public CustomPasswordTokenGranter(AuthenticationManager authenticationManager,
                                      AuthorizationServerTokenServices tokenServices,
                                      ClientDetailsService clientDetailsService,
                                      OAuth2RequestFactory requestFactory,
                                      UserServiceImpl userService) {
        super(authenticationManager, tokenServices, clientDetailsService, requestFactory);
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new HashMap<>(tokenRequest.getRequestParameters());
        String username = parameters.get("username");
        String password = parameters.get("password");
        if (username == null){
            String email = parameters.get("email");
            UserDetails userDetails = userService.loadUserByEmail(email);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, password);
            authentication = authenticationManager.authenticate(authentication);

            OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
            return new OAuth2Authentication(storedOAuth2Request, authentication);
        }
        UserDetails userDetails = userService.loadUserByUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, password);
        authentication = authenticationManager.authenticate(authentication);

        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, authentication);
    }
}
