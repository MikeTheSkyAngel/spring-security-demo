package com.mx.skyangel.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SimplePasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return String.valueOf(rawPassword.toString().hashCode());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        var encodedRawPassword = String.valueOf(rawPassword.toString().hashCode());
        return encodedPassword.equals(encodedRawPassword);
    }

}
