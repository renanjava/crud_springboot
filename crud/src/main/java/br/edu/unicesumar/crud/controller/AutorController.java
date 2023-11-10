package br.edu.unicesumar.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unicesumar.crud.exceptions.PessoaNaoEncontradaException;
import br.edu.unicesumar.crud.model.domain.ModelAutor;
import br.edu.unicesumar.crud.model.repository.AutorRepository;

@Controller
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping("/all")
	public ModelAndView getAll() {
		List<ModelAutor> autores = autorRepository.findAll();
		ModelAndView view = new ModelAndView("list-autor");
		view.addObject("autores", autores);
		return view;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getById(@PathVariable Long id) throws PessoaNaoEncontradaException {
		//ModelAutor autorBuscado = autorRepository.findById(id).orElseGet(() -> return new ModelAndView("erro"));
		ModelAndView view = new ModelAndView("list-autor");
		//view.addObject("autores", autorBuscado);
		return view;
	}
	
	@GetMapping("/novo")
	public ModelAndView newAutor() {
		ModelAndView view = new ModelAndView("form-autor");
		view.addObject("autor", new ModelAutor());
		return view;
	}
	
	@PostMapping
	public String create(ModelAutor novoAutor) {
		autorRepository.save(novoAutor);
		return "redirect:/autor/all";
	}
}
