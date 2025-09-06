package com.mx.skyangel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/v1/accounts")
public class AccountController {

    @GetMapping
    public Map<String, String> accounts() {
        // TODO: Business logic to retrieve accounts would go here
        return Map.of("message", "Accounts");
    }
    
}
