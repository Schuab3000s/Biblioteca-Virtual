/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model.implementacao;

/**
 *
 * @author schuab
 */
import com.mycompany.biblioteca_pi.model.Emprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EmprestimoJPA {

    private EntityManager entityManager;

    public EmprestimoJPA() {

        EntityManagerFactory entityManagerFactory = ConexaoJPA.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para adicionar um novo empréstimo
    public boolean adicionarEmprestimo(Emprestimo emprestimo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emprestimo);
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

    // Método para buscar um empréstimo pelo ID
    public Emprestimo buscarPorId(int id) {
        return entityManager.find(Emprestimo.class, id);
    }

    // Método para atualizar um empréstimo na tabela emprestimo
    public void atualizarEmprestimo(Emprestimo emprestimo) {

        entityManager.getTransaction().begin();
        entityManager.merge(emprestimo);
        entityManager.getTransaction().commit();
    }

    // Método para excluir um empréstimo da tabela emprestimo
    public void excluirEmprestimo(int id) {
        Emprestimo emprestimo = buscarPorId(id);

        entityManager.getTransaction().begin();
        entityManager.remove(emprestimo);
        entityManager.getTransaction().commit();
    }

    // Método para listar todos os empréstimos da tabela emprestimo
    public List<Emprestimo> listarEmprestimo() {
        Query query = entityManager.createQuery("SELECT e FROM Emprestimo e");
        return query.getResultList();
    }

    public Integer buscarId_LivroPorNome(String nomeLivro) {
        Query query = entityManager.createQuery("SELECT l.id_livro FROM Livro l WHERE l.nome = :nome");
        query.setParameter("nome", nomeLivro);

        List<Integer> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public Integer buscarId_ClientePorNome(String nomeCliente) {
        Query query = entityManager.createQuery("SELECT c.id_cliente FROM Cliente c WHERE c.nome = :nome");
        query.setParameter("nome", nomeCliente);
        List<Integer> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public Integer buscarIdEmprestimo(String nomeLivro, String nomeCliente, Date data_pedido, String emprestado) {
        Query query = entityManager.createQuery("SELECT e.id FROM Emprestimo e "
                + "JOIN e.livro l "
                + "JOIN e.cliente c "
                + "WHERE l.nome = :nomeLivro "
                + "AND c.nome = :nomeCliente "
                + "AND e.data_pedido = :data_pedido "
                + "AND e.emprestado = :emprestado");
        query.setParameter("nomeLivro", nomeLivro);
        query.setParameter("nomeCliente", nomeCliente);
        query.setParameter("data_pedido", data_pedido);
        query.setParameter("emprestado", emprestado);

        List<Integer> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public void devolverLivro(int idEmprestimo) {
        // Busca o empréstimo pelo ID
        Emprestimo emprestimo = entityManager.find(Emprestimo.class, idEmprestimo);

        if (emprestimo != null) {
            // Atualiza o estado do empréstimo para refletir que o livro foi devolvido
            emprestimo.setEmprestado("não");

            // Atualiza o empréstimo no banco de dados
            entityManager.getTransaction().begin();
            entityManager.merge(emprestimo);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Empréstimo não encontrado com o ID fornecido.");
        }
    }

}
