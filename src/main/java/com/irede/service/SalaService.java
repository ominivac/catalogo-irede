package com.irede.service;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irede.dto.SalaDTO;
import com.irede.entity.Sala;
import com.irede.exception.SalaNotFoundException;
import com.irede.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;

	
	public SalaService() {
		
	}
	
	public Sala insert(SalaDTO salaData) {
		Sala newSala = new Sala(salaData);
		System.out.println("------ sala a add : "+  salaData.filmes());
		this.salaRepository.save(newSala);
		
		
		return newSala;
		
	}
	
	public List<Sala> getAllSalas() {
		return this.salaRepository.findAll();
	}
	
	public  Optional<Sala> getById(Long id) {
		return this.salaRepository.findById(id);
	}
	
	public Sala update(Long id, SalaDTO salaDTO) {
		Sala sala = this.salaRepository.findById(id)
				.orElseThrow(SalaNotFoundException:: new);

		if(!salaDTO.descricao().isEmpty() )
			sala.setDescricao(salaDTO.descricao() );
		
		
		this.salaRepository.save(sala);
		
		return sala;
	}


	public void delete(Long id) {
		Sala sala = this.salaRepository.findById(id)
				.orElseThrow(SalaNotFoundException:: new);
		
		this.salaRepository.delete(sala);
		
		
	}
	
}
