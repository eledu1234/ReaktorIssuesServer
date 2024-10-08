package es.iesjandula.ReaktorIssuesServer.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoIncidencia {
	
	private Long id;
	
	private Double numeroAula;
	
	private String nombreProfesor;
	
	private LocalDateTime fechaActual;
	
	private String descripcionIncidencia;
}
