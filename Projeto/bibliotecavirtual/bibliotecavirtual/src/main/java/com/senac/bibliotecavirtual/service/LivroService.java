/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Livro;
import com.senac.bibliotecavirtual.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Long id) {
        livroRepository.findById(id).ifPresent(livroRepository::delete);
    }

    public Optional<Livro> updateById(Long id, Livro livro) {
        return livroRepository.findById(id)
                .map(existingLivro -> {
                    existingLivro.setNome(livro.getNome());
                    existingLivro.setAutor(livro.getAutor());
                    existingLivro.setGenero(livro.getGenero());
                    existingLivro.setData_lancamento(livro.getData_lancamento());
                    
                    livroRepository.save(existingLivro);
                    return existingLivro;
                });
                
    }
}
