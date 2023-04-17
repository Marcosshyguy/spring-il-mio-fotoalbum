package com.project.photographer.security;

import com.project.photographer.models.User;
import com.project.photographer.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DbUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        if(user.isPresent()){
            return new DbUserDetails(user.get());
        }
        else{
            throw new UsernameNotFoundException(username + " not found");
        }
    }
}
