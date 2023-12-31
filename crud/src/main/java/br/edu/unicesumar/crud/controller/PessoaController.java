package br.edu.unicesumar.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.crud.exceptions.PessoaNaoEncontradaException;
import br.edu.unicesumar.crud.model.domain.ModelPessoa;
import br.edu.unicesumar.crud.model.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/buscarTodos")
	public List<ModelPessoa> all(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/buscarPorId/{id}")
	public ModelPessoa findById(@PathVariable Long id) throws PessoaNaoEncontradaException{
		return pessoaRepository.findById(id).orElseThrow(PessoaNaoEncontradaException::new);
	}
	
	@GetMapping("/buscarPorParametro")
	public List<ModelPessoa> searchBy(@RequestParam("nome") Iterable<Long> search){
		return pessoaRepository.findAllById(search);
	}
	
	@PostMapping("/criar")
	public ModelPessoa create(@RequestBody ModelPessoa novaPessoa) {		
		return pessoaRepository.save(novaPessoa);
	}
	
	@PutMapping("/atualizarPorId/{id}")
	public void update(@PathVariable Long id, @RequestBody ModelPessoa editPessoa) {
		editPessoa.setId(id);			
		pessoaRepository.save(editPessoa);
	}
	
	@DeleteMapping("/deletarPorId/{id}")
	public void delete(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	/*
	@GetMapping("/buscarDocumentoHQL")
	public void buscarDocumentoHql(@RequestParam("documento") String documento) {
		pessoaRepository.buscarPessoaPorDocumentoHql(documento);
	}
	
	@GetMapping("/buscarDocumentoNativa")
	public void buscarDocumentoNativa(@RequestParam("documento") String documento) {
		pessoaRepository.buscarPessoaPorDocumentoNativa(documento);
	}
	*/
}