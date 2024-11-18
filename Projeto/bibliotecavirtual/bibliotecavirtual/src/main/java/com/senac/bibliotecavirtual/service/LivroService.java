/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.bibliotecavirtual.service;

import com.senac.bibliotecavirtual.model.Autor;
import com.senac.bibliotecavirtual.model.Genero;
import com.senac.bibliotecavirtual.model.Livro;
import com.senac.bibliotecavirtual.repository.AutorRepository;
import com.senac.bibliotecavirtual.repository.GeneroRepository;
import com.senac.bibliotecavirtual.repository.LivroRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Long id) {
        livroRepository.findById(id).ifPresent(livroRepository::delete);
    }

    public Optional<Livro> updateById(Long id, Livro livro) {
        return livroRepository.findById(id)
                .map(existingLivro -> {
                    existingLivro.setNome(livro.getNome());
                    existingLivro.setAutor(livro.getAutor());
                    existingLivro.setGenero(livro.getGenero());
                    existingLivro.setData_lancamento(livro.getData_lancamento());

                    livroRepository.save(existingLivro);
                    return existingLivro;
                });

    }

    public String criarLivro(Map<String, Object> livroRequest) {
        try {
            // Pegando os dados enviados pelo cliente
            String nome = livroRequest.get("nome").toString();
            Long autorId = Long.valueOf(livroRequest.get("autorId").toString());
            Long generoId = Long.valueOf(livroRequest.get("generoId").toString());
            String dataLancamento = livroRequest.get("dataLancamento").toString();

            // Buscando o autor e o gênero no banco
            Autor autor = autorRepository.findById(autorId)
                    .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
            Genero genero = generoRepository.findById(generoId)
                    .orElseThrow(() -> new RuntimeException("Gênero não encontrado"));

            // Criando e salvando o livro
            Livro livro = new Livro();
            livro.setNome(nome);
            livro.setAutor(autor);
            livro.setGenero(genero);
            livro.setData_lancamento(LocalDate.parse(dataLancamento));
            livroRepository.save(livro);

            return "Livro cadastrado com sucesso!";
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar livro: " + e.getMessage());
        }
    }
}
