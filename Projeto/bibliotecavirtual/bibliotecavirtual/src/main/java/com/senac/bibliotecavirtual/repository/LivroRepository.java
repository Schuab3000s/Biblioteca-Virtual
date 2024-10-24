/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.bibliotecavirtual.repository;

import com.senac.bibliotecavirtual.model.Livro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author kevin
 */
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    public Optional<Livro> findById(Long id);

    public void deleteById(Long id);
}