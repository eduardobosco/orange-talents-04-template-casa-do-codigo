package br.com.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Long idAutor;
	private Long idCategoria;
	
	public LivroResponse() {}
	
	public LivroResponse (Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.idAutor = livro.getAutor().getId();
		this.idCategoria = livro.getCategoria().getId();
		
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

	public static List<LivroResponse> converter(List<Livro> livros) {
		return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
	}


}