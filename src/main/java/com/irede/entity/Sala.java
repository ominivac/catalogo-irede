package com.irede.entity;

import org.springframework.data.annotation.Id;

import com.irede.dto.SalaDTO;

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
@Table(name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nuemroSala")
	private String numeroSala;
	
	@Column(name = "descricao")
	private String descricao;
	
	public Sala(SalaDTO salaData) {
		this.numeroSala = salaData.numeroSala();
		this.descricao = salaData.descricao();
		
	}

}
