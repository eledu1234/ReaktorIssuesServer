package es.iesjandula.reaktor_Issues_Server.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.reaktor_Issues_Server.dto.DtoIncidencia;
import es.iesjandula.reaktor_Issues_Server.models.IncidenciaTic;

/**
 * interfaz que proporciona metodos para interracccionar con la base de datos
 */
@Repository
public interface IncidenciaRepository extends JpaRepository<IncidenciaTic, Integer>{

	@Query("DELETE FROM IncidenciaTic i WHERE i.id = :id")
	
	int borrarIncidencia(@Param("id") Integer id);
		
}
