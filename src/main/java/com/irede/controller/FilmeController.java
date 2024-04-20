package com.irede.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irede.dto.FilmeDTO;
import com.irede.dto.FilmePageDTO;
import com.irede.entity.Filme;
import com.irede.service.FilmeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/filme")
@Tag(name = "Controller Filme")
public class FilmeController {
	
	private FilmeService filmeService;
	
	
	public FilmeController(FilmeService filmeService) {
		this.filmeService = filmeService;
	}

	
	@PostMapping
	@Operation(summary = "Realiza o cadastro de novo Filme", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de filme realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o cadastro do filme"),
    })
	public ResponseEntity<Filme> insert(@RequestBody FilmeDTO filmeDTO ){
		
		Filme newFilme = this.filmeService.insert(filmeDTO);
		return ResponseEntity.ok(newFilme);
	}
	
	
	@GetMapping()
	public FilmePageDTO getAllFilmes(){
		return this.filmeService.getAllFilmes();
	}
	
	/*
	@GetMapping()
	@Operation(summary = "Listagem de todos os filmes", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
	public ResponseEntity<List<Filme>> getAllFilmes(){

		  List<Filme> list = this.filmeService.getAllFilmes();
		  
		  if(list.size() <= 0)
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  else
		     return ResponseEntity.of(Optional.of(list));

	}*/
	
	
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Realiza o update de um Filme", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update de filme realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o update do filme"),
    })
	public ResponseEntity<Filme> update(@PathVariable("id") Long id, @RequestBody FilmeDTO filmeDTO){
		Filme updatedFilme = this.filmeService.update(id, filmeDTO);
		return ResponseEntity.ok(updatedFilme);
	}
	
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Realiza o delete de um Filme", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete de filme realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o delete do filme"),
    })
	public ResponseEntity<Filme> delete(@PathVariable("id") Long id){
		this.filmeService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
