package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
