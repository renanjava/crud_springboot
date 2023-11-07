package br.edu.unicesumar.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView view = new ModelAndView("autor");
		view.addObject("autores", autores);
		return view;
	}
}
