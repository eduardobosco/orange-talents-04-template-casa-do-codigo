package br.com.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank 
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
