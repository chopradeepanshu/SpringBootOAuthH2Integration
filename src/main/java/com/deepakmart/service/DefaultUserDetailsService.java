package com.deepakmart.service;

import com.deepakmart.entity.DeepakMartUsers;
import com.deepakmart.repository.AppUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

public class DefaultUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public DefaultUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<DeepakMartUsers> userEntity = appUserRepository.findById(username);

        if (userEntity.isPresent()) {
            final DeepakMartUsers appUser = userEntity.get();

            return new User(appUser.getUserEmail(),
                    passwordNoEncoding(appUser),
                    Collections.singletonList(new SimpleGrantedAuthority(appUser.getUserRole())));
        }

        return null;
    }

    private String passwordNoEncoding(DeepakMartUsers appUser) {
        return "{noop}" + appUser.getUserPass();
    }
}
