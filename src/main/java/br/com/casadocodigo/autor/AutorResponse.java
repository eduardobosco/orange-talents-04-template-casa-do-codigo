package br.com.casadocodigo.autor;

public class AutorResponse {
	
	private String nome;
	private String descricao;

	public AutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
