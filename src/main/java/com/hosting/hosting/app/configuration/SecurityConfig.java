package com.hosting.hosting.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hosting.hosting.app.utils.AuthEntryPointJwt;
import com.hosting.hosting.app.utils.AuthTokenFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    
    private AuthEntryPointJwt unAuthorizedHandler;

    SecurityConfig(AuthEntryPointJwt unAuthorizedHandler){
        this.unAuthorizedHandler = unAuthorizedHandler;
    }
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf ->csrf.disable()).authorizeHttpRequests((requests) -> requests
        .requestMatchers("/login").permitAll()
        .anyRequest().authenticated()
        ).addFilterBefore((Filter) authenticationJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session -> session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions
                        .sameOrigin()))
        .exceptionHandling(exception -> exception.authenticationEntryPoint((AuthenticationEntryPoint) unAuthorizedHandler));;
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
}
