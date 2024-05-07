/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

/**
 *
 * @author schuab
 */
import java.util.List;
import jakarta.persistence.EntityManager;

/**
 *
 * @author schuab
 */
public class ConsultasJPA {

    public List<Object[]> consultarInformacoesLivro() {
        EntityManager entityManager = ConexaoJPA.getEntityManagerFactory().createEntityManager();
        List<Object[]> resultado = entityManager.createQuery(
                "SELECT l.nome AS livro, a.nome AS autor, g.genero, l.data_lancamento "
                + "FROM Livro l "
                + "JOIN l.autor a "
                + "JOIN l.genero g "
        ).getResultList();
        entityManager.close();
        return resultado;
    }

    public List<Object[]> consultarInformacoesLivro(String termoBusca) {
        EntityManager entityManager = ConexaoJPA.getEntityManagerFactory().createEntityManager();

        // Consulta para buscar informações dos livros que correspondem ao termo de busca
        List<Object[]> resultado = entityManager.createQuery(
                "SELECT l.nome AS livro, a.nome AS autor, g.genero, l.data_lancamento "
                + "FROM Livro l "
                + "JOIN l.autor a "
                + "JOIN l.genero g "
                + "WHERE l.nome LIKE :termo OR a.nome LIKE :termo OR g.genero LIKE :termo"
        )
                .setParameter("termo", "%" + termoBusca + "%")
                .getResultList();

        entityManager.close();
        return resultado;
    }

    public List<Object[]> consultarInformacoesEmprestimo() {
        EntityManager entityManager = ConexaoJPA.getEntityManagerFactory().createEntityManager();
        List<Object[]> resultado = entityManager.createQuery(
                "SELECT l.nome AS livro, c.nome AS cliente, e.data_pedido, e.emprestado  "
                + "FROM Emprestimo e "
                + "JOIN e.livro l "
                + "JOIN e.cliente c"
        ).getResultList();
        entityManager.close();
        return resultado;
    }

    public List<Object[]> consultarInformacoesEmprestimo(String termoBusca) {
        EntityManager entityManager = ConexaoJPA.getEntityManagerFactory().createEntityManager();

        // Consulta para buscar informações dos livros que correspondem ao termo de busca
        List<Object[]> resultado = entityManager.createQuery(
                "SELECT l.nome AS livro, c.nome AS cliente, e.data_pedido, e.emprestado  "
                + "FROM Emprestimo e "
                + "JOIN e.livro l "
                + "JOIN e.cliente c"
                + "WHERE l.nome LIKE :termo OR c.nome LIKE :termo OR e.data_pedido LIKE :termo OR e.emprestado LIKE :termo"
        )
                .setParameter("termo", "%" + termoBusca + "%")
                .getResultList();

        entityManager.close();
        return resultado;
    }

}
