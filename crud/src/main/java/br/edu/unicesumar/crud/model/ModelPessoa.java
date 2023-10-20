package br.edu.unicesumar.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ES_PESSOA")
public class ModelPessoa {
	
	@Id
	private Long id;
	
	private String nome;
	
	@Column(name = "doc", length = 14)
	private String documento;
	
	public ModelPessoa(Long id, String nome, String documento) {
		this.id = id;
		this.nome = nome;
		this.documento = nome;
	}
	
	public ModelPessoa() {
		
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
}
