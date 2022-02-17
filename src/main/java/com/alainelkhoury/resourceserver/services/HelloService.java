package com.alainelkhoury.resourceserver.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @PreAuthorize("hasRole('ADMIN')")
    public String sayHello() {
        return "Hello!";
    }
}
