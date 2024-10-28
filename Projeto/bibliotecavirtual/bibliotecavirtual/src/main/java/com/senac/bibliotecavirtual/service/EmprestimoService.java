/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Emprestimo;
import com.senac.bibliotecavirtual.repository.EmprestimoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> findById(Long id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo save(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void delete(Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Empréstimo não encontrado com o ID: " + id);
        }
    }

    public Optional<Emprestimo> update(Long id, Emprestimo emprestimoAtualizado) {
        return emprestimoRepository.findById(id)
                .map(emprestimoExistente -> {

                    emprestimoExistente.setData_pedido(emprestimoAtualizado.getData_pedido());
                    emprestimoExistente.setCliente(emprestimoAtualizado.getCliente());
                    emprestimoExistente.setLivro(emprestimoAtualizado.getLivro());
                    emprestimoExistente.setEmprestado(emprestimoAtualizado.getEmprestado());

                    return emprestimoRepository.save(emprestimoExistente);
                });
    }

}
