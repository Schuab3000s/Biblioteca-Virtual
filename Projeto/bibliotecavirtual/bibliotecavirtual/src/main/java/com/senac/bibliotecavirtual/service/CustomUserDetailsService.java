/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Usuario;
import com.senac.bibliotecavirtual.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository userRepository;  // Seu repositório de usuários

    public CustomUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Procurar o usuário no banco de dados
        Usuario usuario = userRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        // Retornar o usuário com as informações de segurança
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword()) // A senha deve estar codificada com BCrypt
                .roles(usuario.getRole()) // Ou authorities, se preferir
                .build();
    }
}
