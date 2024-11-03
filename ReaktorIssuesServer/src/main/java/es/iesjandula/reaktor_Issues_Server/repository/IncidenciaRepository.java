package es.iesjandula.reaktor_Issues_Server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_Issues_Server.models.IncidenciaTic;

/**
 * interfaz que proporciona metodos para interracccionar con la base de datos
 */
public interface IncidenciaRepository extends JpaRepository<IncidenciaTic, Integer>{

}
