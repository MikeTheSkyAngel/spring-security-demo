package com.mx.skyangel.filter;

import com.mx.skyangel.service.JwtService;
import com.mx.skyangel.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final JwtUserDetailsService jwtUserDetailsService;

    private static final String AUTH_HEADER = "Authorization";
    private static final String AUTH_PREFIX = "Bearer";


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final var requestTokenHeader = request.getHeader(AUTH_HEADER);
        String username;
        String token;

        if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith(AUTH_PREFIX)) {
            token = requestTokenHeader.substring(AUTH_PREFIX.length() + 1);

            try {
                username = jwtService.getUsernameFromToken(token);

                if (Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                    final var userDetails = jwtUserDetailsService.loadUserByUsername(username);

                    if (jwtService.isValidToken(token, userDetails)) {
                        var authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(userDetails);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            } catch (ExpiredJwtException e) {
                log.warn(e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
