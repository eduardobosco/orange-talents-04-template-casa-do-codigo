package br.com.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.casadocodigo.compartilhado.UniqueValue;

public class CategoriaRequest {
	
	@NotBlank 
	@UniqueValue(domainClass=Categoria.class, fieldName="nome", message="Esta Categoria ja esta cadastrada")
	private String nome;
	
	public CategoriaRequest() {}

	public CategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria converter(CategoriaRepository categoriaRepository) {
		return new Categoria(nome);
	}
	
	

}
