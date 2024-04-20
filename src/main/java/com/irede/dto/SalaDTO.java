package com.irede.dto;

import java.util.List;

import com.irede.entity.Filme;

public record SalaDTO(String numeroSala, String descricao, List<Filme> filmes) {

}
