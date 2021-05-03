package br.com.casadocodigo.estados;

public class EstadoResponse {
	
	private String nome;
	
	public EstadoResponse(Estado estado) {
		nome = estado.getNomeEstado();
	}

	public String getNome() {
		return nome;
	}
}