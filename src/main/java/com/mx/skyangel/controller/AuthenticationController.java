package com.mx.skyangel.controller;

import com.mx.skyangel.dto.JwtRequest;
import com.mx.skyangel.dto.JwtResponse;
import com.mx.skyangel.service.JwtService;
import com.mx.skyangel.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/token")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> createToken(@RequestBody JwtRequest request) {
        authenticate(request);

        final var userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());
        final var token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(JwtRequest request) {
        try {
            var authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException | DisabledException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
