/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author dell
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Rutas permitidas sin autenticación
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
            .and()
            .formLogin()
                .loginPage("/login")  // Página personalizada para el inicio de sesión
                .defaultSuccessUrl("/home", true)  // Redirección al éxito de login
                .permitAll()
            .and()
            .logout()
                .permitAll();

        return http.build();
    }
}