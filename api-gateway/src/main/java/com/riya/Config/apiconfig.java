package com.riya.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebFluxSecurity
public class apiconfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 // any request comming with /register and /login allow it other than it will
        // triger the keyclock endpoint of validation if the request has the valid
        // token it will reach the desired endpoint of the server
           http
               .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req.requestMatchers("/eureka/**")
                                .permitAll()
                                .anyRequest().authenticated()
                );
           http.oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> httpSecurityOAuth2ResourceServerConfigurer
                   .jwt(jwtConfigurer ->jwtConfigurer.jwkSetUri("http://localhost:8180/realms/springboot-microservices/protocol/openid-connect/certs")));

           http.
                sessionManagement(session->session.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS));
           return http.build();

    }
}
