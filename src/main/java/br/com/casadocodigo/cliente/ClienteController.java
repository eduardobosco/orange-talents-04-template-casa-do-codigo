package br.com.casadocodigo.cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.compartilhado.EstadoPertenceAoPaisValidator;
import br.com.casadocodigo.compartilhado.PaisTemEstadoValidator;
import br.com.casadocodigo.estados.EstadoRepository;
import br.com.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private PaisRepository paisRepository;
	private EstadoRepository estadoRepository;
	private ClienteRepository clienteRepository;
	private PaisTemEstadoValidator paisTemEstadoValidator;
	private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;
	
	@Autowired
	public ClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository,
			ClienteRepository clienteRepository, PaisTemEstadoValidator paisTemEstadoValidator,
			EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator) {
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
		this.paisTemEstadoValidator = paisTemEstadoValidator;
		this.estadoPertenceAoPaisValidator = estadoPertenceAoPaisValidator;
	}
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(paisTemEstadoValidator, estadoPertenceAoPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> adiciona(@Valid @RequestBody ClienteRequest request) {
		Cliente cliente = request.toModel(paisRepository, estadoRepository);
		
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente.getId().toString());
	}

}
