package com.mx.skyangel.security;

import com.mx.skyangel.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserAccountDetails implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.accountRepository.findByUsername(username)
                .map(account -> {
                    var authorities = List.of(new SimpleGrantedAuthority(account.getRole()));
                    return new User(account.getUsername(), account.getPassword(), authorities);
                }).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
