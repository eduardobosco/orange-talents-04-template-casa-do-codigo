package br.com.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.repository.AutorRepository;

public class AutorRequest {
	
	
	private String nome;
	private String email;
	private String descricao;
	
	public AutorRequest () {}
	
	public AutorRequest(String nome, String email, String descricao) {
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
