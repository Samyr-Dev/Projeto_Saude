package com.example.Projeto.Saude.service;

import com.example.Projeto.Saude.entity.Paciente;
import java.util.List;

public interface IPacienteService {

    Paciente buscarPorId(Long id);

    List<Paciente> buscarTodos();

    Paciente salvar(Paciente paciente);

    void atualizar(Paciente paciente);

    void excluir(Long id);
}


