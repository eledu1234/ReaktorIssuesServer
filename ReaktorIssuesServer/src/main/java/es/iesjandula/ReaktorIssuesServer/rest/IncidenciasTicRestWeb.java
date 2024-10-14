package es.iesjandula.ReaktorIssuesServer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.ReaktorIssuesServer.exceptions.IssuesServerException;
import es.iesjandula.ReaktorIssuesServer.models.IncidenciaTic;
import es.iesjandula.ReaktorIssuesServer.repository.IncidenciaRepository;



@RequestMapping(value = "/incidenciasTic", produces = { "application/json" })
@RestController
public class IncidenciasTicRestWeb {

	@Autowired
	private IncidenciaRepository incidenciaRepository;

	public IncidenciasTicRestWeb() {

	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear_incidencia", consumes = { "multipart/form-data" })
	public ResponseEntity<?> insertarPorFormulario(
				@ModelAttribute IncidenciaTic incidenciaTic) {
		try
		{
			
		IncidenciaTic nuevaIncidencia = incidenciaRepository.save(incidenciaTic);

		

		return ResponseEntity.ok().body(nuevaIncidencia);
		} 
			catch (Exception exception)
		{
	        IssuesServerException IssuesServerException = 
	        		new IssuesServerException(hashCode(), 
	        									"Error al crear la incidencia") ;

			
			return ResponseEntity.status(500).body(IssuesServerException.getMessage()) ;
		}
	}
}
