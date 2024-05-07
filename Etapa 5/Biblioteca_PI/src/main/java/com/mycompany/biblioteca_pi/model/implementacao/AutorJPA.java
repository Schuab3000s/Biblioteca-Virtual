/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

import com.mycompany.biblioteca_pi.model.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author schuab
 */
public class AutorJPA {

    private final EntityManager entityManager;

    public AutorJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> listarAutor() {
        Query query = entityManager.createQuery("SELECT a.nome FROM Autor a");
        return query.getResultList();
    }

    public Autor buscarPorNome(String nome) {
        Query query = entityManager.createQuery("SELECT a FROM Autor a WHERE a.nome = :nome");
        query.setParameter("nome", nome);
        return (Autor) query.getSingleResult(); // Retorna um único resultado
    }
}
