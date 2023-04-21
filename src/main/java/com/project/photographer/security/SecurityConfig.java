package com.project.photographer.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    UserDetailsService userDetailsService() {return  new DbUserDetailsService();}

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
//                .requestMatchers("/photos/create", "/photos/edit", "/photos/edit/**", "/photos/delete/**").hasAuthority("ADMIN")
//                .requestMatchers("/", "/photos", "/photos/{id}").hasAnyAuthority("GUEST", "ADMIN")
//                .requestMatchers("/categories", "/categories/**").hasAuthority("ADMIN")
//                .requestMatchers("/messages", "/messages/delete/**").hasAuthority("ADMIN")
//                .requestMatchers("/api", "/api/**").permitAll()
                .requestMatchers("/**").permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).hasAnyAuthority("GUEST", "ADMIN")
                .and().formLogin().defaultSuccessUrl("/photos", true)
                .and().logout()
                .and().exceptionHandling();
        http.csrf().disable();
        return http.build();
    }
}
