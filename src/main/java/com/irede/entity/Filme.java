package com.irede.entity;



import com.irede.dto.FilmeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "filme")
public class Filme {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	

	@Column(name = "diretor")
	private String diretor;
	

	@Column(name = "duracao")
	private String duracao;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sala_id")
	private Sala sala;
	
	
	public Filme(FilmeDTO filmeData) {
		this.nome = filmeData.nome();
		this.diretor =  filmeData.diretor();
		this.duracao = filmeData.duracao();
		
	}


	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", diretor=" + diretor + ", duracao=" + duracao + ", sala=" + sala
				+ "]";
	}
	
	
	
	
	
}
