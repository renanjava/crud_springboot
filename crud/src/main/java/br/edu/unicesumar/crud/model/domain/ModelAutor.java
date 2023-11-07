package br.edu.unicesumar.crud.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ModelAutor {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private Integer idade;
	
	public ModelAutor() {
		
	}
	
	public ModelAutor(Long id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
