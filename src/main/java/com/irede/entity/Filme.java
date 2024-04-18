package com.irede.entity;

import org.springframework.data.annotation.Id;

import com.irede.dto.FilmeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity()
@Table(name = "filme")
public class Filme {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	

	@Column(name = "nome")
	private String diretor;
	

	@Column(name = "duracao")
	private Long duracao;
	
	
	public Filme(FilmeDTO filmeData) {
		this.nome = filmeData.nome();
		this.diretor =  filmeData.Diretor();
		this.duracao = filmeData.duracao();
		
	}
	
	
}
