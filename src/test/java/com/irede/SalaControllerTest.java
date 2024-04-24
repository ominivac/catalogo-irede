package com.irede;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
	public void getSalaById_success() throws Exception {
		Sala s1 = new Sala();
		s1.setId(3L);
		
		
	    Mockito.when(salaRepository.findById( s1.getId()  )).thenReturn(java.util.Optional.of(s1));

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/sala/findBy/3")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.id", is(3)));
	}
	
	//@Test
	public void listarTodos() throws Exception {
		Sala sala = new Sala();
		
		
		Mockito.when( salaRepository.findAll()).thenReturn(List.of(sala));
	
		MvcResult result  = this.mockMvc.perform(get("/api/sala"))
			.andDo(print())
			.andExpect(status().isOk() )
			.andExpect(jsonPath("$", notNullValue()))
			.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		
			
		
	}
	

}
