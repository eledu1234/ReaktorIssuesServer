package es.iesjandula.ReaktorIssuesServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.ReaktorIssuesServer.models.IncidenciaTic;


public interface IncidenciaRepository extends JpaRepository<IncidenciaTic, Long>{

}
