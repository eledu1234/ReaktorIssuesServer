package es.iesjandula.ReaktorIssuesServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.ReaktorIssuesServer.models.IncidenciaTic;

/**
 * interfaz que proporciona metodos para interracccionar con la base de datos
 */
public interface IncidenciaRepository extends JpaRepository<IncidenciaTic, Integer>{

}
