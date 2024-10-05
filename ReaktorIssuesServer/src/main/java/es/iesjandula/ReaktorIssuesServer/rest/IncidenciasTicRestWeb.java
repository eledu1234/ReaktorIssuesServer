package es.iesjandula.ReaktorIssuesServer.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.ReaktorIssuesServer.exceptions.IssuesServerException;
import es.iesjandula.ReaktorIssuesServer.models.IncidenciaTic;



@RequestMapping(value = "/incidenciasTic", produces = { "application/json" })
@RestController
public class IncidenciasTicRestWeb {

	final static int MAX_INCIDENCIAS = 1000;
	IncidenciaTic[] arrayIncidencias = new IncidenciaTic[MAX_INCIDENCIAS];

	public IncidenciasTicRestWeb() {

	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear_incidencia", consumes = { "multipart/form-data" })
	public ResponseEntity<?> insertarPorFormulario(
				@ModelAttribute IncidenciaTic IncidenciaTic) {
		try
		{
			
		IncidenciaTic nuevaIncidenciaTic = new IncidenciaTic(
				IncidenciaTic.getNumeroAula(),
				IncidenciaTic.getNombreProfesor(),
				IncidenciaTic.getDescripcionIncidencia());

		int i = 0;
		while (i < arrayIncidencias.length) {

			if (arrayIncidencias[i] != null) {
				i++;
			} else {
				arrayIncidencias[i] = nuevaIncidenciaTic;

			}
		}
		System.out.print(arrayIncidencias[i]);

		return ResponseEntity.ok().body(nuevaIncidenciaTic);
		} catch (Exception exception)
		{
	        IssuesServerException IssuesServerException = 
	        		new IssuesServerException(hashCode(), 
	        									"Error al crear la incidencia") ;

			
			return ResponseEntity.status(500).body(IssuesServerException.getMessage()) ;
		}
	}
}
