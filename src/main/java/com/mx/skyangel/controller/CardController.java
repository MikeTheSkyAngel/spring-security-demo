package com.mx.skyangel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/v1/cards")
public class CardController {

    @GetMapping
    public Map<String, String> cards() {
        // TODO: Business logic to retrieve cards would go here
        return Map.of("message", "Cards");
    }

}
