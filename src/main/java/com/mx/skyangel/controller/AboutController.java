package com.mx.skyangel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/about")
public class AboutController {

    @GetMapping
    public Map<String, String> about() {
        // TODO: Business logic to retrieve about information would go here
        return Collections.singletonMap("message", "About");
    }

}
