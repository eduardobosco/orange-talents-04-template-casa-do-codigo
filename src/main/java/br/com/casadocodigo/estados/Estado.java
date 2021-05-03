package br.com.casadocodigo.estados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.casadocodigo.pais.Pais;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomeEstado;
	
	@ManyToOne
	private Pais pais;
	
	public Estado() {}
	
	public Estado(String nomeEstado, Pais pais) {
		super();
		this.nomeEstado = nomeEstado;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public Pais getPais() {
		return pais;
	}

}
