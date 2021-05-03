package br.com.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.casadocodigo.compartilhado.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nomePais", message = "Esta Pais ja esta cadastrado")
	private String nomePais;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisRequest(@NotBlank @JsonProperty("nomePais") String nomePais) {
		super();
		this.nomePais = nomePais;
	}


	public String getNomePais() {
		return nomePais;
	}


	public Pais converter(PaisRepository paisRepository) {
		return new Pais(nomePais);
	}
	
	
}
