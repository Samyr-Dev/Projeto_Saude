package com.example.Projeto.Saude.service;

import com.example.Projeto.Saude.entity.Paciente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPacienteService {

    Paciente buscarPorId(Long id);

    List<Paciente> buscarTodos();

    Paciente salvar(Paciente paciente);

    ResponseEntity<?> atualizar(Paciente paciente);

    ResponseEntity<?> excluir(Long id);
}


