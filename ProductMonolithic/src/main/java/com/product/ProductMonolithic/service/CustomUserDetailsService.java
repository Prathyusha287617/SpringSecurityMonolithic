package com.product.ProductMonolithic.service;

import com.product.ProductMonolithic.entity.AuthUser;
import com.product.ProductMonolithic.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthUserRepository authRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<AuthUser> authUser= authRepo.findByAuthName(username);
            // but we have return UserDetails and not authUser so copy all the authUser data into userdetails instance
            return authUser
                    .map((userInfo)->new CustomUserDetails(userInfo.getAuthName(), userInfo.getAuthPassword(), userInfo.getAllRoles()))
                    .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));

        }
}
