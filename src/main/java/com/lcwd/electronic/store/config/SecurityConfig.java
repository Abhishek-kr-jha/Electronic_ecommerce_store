package com.lcwd.electronic.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

// websecurityConfigurerAdapter -> is deprecqated

    @Bean
    public UserDetailsService userDetailsService(){
        // users create
        UserDetails normal = User.builder()
                .username("Abhishek")
                .password(passwordEncoder().encode("abhishekjha"))
                .roles("NORMAL")
                .build();

        UserDetails admin = User.builder()
                .username("Kalyani")
                .password(passwordEncoder().encode("kalyani123"))
                .roles("ADMIN")
                .build();

//        InMemoryUserDetailsManager - is implementations class of userDetailservice

        return new InMemoryUserDetailsManager(normal, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
