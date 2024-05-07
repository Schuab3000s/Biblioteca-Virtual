/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_pi.model;

/**
 *
 * @author schuab
 */
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emprestimo;

    @Temporal(TemporalType.DATE)
    private Date data_pedido;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    private String emprestado;

    public Emprestimo(Livro livro, Cliente cliente, Date data_pedido, String emprestado) {
        this.data_pedido = data_pedido;
        this.livro = livro;
        this.cliente = cliente;
        this.emprestado = emprestado;
    }
    
    public Emprestimo(){}

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(String empresitmo) {
        this.emprestado = empresitmo;
    }
}
