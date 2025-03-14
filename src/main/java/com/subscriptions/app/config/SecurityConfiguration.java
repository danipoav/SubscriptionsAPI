package com.subscriptions.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                // El authentication provider es un metodo ya implementado pero que en
                // Application config lo configuramos para que nos devuleva el usurio de la bbdd
                // y la contraseña encriptada
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Rutas públicas
                        .anyRequest().authenticated());

        return http.build();
    }
    // Lo que hago aqui es que basicamente spring tiene una funcion que intercepta
    // las llamadas http y pues para llegar a tu controlador primero tiene que pasar
    // una serie de filtros que en este caso le estoy diciendo que antes de llegar
    // al controlador tiene que ver si el usurio esta autenticado y sino devuelve
    // una llamada http 401 unautorized y si pasa y esta autenticado accedera a la
    // peticion que etsba haciendo en el controlador
}
