package com.alainelkhoury.resourceserver.controllers;

import com.alainelkhoury.resourceserver.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(BearerTokenAuthentication authentication) {
        return ResponseEntity.ok(helloService.sayHello());
    }

    @GetMapping("/foo")
    public ResponseEntity foo(BearerTokenAuthentication authentication) {
        return ResponseEntity.ok(authentication.getTokenAttributes().get("USER_INFO_DTO"));
    }

}
