/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.controller;

import com.senac.bibliotecavirtual.model.Livro;
import com.senac.bibliotecavirtual.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kevin
 */
@Controller
public class LivroViewController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Livro livro = livroService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + id));
        model.addAttribute("livro", livro);
        return "editar-livro"; // Nome da página de edição
    }

    @PostMapping("/editar/{id}")
    public String updateLivro(@PathVariable Long id, @ModelAttribute("livro") Livro livro) {
        livroService.updateById(id, livro);
        return "redirect:/livros"; // Redireciona para a lista de livros
    }

    @GetMapping("/deletar/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Livro livro = livroService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + id));
        model.addAttribute("livro", livro);
        return "confirmar-delecao"; // Nome da página de confirmação de deleção
    }

    @PostMapping("/deletar/{id}")
    public String deleteLivro(@PathVariable Long id) {
        livroService.deleteById(id);
        return "redirect:/livros"; // Redireciona para a lista de livros

    }
}
