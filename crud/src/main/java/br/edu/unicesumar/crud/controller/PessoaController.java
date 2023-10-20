package br.edu.unicesumar.crud.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

import br.edu.unicesumar.crud.model.ModelPessoa;
import br.edu.unicesumar.crud.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("todos")
	public List<ModelPessoa> all(){
		return pessoaRepository.findAll();
	}
	
	private List<ModelPessoa> mock(){
		
		return Arrays.asList(
				new ModelPessoa(1L, "Renan1", "Teste1"),
				new ModelPessoa(2L, "Renan2", "Teste2"),
				new ModelPessoa(3L, "Renan3", "Teste3")
				);
	}
	
	@GetMapping("/findById{id}")
	public ModelPessoa byId(@PathVariable Long id) {
		return mock().stream().filter
				(pessoa -> pessoa.getId().equals(id)).findFirst().orElse(null);
	}
	
	@GetMapping("/buscar")
	public List<ModelPessoa> searchBy(@RequestParam("valor") String search){
		return mock().stream().filter(pessoa -> pessoa.getNome().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
	}
	
	@PostMapping("/criar")
	public ModelPessoa create(@RequestBody ModelPessoa novaPessoa) {
		Long idMax = mock().stream().mapToLong(ModelPessoa::getId).max().orElse(0L);
		
		return new ModelPessoa(idMax+1L, novaPessoa.getNome(), novaPessoa.getDocumento());
	}
	
	@PutMapping("/update{id}")
	public void update(@PathVariable Long id, @RequestBody ModelPessoa editPessoa) {
		ModelPessoa renan = new ModelPessoa(id, editPessoa.getNome(), editPessoa.getDocumento());
	}
	
	@DeleteMapping("/deletar{id}")
	public void delete(@PathVariable Long id) {
		long l = id.longValue();
	}
}