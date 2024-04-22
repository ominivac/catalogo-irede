package com.irede;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.irede.controller.SalaController;
import com.irede.entity.Sala;
import com.irede.repository.SalaRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class SalaControllerTest {
	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SalaRepository salaRepository;
	
	
	@InjectMocks
	private SalaController salaController;
	
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(salaController)
				.alwaysDo(print())
				.build();
	} 
	
	
	@Test
	public void listarTodos() throws Exception {
		var sala = new Sala();
		
		
		Mockito.when( salaRepository.findAll()).thenReturn(List.of(sala));
	
		this.mockMvc.perform(get("/api/sala"))
			.andDo(print())
			.andExpect(status().isOk() );
			
		
	}
	

}
