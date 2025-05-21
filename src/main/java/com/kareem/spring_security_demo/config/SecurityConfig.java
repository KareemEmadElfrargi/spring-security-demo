package com.kareem.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marks this class as a configuration class for Spring
@EnableWebSecurity // Enables Spring Security for the application
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // ❌ Disable CSRF protection (common for stateless APIs or when using token-based auth)
        http.csrf(AbstractHttpConfigurer::disable);

        // 🔐 Require authentication for every request (no public endpoints)
        http.authorizeHttpRequests(request -> {
            request.anyRequest().authenticated();
        });

        // ✅ Enable default form-based login (Spring provides a built-in login page)
        //http.formLogin(Customizer.withDefaults());

        // ✅ Enable HTTP Basic authentication (useful for testing with Postman or curl)
        http.httpBasic(Customizer.withDefaults());

        // 🚫 Disable session creation — treat every request independently (stateless)
        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        // 🔧 Build and return the configured security filter chain
        return http.build();
    }
}
