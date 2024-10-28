/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Autor;
import com.senac.bibliotecavirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kevin
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Optional<Autor> updateById(Long id, Autor autorAtualizado) {
        return autorRepository.findById(id).map(autorExistente -> {
            autorExistente.setNome(autorAtualizado.getNome());

            return autorRepository.save(autorExistente);
        });
    }

    public boolean deleteById(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
