package com.senac.bibliotecavirtual.controller;

import com.senac.bibliotecavirtual.model.Autor;
import com.senac.bibliotecavirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    // Endpoint para listar todos os autores
    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    // Endpoint para adicionar um novo autor
    @PostMapping
    public Autor adicionarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}
