/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

/**
 *
 * @author schuab
 */
import com.mycompany.biblioteca_pi.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ClienteJPA {

    private final EntityManager entityManager;

    public ClienteJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para adicionar um novo cliente
    public boolean adicionarCliente(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            return true; // Retorna true se o cliente foi cadastrado com sucesso
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback(); // Desfaz a transação em caso de erro
            }
            return false; // Retorna false se ocorrer algum erro durante o cadastro do cliente
        }
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarPorId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    // Método para atualizar um cliente na tabela cliente
    public void atualizarCliente(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback(); // Desfaz a transação em caso de erro
            }
        }
    }

    // Método para excluir um cliente da tabela cliente
    public void excluirCliente(int id) {
        Cliente cliente = buscarPorId(id);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback(); // Desfaz a transação em caso de erro
            }
        }
    }

    // Método para listar todos os clientes da tabela cliente
    public List<String> listarCliente() {
        Query query = entityManager.createQuery("SELECT c.nome FROM Cliente c");
        return query.getResultList();
    }
}
