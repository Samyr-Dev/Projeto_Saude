package com.example.Projeto.Saude.controller;
import com.example.Projeto.Saude.entity.Paciente;
import com.example.Projeto.Saude.service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/paciente")
@Slf4j
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<com.example.Projeto.Saude.entity.Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<com.example.Projeto.Saude.entity.Paciente> buscarPorId(@PathVariable Long id){

        com.example.Projeto.Saude.entity.Paciente response = pacienteService.buscarPorId(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<com.example.Projeto.Saude.entity.Paciente>> buscarPorNome(@PathVariable String nome){

        List<com.example.Projeto.Saude.entity.Paciente> response = pacienteService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<com.example.Projeto.Saude.entity.Paciente> salvarPaciente(@RequestBody com.example.Projeto.Saude.entity.Paciente paciente){
        log.info("salvarPaciente() - paciente:{}", paciente );
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody com.example.Projeto.Saude.entity.Paciente paciente){

        return pacienteService.atualizar(paciente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Paciente response = pacienteService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.excluir(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<?> desativar(@PathVariable Long id) {
        com.example.Projeto.Saude.entity.Paciente response = pacienteService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.desativar(response);
        return ResponseEntity.ok(null);
    }


}




