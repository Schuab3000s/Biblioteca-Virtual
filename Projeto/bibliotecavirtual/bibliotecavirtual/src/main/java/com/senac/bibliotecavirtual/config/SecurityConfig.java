/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author kevin
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests
                        -> authorizeRequests
                        .requestMatchers("/login", "/css/**", "/js/**", "/error", "/livros").permitAll() // Permitir o acesso às páginas de login, CSS, JS e erro
                        .anyRequest().authenticated() // Qualquer outra página precisa de autenticação
                )
                .formLogin(formLogin
                        -> formLogin
                        .loginPage("/login") // URL da página de login personalizada
                        .loginProcessingUrl("/perform_login") // URL para processar o login
                        .defaultSuccessUrl("/livros", true) // Redirecionar após o login bem-sucedido
                        .failureUrl("/login?error=true") // Redirecionar se falhar
                        .permitAll()
                )
                .logout(logout
                        -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
