/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

import com.mycompany.biblioteca_pi.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author schuab
 */
public class UsuarioJPA {

    private EntityManager entityManager;

    public UsuarioJPA() {

        EntityManagerFactory entityManagerFactory = ConexaoJPA.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Usuario validaLogin(String loginForm, String senhaForm) {

        Usuario user = null;

        try {

            String queryJPQL = "SELECT u FROM Usuario u"
                    + " WHERE u.login = :nomePar AND u.senha = :senhaPar";

            TypedQuery<Usuario> consulta = entityManager.createQuery(queryJPQL, Usuario.class);
            consulta.setParameter("nomePar", loginForm);
            consulta.setParameter("senhaPar", senhaForm);

            if (loginForm.equals(consulta.getSingleResult().getLogin()) && senhaForm.equals(consulta.getSingleResult().getSenha())) {
                user = consulta.getSingleResult();
            }

        } finally {
            entityManager.close();
        }

        return user;

    }
}
