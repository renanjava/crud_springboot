package br.edu.unicesumar.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.crud.model.domain.ModelEditora;
import br.edu.unicesumar.crud.model.repository.EditoraRepository;

@RestController
@RequestMapping("/editora")
public class EditoraController {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	@PostMapping("/criar")
	public ModelEditora criar(@RequestBody ModelEditora novaEditora) {
		return editoraRepository.save(novaEditora);
	}
	
	@PutMapping("/atualizar{id}")
	public ModelEditora atualizar(@PathVariable Long id, @RequestBody ModelEditora attEditora) {
		return editoraRepository.save(attEditora);
	}
	
	@DeleteMapping("/deletar{id}")
	public void deletar(@PathVariable Long id) {
		editoraRepository.deleteById(id);
	}
	
	@GetMapping("/buscar{id}")
	public ModelEditora buscar(@PathVariable Long id) {
		return editoraRepository.findById(id).orElseThrow();
	}
}
