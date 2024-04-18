package com.irede.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irede.dto.SalaDTO;
import com.irede.entity.Sala;
import com.irede.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;

	
	public SalaService() {
		
	}
	
	public Sala insert(SalaDTO salaData) {
		Sala newSala = new Sala(salaData);
		this.salaRepository.save(newSala);
		return newSala;
		
	}
	
}
