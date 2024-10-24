/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.controller;

import com.senac.bibliotecavirtual.model.Autor;
import com.senac.bibliotecavirtual.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable int id) {
        return autorService.findById(id);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable int id) {
        autorService.deleteById(id);
    }
}
