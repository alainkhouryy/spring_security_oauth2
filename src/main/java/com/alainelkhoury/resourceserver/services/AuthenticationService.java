package com.alainelkhoury.resourceserver.services;

import com.alainelkhoury.resourceserver.dto.UserInfoDTO;

public interface AuthenticationService {
    UserInfoDTO introspect(String token);
}
