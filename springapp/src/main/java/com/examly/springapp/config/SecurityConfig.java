package com.examly.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for development
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()  // Allow Swagger
                .requestMatchers("/public/**").permitAll() // Allow public endpoints
                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict to ADMIN role
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // Restrict to USER & ADMIN
                .anyRequest().authenticated() // Everything else requires authentication
            )
            .formLogin(Customizer.withDefaults()) // Enable default form login
            .httpBasic(Customizer.withDefaults()); // Enable basic authentication
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
