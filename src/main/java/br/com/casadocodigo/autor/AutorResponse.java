package br.com.casadocodigo.autor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

public class AutorResponse {

	
	private Long id;
	private String nome;
	private String email;
	private String descrição;
	private LocalDateTime dataCriacaoAutor = LocalDateTime.now();
	
	
	public AutorResponse() {}
	
	public AutorResponse(Autor autor) {
		super();
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descrição = autor.getDescrição();
		this.dataCriacaoAutor = autor.getDataCriacaoAutor();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescrição() {
		return descrição;
	}
	public LocalDateTime getDataCriacaoAutor() {
		return dataCriacaoAutor;
	}

	public static List<AutorResponse> converter(List<Autor> autores) {
		return autores.stream().map(AutorResponse::new).collect(Collectors.toList());
	}
	
	
	
}
