package com.senac.bibliotecavirtual.controller;

import com.senac.bibliotecavirtual.model.Emprestimo;
import com.senac.bibliotecavirtual.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Listar todos os empréstimos
    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    // Obter um empréstimo específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        return emprestimo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo empréstimo
    @PostMapping
    public ResponseEntity<Emprestimo> criar(@RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
            return ResponseEntity.ok(novoEmprestimo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Atualizar um empréstimo existente
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizar(@PathVariable Long id, @RequestBody Emprestimo emprestimoAtualizado) {
        if (!emprestimoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        emprestimoAtualizado.setId(id);
        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimoAtualizado);
        return ResponseEntity.ok(emprestimoSalvo);
    }

    // Excluir um empréstimo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!emprestimoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        emprestimoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
