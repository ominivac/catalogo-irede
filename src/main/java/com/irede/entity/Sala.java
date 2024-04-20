package com.irede.entity;



import java.util.List;

import com.irede.dto.SalaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeroSala")
	private String numeroSala;
	
	@Column(name = "descricao")
	private String descricao;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sala",cascade = CascadeType.ALL)
	//@JoinColumn(name="sala_id")
	private List<Filme> filmes;
	
	public Sala(SalaDTO salaData) {
		this.numeroSala = salaData.numeroSala();
		this.descricao = salaData.descricao();
		
	}
	
	public List<Filme> getFilmes(){
		return filmes;
	}
	

}
