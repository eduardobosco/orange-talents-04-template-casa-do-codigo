package br.com.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.casadocodigo.autor.Autor;
import br.com.casadocodigo.autor.AutorRepository;
import br.com.casadocodigo.categoria.Categoria;
import br.com.casadocodigo.categoria.CategoriaRepository;
import br.com.casadocodigo.compartilhado.UniqueValue;

public class LivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass=Livro.class, fieldName="titulo", message="Esta Titulo ja esta cadastrado")
	private String titulo;
	@NotBlank @Length(max=500)
	private String resumo;
	@NotBlank 
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@NotNull @Min(100)
	private Integer numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass=Livro.class, fieldName="isbn", message="Esta isbn ja esta cadastrado")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT" )
	private LocalDate dataPublicacao;
	@NotNull
	private Long idAutor;
	@NotNull
	private Long idCategoria;
	
	public LivroRequest () {}
		
	public LivroRequest(@NotBlank String titulo, @NotBlank @Length(max=500)String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro converter(LivroRepository livroRepository, AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		
		@NotNull Autor autor = autorRepository.getOne(idAutor);
		@NotNull Categoria categoria = categoriaRepository.getOne(idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	
}
