package com.mx.skyangel.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class ApikeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER_NAME = "X-API-KEY";
    private static final String TEST_API_KEY = "myKey123";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {
        try {
            final var apiKeyOptional = Optional.of(request.getHeader(API_KEY_HEADER_NAME));
            final var apiKey = apiKeyOptional.orElseThrow(() -> new BadCredentialsException("Missing API Key"));

            if (!apiKey.equals(TEST_API_KEY)) {
                throw new BadCredentialsException("Invalid API Key");
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Invalid API Key", e);
            throw new BadCredentialsException("Invalid API Key");
        }
    }

}
