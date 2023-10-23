package br.edu.unicesumar.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.crud.model.domain.ModelPessoa;

public interface PessoaRepository extends JpaRepository<ModelPessoa, Long>{

}
