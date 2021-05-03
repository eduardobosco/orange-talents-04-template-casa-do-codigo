package br.com.casadocodigo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomePais;
	
	
	public Pais() {}
	

	public Pais(String nomePais) {
		super();
		this.nomePais = nomePais;
	}


	public Pais(Long id, String nomePais) {
		super();
		this.id = id;
		this.nomePais = nomePais;
	}
	

	public Long getId() {
		return id;
	}

	public String getNomePais() {
		return nomePais;
	}
	
	

}
