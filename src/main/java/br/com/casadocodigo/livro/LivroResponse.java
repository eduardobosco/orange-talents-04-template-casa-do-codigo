package br.com.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import br.com.casadocodigo.autor.AutorResponse;
import br.com.casadocodigo.categoria.CategoriaResponse;

public class LivroResponse {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private String dataPublicacao;
	private AutorResponse idAutor;
	private CategoriaResponse idCategoria;
	
	public LivroResponse() {}
	
	public LivroResponse (Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.idAutor = new AutorResponse(livro.getAutor());
		this.idCategoria = new CategoriaResponse(livro.getCategoria());
		
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorResponse getIdAutor() {
		return idAutor;
	}

	public CategoriaResponse getIdCategoria() {
		return idCategoria;
	}

	public static List<LivroResponse> converter(List<Livro> livros) {
		return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
	}


}
