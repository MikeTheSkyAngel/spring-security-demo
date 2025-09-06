package com.mx.skyangel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/balances")
public class BalanceController {

    @GetMapping
    public Map<String, String> balances() {
        // TODO: Business logic to retrieve balances would go here
        return Collections.singletonMap("message", "Balances");
    }

}
