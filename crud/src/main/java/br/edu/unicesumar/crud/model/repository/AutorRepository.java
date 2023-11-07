package br.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.crud.model.domain.ModelAutor;

public interface AutorRepository extends JpaRepository<ModelAutor, Long>{

}
