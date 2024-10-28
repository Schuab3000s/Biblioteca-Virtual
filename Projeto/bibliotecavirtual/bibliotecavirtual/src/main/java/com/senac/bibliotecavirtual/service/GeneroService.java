/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Genero;
import com.senac.bibliotecavirtual.repository.GeneroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Long id) {
        generoRepository.findById(id).ifPresent(generoRepository::delete);
    }

    public Optional<Genero> update(Long id, Genero generoAtualizado) {
        return generoRepository.findById(id)
                .map(generoExistente -> {
                    // Atualiza os campos do gênero existente com os valores do gênero atualizado
                    generoExistente.setGenero(generoAtualizado.getGenero());

                    generoRepository.save(generoExistente);
                    return generoExistente;
                });
    }

}
