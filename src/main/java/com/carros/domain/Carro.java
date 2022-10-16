package com.carros.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // mapeia a tabela carro
@Data

public class Carro {
    @Id // chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)// quando o atributo id salvar um novo carro, a JPA faz o auto incremente
    private Long id;
    private String nome;
    private String tipo;

}
