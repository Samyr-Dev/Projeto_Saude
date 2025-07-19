package com.example.Projeto.Saude.repository;


import com.example.Projeto.Saude.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNome(String nome);

    List<Paciente> findByNomeStartingWith(String nome);

//    @Query(value = "SELECT a FROM Paciente a WHERE a.nome LIKE :nome%", nativeQuery = true)
//    List<Paciente> findByNomeStartingWith(@Param("nome") String nome);

    @Query(value = "SELECT * FROM paciente a WHERE LOWER(a.nome) LIKE LOWER(CONCAT(:nome, '%'))", nativeQuery = true)
    List<Paciente> findByNomeStartingWithIgnoreCase(@Param("nome") String nome);

}

