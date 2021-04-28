package br.com.casadocodigo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.autor.AutorRequest;
import br.com.casadocodigo.dto.AutorDto;
import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;

	@GetMapping
	public List<AutorDto> listar() {
		List<Autor> autores = autorRepository.findAll();
		return AutorDto.converter(autores);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid AutorRequest form) {
		Autor autor = form.converter(autorRepository);
		autorRepository.save(autor);
	}

}
