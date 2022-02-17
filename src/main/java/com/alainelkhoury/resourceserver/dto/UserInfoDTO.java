package com.alainelkhoury.resourceserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class UserInfoDTO {
    private final Boolean active;
    private final Integer exp;
    private final String username;
    private final List<String> authorities;
    private final String clientId;
    private final List<String> scope;

    public UserInfoDTO(@JsonProperty(value = "active") Boolean active,
                       @JsonProperty(value = "exp") Integer exp,
                       @JsonProperty(value = "user_name") String username,
                       @JsonProperty(value = "authorities") List<String> authorities,
                       @JsonProperty(value = "client_id") String clientId,
                       @JsonProperty(value = "scope") List<String> scope) {
        this.active = active;
        this.exp = exp;
        this.username = username;
        this.authorities = authorities;
        this.clientId = clientId;
        this.scope = scope;
    }
}