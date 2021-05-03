package br.com.casadocodigo.estados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.casadocodigo.compartilhado.UniqueValue;
import br.com.casadocodigo.pais.Pais;
import br.com.casadocodigo.pais.PaisRepository;


public class EstadoRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nomeEstado", message = "Esta Estado ja esta cadastrado")
	private String nomeEstado;
	
	@NotNull
	private Long idPais;
	

	public EstadoRequest() {}

	public EstadoRequest(@NotBlank String nomeEstado, @NotNull Long idPais) {
		super();
		this.nomeEstado = nomeEstado;
		this.idPais = idPais;
	}

	public Long getId() {
		return id;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}
	
	public Long getIdPais() {
		return idPais;
	}

	public Estado converter(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Pais pais = paisRepository.getOne(idPais);
		return new Estado(nomeEstado, pais);
	}
	
	

}
