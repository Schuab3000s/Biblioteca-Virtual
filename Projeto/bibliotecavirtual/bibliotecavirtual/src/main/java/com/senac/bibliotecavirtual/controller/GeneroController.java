package com.senac.bibliotecavirtual.controller;

import com.senac.bibliotecavirtual.model.Genero;
import com.senac.bibliotecavirtual.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    // Endpoint para listar todos os gêneros
    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    // Endpoint para adicionar um novo gênero
    @PostMapping
    public Genero adicionarGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }
}
