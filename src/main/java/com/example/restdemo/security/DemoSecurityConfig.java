package com.example.restdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ram = User.builder()
                .username("ram")
                .password("{noop}ram@123")
                .roles("EMPLOYEE")
                .build();

        UserDetails siya = User.builder()
                .username("siya")
                .password("{noop}siya@123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails krish = User.builder()
                .username("krish")
                .password("{noop}krish@123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ram, siya, krish);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        // Updated way of enabling HTTP Basic Auth
        http.httpBasic(basic -> {});

        // Updated way of disabling CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}