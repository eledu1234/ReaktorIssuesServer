package es.iesjandula.reaktor_Issues_Server.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoIncidencia {

	/**
	 * atributo unico id para identifica incidencia
	 */
	
	private Integer id;
	
	/**
	 * atributo para registrar el numero de aula
	 */
	
	private String numeroAula;
	
	/**
	 * atributo para registrar el nombre del profesor
	 */

	
	private String nombreProfesor;
	
	/**
	 * atributo para registrar la fecha y hora
	 */

	
	private LocalDateTime fechaActual;
	
	/**
	 * atributo para especificar el tipo de incidencia, si es generica o no
	 */

	
	private String tipo;
	

	/**
	 * atributo para regitrar la descripccion de la incidencia
	 */
	
	
	private String descripcionIncidencia;
	
	/**
	 * atributo para identificar si esta resuelta
	 */

	
	private String status;
	
}
