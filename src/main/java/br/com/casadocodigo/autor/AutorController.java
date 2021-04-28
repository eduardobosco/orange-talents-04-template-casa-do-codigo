package br.com.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator;

	@InitBinder
	public void init (WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoValidator);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid AutorRequest form) {
		Autor autor = form.converter(autorRepository);
		autorRepository.save(autor);
	}

}
