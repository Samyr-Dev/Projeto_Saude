package com.example.Projeto.Saude.service;


import com.example.Projeto.Saude.entity.Paciente;
import com.example.Projeto.Saude.repository.PacienteRepository;
import com.example.Projeto.Saude.entity.Paciente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> response = pacienteRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.info("salvar() - paciente:{}", paciente );
        return pacienteRepository.save(paciente);
    }

    @Override
    public void atualizar(Paciente paciente) {
        log.info("atualizar() - paciente:{}", paciente );
        pacienteRepository.save(paciente);
    }

    @Override
    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }

    public void desativar(Paciente paciente) {
        paciente.setAtivo(Boolean.FALSE);
        pacienteRepository.save(paciente);
    }

    public List<Paciente> buscarPorNome(String nome) {
//        return pacienteRepository.findByNome(nome);
        return pacienteRepository.findByNomeStartingWithIgnoreCase(nome);
    }
}

