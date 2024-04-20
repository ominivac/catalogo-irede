package com.irede.dto;

import java.util.List;

public record FilmePageDTO(List<FilmeDTO> filmes, Long totalElements, int totalPages) {
 
}
