/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

/**
 *
 * @author schuab
 */
import com.mycompany.biblioteca_pi.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class LivrosJPA {

    private EntityManager entityManager;

    public LivrosJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para adicionar um novo livro
    public void adicionarLivro(Livro livro) {

        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
    }

    // Método para buscar um livro pelo ID
    public Livro buscarPorId(int id) {
        return entityManager.find(Livro.class, id);
    }

    public Livro buscarPorNome(String nomeLivro) {
        // Consultar o livro pelo nome
        Query query = entityManager.createQuery("SELECT l FROM Livro l WHERE l.nome = :nome");
        query.setParameter("nome", nomeLivro);
        List<Livro> resultados = query.getResultList();

        // Verificar se o livro foi encontrado
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null; // Retorna null se o livro não for encontrado
        }
    }

    // Método para atualizar um livro na tabela livros
    public void atualizarLivro(Livro livro) {

        entityManager.getTransaction().begin();
        entityManager.merge(livro);
        entityManager.getTransaction().commit();
    }

    // Método para excluir um livro da tabela livros
    public void excluirLivro(String nome) {
        Livro livro = buscarPorNome(nome);

        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }

    // Método para listar todos os livros da tabela livros
    public List<Livro> listarLivros() {
        Query query = entityManager.createQuery("SELECT l FROM Livros l");
        return query.getResultList();
    }

    // Método para listar todos os nomes dos livros da tabela livros
    public List<String> listarNomeLivros() {
        Query query = entityManager.createQuery("SELECT l.nome FROM Livro l");
        return query.getResultList();
    }

}
