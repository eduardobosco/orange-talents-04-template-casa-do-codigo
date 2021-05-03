package br.com.casadocodigo.estados;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.pais.Pais;
import br.com.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoResponse> cadastra(@RequestBody @Valid EstadoRequest request){
		final Pais pais = paisRepository.findById((Long)request.getIdPais()).get();
		
		final Estado estado = request.toModel(pais);
		
		estadoRepository.save(estado);
		
		final EstadoResponse response = new EstadoResponse(estado);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
