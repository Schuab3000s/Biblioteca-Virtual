/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

import com.mycompany.biblioteca_pi.model.Genero;
import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author schuab
 */
public class GeneroJPA {

    private final EntityManager entityManager;

    public GeneroJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> listarGenero() {
        Query query = entityManager.createQuery("SELECT g.genero FROM Genero g");
        return query.getResultList();
    }
    
    public Genero buscarPorNome(String genero) {
        Query query = entityManager.createQuery("SELECT g FROM Genero g WHERE g.genero = :genero");
        query.setParameter("genero", genero);
        return (Genero) query.getSingleResult(); // Retorna um único resultado
    }
    
    
}
