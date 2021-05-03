package br.com.casadocodigo.estados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query(value="SELECT count(1) FROM estado WHERE pais_id = :paisId", nativeQuery = true)
	Long contaEstadoPorPais(Long paisId);

}
