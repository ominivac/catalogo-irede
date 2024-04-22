package com.irede;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.irede.controller.FilmeController;
import com.irede.dto.FilmeDTO;
import com.irede.entity.Filme;
import com.irede.repository.FilmeRepository;
import com.irede.service.FilmeService;


@SpringBootTest
@AutoConfigureMockMvc
public class FilmeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	
	@MockBean
	private FilmeRepository filmeRepository;
	
	@Mock
	private FilmeService filmeService;
	
	@InjectMocks
	private FilmeController filmeController;
	
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(filmeController)
				.alwaysDo(print())
				.build();
	} 
	
	
	@Test
	public void listarTodos() throws Exception {
		var filme = new Filme();
		filme.setDiretor("diretor 1");
		Mockito.when( filmeRepository.findAll()).thenReturn(List.of(filme));
	
		this.mockMvc.perform(get("/api/filme"))
			.andDo(print())
			.andExpect(status().isOk() );
			
		
	}
	
	
	//@Test
 	public void getAllFilmes() throws Exception {
		FilmeDTO f1d= new FilmeDTO("filme 1", "diretor 1", "1.30", null);
		Filme f1 = new Filme(f1d);
		
		FilmeDTO f2d= new FilmeDTO("filme 2", "diretor 2", "2.30", null);
		Filme f2 = new Filme(f2d);
		
		
		List<Filme>  records = new ArrayList<>();
		records.add(f1);
		records.add(f2);
		
		Mockito.when(filmeRepository.findAll()).thenReturn(records);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/filmes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk() );
				
	}
	
	
}
