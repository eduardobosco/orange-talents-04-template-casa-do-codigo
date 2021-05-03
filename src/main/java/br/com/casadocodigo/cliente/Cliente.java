package br.com.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.pais.Pais;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank @Email @Size(max = 128) String email;
	
	private @NotBlank @Size(min = 3, max = 32) String nome;
	
	private @NotBlank @Size(min = 2, max = 64) String sobrenome;
	
	private @NotBlank String documento;
	
	private @NotBlank @Size(max = 128) String endereco;
	
	private @NotBlank @Size(max = 32) String complemento;
	
	private @NotBlank @Size(max = 64) String cidade;
	
	private @NotBlank @Size(max = 15) String telefone;
	
	private @NotBlank @Size(max = 8) String cep;
	
	@ManyToOne @JoinColumn(nullable = false)
	private @NotNull Pais pais;
	
	@ManyToOne
	private Estado estado;

	public Cliente(@NotBlank @Email String email, @NotBlank @Size(min = 3, max = 32) String nome,
			@NotBlank @Size(min = 2, max = 64) String sobrenome, @NotBlank String documento,
			@NotBlank @Size(max = 128) String endereco, @NotBlank @Size(max = 32) String complemento,
			@NotBlank @Size(max = 64) String cidade, @NotBlank @Size(max = 15) String telefone,
			@NotBlank @Size(max = 8) String cep, @NotNull Pais pais) {
				this.email = email;
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.documento = documento;
				this.endereco = endereco;
				this.complemento = complemento;
				this.cidade = cidade;
				this.telefone = telefone;
				this.cep = cep;
				this.pais = pais;
	}
	
	public void setEstado(Estado estado) {
		Assert.notNull(estado, "Você está tentando fazer a associação de um estado que não existe");
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}
}
