package com.irede.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.irede.dto.SalaDTO;
import com.irede.entity.Sala;
import com.irede.service.SalaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/sala")
@Tag(name = "EndPoint Sala")
public class SalaController {
	
	private SalaService salaService;
	
	public SalaController(SalaService salaService) {
		this.salaService = salaService;
	}

	
	@PostMapping()
	@Operation(summary = "Realiza o cadastro de nova Sala", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de Sala realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o cadastro de sala"),
    })
	public ResponseEntity<Sala> insert(@RequestBody SalaDTO salaDTO ){	
		Sala newSala = this.salaService.insert(salaDTO);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(newSala);
	}
	
	
	@GetMapping()
	@Operation(summary = "Listagem de todos as salas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
	public ResponseEntity<List<Sala>> getAllSalas(){
		  List<Sala> list = this.salaService.getAllSalas();
		  if(list.size() <= 0)
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  else
		     return ResponseEntity.of(Optional.of(list));
	}
	
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Realiza o update de uma Sala", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update de Sala realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o update de Sala"),
    })
	public ResponseEntity<Sala> update(@PathVariable("id") Long id, @RequestBody SalaDTO salaDTO){
		Sala updatedSala = this.salaService.update(id, salaDTO);
		return ResponseEntity.ok(updatedSala);
	}
	
	

	@DeleteMapping("/{id}")
	@Operation(summary = "Realiza o delete de uma Sala", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete de sala realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o delete da sala"),
    })
	public ResponseEntity<Sala> delete(@PathVariable("id") Long id){
		this.salaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
