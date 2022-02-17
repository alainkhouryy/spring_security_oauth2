package com.alainelkhoury.resourceserver.introspectors;

import com.alainelkhoury.resourceserver.dto.UserInfoDTO;
import com.alainelkhoury.resourceserver.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomOpaqueTokenIntrospector implements OpaqueTokenIntrospector {

    private final AuthenticationService authenticationService;

    @Autowired
    public CustomOpaqueTokenIntrospector(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        UserInfoDTO userInfoDTO = authenticationService.introspect(token);

        Collection<GrantedAuthority> authorities = userInfoDTO
                .getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("USER_INFO_DTO", userInfoDTO);

        return new OAuth2IntrospectionAuthenticatedPrincipal(attributes, authorities);
    }
}
