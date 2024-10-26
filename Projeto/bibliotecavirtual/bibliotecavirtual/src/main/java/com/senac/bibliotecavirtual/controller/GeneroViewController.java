/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kevin
 */
@Controller
public class GeneroViewController {

    @GetMapping("/cadastro-genero")
    public String showCadastroGeneroPage(Model model) {
        // Adicione qualquer lógica necessária para passar dados para a página aqui
        return "cadastro-genero";
    }
}
