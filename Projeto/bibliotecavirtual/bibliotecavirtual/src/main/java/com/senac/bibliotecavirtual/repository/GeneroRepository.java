package com.senac.bibliotecavirtual.repository;

import com.senac.bibliotecavirtual.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    // Método para buscar gêneros pelo nome (case insensitive)
    List<Genero> findByNomeContainingIgnoreCase(String genero);

    // Método customizado para listar gêneros ordenados por nome
    @Query("SELECT g FROM Genero g ORDER BY g.nome ASC")
    List<Genero> listarGenerosOrdenados();
}
