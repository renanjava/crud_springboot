package br.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unicesumar.crud.model.domain.ModelPessoa;

@Repository
public interface PessoaRepository extends JpaRepository<ModelPessoa, Long>{
	/*
	@Query(nativeQuery = true, value = "select * from ES_PESSOA where doc = ':search' ")
	ModelPessoa buscarPessoaPorDocumentoNativa(String search);
	
	@Query(value = "select * from ModelPessoa where documento = ':search'")
	ModelPessoa buscarPessoaPorDocumentoHql(String search);
	*/
}
