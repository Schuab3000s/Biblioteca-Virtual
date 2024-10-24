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
/**
 *
 * @author kevin
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteById(int id) {
        autorRepository.deleteById(id);
    }

    public Autor findById(int id) {
        return autorRepository.findById(id).orElse(null);
    }
}
