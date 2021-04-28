package br.com.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String descrição;

	@NotNull
	@CreationTimestamp
	private LocalDateTime dataCriacaoAutor = LocalDateTime.now();

	public Autor() {
	};

	public Autor(String nome, String email, String descrição) {
		super();
		this.nome = nome;
		this.email = email;
		this.descrição = descrição;
	}
	

	public Autor(Long id, String nome, String email, String descrição, @NotNull LocalDateTime dataCriacaoAutor) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descrição = descrição;
		this.dataCriacaoAutor = dataCriacaoAutor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descrição=" + descrição
				+ ", dataCriacaoAutor=" + dataCriacaoAutor + "]";
	}

}
