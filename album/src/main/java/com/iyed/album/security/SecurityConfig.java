package com.iyed.album.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .csrf(csrf -> csrf.disable())
                                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                                        @Override
                                        public CorsConfiguration getCorsConfiguration(
                                                        @SuppressWarnings("null") HttpServletRequest request) {
                                                CorsConfiguration cors = new CorsConfiguration();
                                                cors.setAllowedOrigins(
                                                                Collections.singletonList("http://localhost:4200"));
                                                cors.setAllowedMethods(Collections.singletonList("*"));
                                                cors.setAllowedHeaders(Collections.singletonList("*"));
                                                cors.setExposedHeaders(Collections.singletonList("Authorization"));
                                                return cors;
                                        }
                                }))
                                .authorizeHttpRequests(requests -> requests
                                                // Albums endpoints
                                                .requestMatchers(HttpMethod.GET, "/api/all/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.GET, "/api/getbyid/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.PUT, "/api/updatealbum/**")
                                                .hasAuthority("ADMIN")
                                                .requestMatchers(HttpMethod.DELETE, "/api/delprod/**")
                                                .hasAuthority("ADMIN")

                                                // Images endpoints
                                                .requestMatchers(HttpMethod.POST, "/api/image/uploadImageAlb/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.POST, "/api/image/upload")
                                                .hasAuthority("ADMIN")
                                                .requestMatchers(HttpMethod.GET, "/api/image/getImagesAlb/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.GET, "/api/image/get/info/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.GET, "/api/image/load/**")
                                                .hasAnyAuthority("ADMIN", "USER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/image/delete/**")
                                                .hasAuthority("ADMIN")
                                                .requestMatchers(HttpMethod.PUT, "/api/image/update")
                                                .hasAuthority("ADMIN")

                                                // Other requests
                                                .anyRequest().authenticated())
                                .addFilterBefore(new JWTAuthorizationFilter(),
                                                UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }
}
