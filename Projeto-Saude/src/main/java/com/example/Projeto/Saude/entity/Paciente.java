package com.example.Projeto.Saude.entity;


import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity



public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean ativo;

    private String nomeMae;
    private String nomePai;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Cidade cidade;
    private String estadoNascimento;
    private String RG;
    private String CPF;
    private String endereco;
    private String CEP;
    private String cidadeMoradia;
    private String estadoMoradia;
    private String email;
    private String fone;
    private String cellPhone;
    private String nomeResponsavel;
    private int RGResponsavel;
    private int CPFResponsavel;

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nomeMae=" + nomeMae +
                ", nome='" + nome + '\'' +
                ", cidade=" + cidade +
                ", ativo" + ativo +
                '}';
    }


}
