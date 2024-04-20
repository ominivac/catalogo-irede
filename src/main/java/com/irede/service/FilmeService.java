package com.irede.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irede.dto.FilmeDTO;
import com.irede.dto.FilmePageDTO;
import com.irede.entity.Filme;
import com.irede.exception.FilmeNotFoundException;
import com.irede.exception.SalaNotFoundException;
import com.irede.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public FilmeService() {
		
	}
	
	
	public Filme insert(FilmeDTO filmeData) {
		Filme newFilme = new Filme(filmeData);
		this.filmeRepository.save(newFilme);
		return newFilme;
		
	}
	
	/*
	public List<Filme> getAllFilmes() {
		return this.filmeRepository.findAll();
	}*/
	
	
	
	public FilmePageDTO getAllFilmes(int pagina, int tamanhoPagina) {
		Page<Filme> page = this.filmeRepository.findAll(PageRequest.of(pagina, tamanhoPagina));
		List<Filme> filmes = page.toList();
		List<FilmeDTO> filmeDTOs = new ArrayList<FilmeDTO>();
		
		for(int i=0; i< filmes.size(); i++) {
			filmeDTOs.add( new FilmeDTO(filmes.get(i).getNome(), filmes.get(i).getDiretor(), filmes.get(i).getDuracao(), null));
		}
		
		
		return new FilmePageDTO(filmeDTOs, page.getTotalElements(), page.getTotalPages() );
		
		
	}
	
	
	
	
	public  Optional<Filme> getById(Long id) {
		return this.filmeRepository.findById(id);
	}
	
	public Filme update(Long id, FilmeDTO filmeDTO) {
		Filme filme = this.filmeRepository.findById(id)
				.orElseThrow(FilmeNotFoundException:: new);

		if(!filmeDTO.diretor().isEmpty() )
			filme.setDiretor(filmeDTO.diretor() );
		
		
		this.filmeRepository.save(filme);
		
		return filme;
	}


	public void delete(Long id) {
		Filme filme = this.filmeRepository.findById(id)
				.orElseThrow(SalaNotFoundException:: new);
		
		this.filmeRepository.delete(filme);
		
		
	}
	
}
