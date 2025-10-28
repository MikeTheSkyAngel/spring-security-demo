package com.mx.skyangel.service;

import com.mx.skyangel.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).map(userEntity -> {
            final var authorities = userEntity.getRoles()
                    .stream()
                    .map(auth -> new SimpleGrantedAuthority(auth.getName()))
                    .toList();
            return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

}
