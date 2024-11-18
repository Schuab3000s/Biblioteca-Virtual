package com.senac.bibliotecavirtual.repository;

import com.senac.bibliotecavirtual.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Método para buscar autores pelo nome (case insensitive)
    List<Autor> findByNomeContainingIgnoreCase(String nome);

    // Método customizado para listar autores ordenados por nome
    @Query("SELECT a FROM Autor a ORDER BY a.nome ASC")
    List<Autor> listarAutoresOrdenados();
}
