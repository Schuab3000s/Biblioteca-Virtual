/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.bibliotecavirtual.repository;
import com.senac.bibliotecavirtual.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author kevin
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
