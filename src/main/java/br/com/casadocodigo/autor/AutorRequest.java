package br.com.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AutorRequest {
	
	@NotBlank @Length(min = 5)
	private String nome;
	@NotBlank @Email
	private String email;
	@NotBlank @Length(max = 400)
	private String descricao;
	
	public AutorRequest () {}
	
	

	public AutorRequest(@NotBlank @Length(min = 5) String nome, @NotBlank @Email String email,
			@NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter(AutorRepository autorRepository) {
		return new Autor(nome, email, descricao);
	}

}
