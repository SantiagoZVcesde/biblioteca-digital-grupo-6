package com.grupo6.biblioteca_digital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desactivar CSRF para permitir peticiones POST desde el frontend sin tokens mutation
            .csrf(csrf -> csrf.disable())
            
            // 2. Manejo de sesión Stateless (sin estado) ideal para APIs REST
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // 3. Configuración de las reglas de autorización
            .authorizeHttpRequests(auth -> auth
                // Rutas públicas de documentación, Swagger y Actuator
                .requestMatchers(
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/docs/**",
                    "/actuator/**"
                ).permitAll()

                // Permitir la creación de nuevos clientes de forma pública (para que se puedan registrar)
                .requestMatchers(HttpMethod.POST, "/api/v1/clientes").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/clientes/registro").permitAll()

                // Consultas GET generales permitidas para usuarios autenticados con rol CLIENTE o ADMIN
                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("CLIENTE", "ADMIN")

                // Permitir que tanto CLIENTE como ADMIN puedan registrar sus préstamos y compras
                .requestMatchers(HttpMethod.POST, "/api/prestamos/**").hasAnyRole("CLIENTE", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/compras/**").hasAnyRole("CLIENTE", "ADMIN")

                // Restringir la gestión avanzada (crear libros/categorías, editar, eliminar) SOLO para ADMIN
                .requestMatchers(HttpMethod.POST, "/api/libros/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/categorias/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")

                // Cualquier otra petición requiere autenticación por defecto
                .anyRequest().authenticated()
            )
            
            // 4. Habilitar autenticación básica HTTP (Basic Auth) para los usuarios registrados
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}