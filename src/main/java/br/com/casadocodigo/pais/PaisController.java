package br.com.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid PaisRequest form) {
		Pais pais = form.converter(paisRepository);
		paisRepository.save(pais);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
