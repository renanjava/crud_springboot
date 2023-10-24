package br.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unicesumar.crud.model.domain.ModelPessoa;

@Repository
public interface PessoaRepository extends JpaRepository<ModelPessoa, Long>{

}
