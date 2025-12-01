package com.poly.server.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // Giong class J4: extends WebFilter

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // logic
        http
                .csrf(csrt -> csrt.disable()) // tat bao ve trinh duyet khi chung ta test
                .authorizeHttpRequests(auth -> auth
                        // check tat ca cac quyen deu truy cap duoc (premit all)
                        .requestMatchers("/public/**").permitAll() // cho phep tat ca deu truy cap duoc
                        .requestMatchers("/api/user/**").hasRole("USER")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated() // Cac request con lai deu phai check dang nhap(authen)
                ).httpBasic(Customizer.withDefaults()); // Su dung http basic
        return http.build();
    }

    // giup authen => check authen
    @Bean
    public AuthenticationManager authentication(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // ma hoa mat khau
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
