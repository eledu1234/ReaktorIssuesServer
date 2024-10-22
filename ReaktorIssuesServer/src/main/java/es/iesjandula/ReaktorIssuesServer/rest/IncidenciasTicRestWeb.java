package es.iesjandula.ReaktorIssuesServer.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import es.iesjandula.ReaktorIssuesServer.exceptions.IssuesServerException;
import es.iesjandula.ReaktorIssuesServer.models.IncidenciaTic;
import es.iesjandula.ReaktorIssuesServer.repository.IncidenciaRepository;
import es.iesjandula.ReaktorIssuesServer.utils.Costantes;
import lombok.extern.log4j.Log4j2;



@RequestMapping(value = "/incidenciasTic", produces = { "application/json" })
@RestController
@Log4j2
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
		catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "crear incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "crear incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/mostrar_incidencias", consumes = {})
	public ResponseEntity<?> mostrarIncidencias(
			@ModelAttribute IncidenciaTic incidenciaTic) 
	{
		try 
		{
			
			// Creacion de una lista para almacenar las incidencias no nulas
		    List<IncidenciaTic> incidenciasList = new ArrayList<>();

			incidenciasList= incidenciaRepository.findAll();
		      
		    return ResponseEntity.ok(incidenciasList);	
		}
		
		catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "crear incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "crear incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
			   
	}
	
	
	/**
	 * metodo post para editar una incidencia ya creada
	 * @param incidenciaTic
	 * @return incidenciaActualizada incidrncia ya editada subida a la base de datos
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/editar_incidencia", consumes = { "multipart/form-data" })
	public ResponseEntity<?> editarIncidencia(@ModelAttribute IncidenciaTic incidenciaTic) 
	{
	    try 
	    {
	    	//buscar la incidencia mediante su id
	    	IncidenciaTic incidenciaActualizada = incidenciaRepository.findById(incidenciaTic.getId()).get();
	    	
	    	if(incidenciaRepository.findById(incidenciaTic.getId()) != null)
	    	{
	    	
		        if (incidenciaTic.getNumeroAula() != null) 
		        {
		        	
		            
		            incidenciaActualizada.setNumeroAula(incidenciaTic.getNumeroAula());
		            // comprobar el nuemro de aula y actualizarlo
		            incidenciaRepository.save(incidenciaActualizada);
		        }
		        if (incidenciaTic.getNombreProfesor() != null) 
		        {
		            incidenciaActualizada.setNombreProfesor(incidenciaTic.getNombreProfesor());
		            // comprobar el nombre del profesor y actualizarlo
		            incidenciaRepository.save(incidenciaActualizada);
		        }
		        if (incidenciaTic.getDescripcionIncidencia() != null) 
		        {
		            incidenciaActualizada.setDescripcionIncidencia(incidenciaTic.getDescripcionIncidencia());
		            // comprobar la descripcion de la incidencia  y actualizarlo
		            incidenciaRepository.save(incidenciaActualizada);
		        }
		        if (incidenciaTic.getStatus() != null) 
		        {
		            incidenciaActualizada.setStatus(incidenciaTic.getStatus());
		            // comprobar el estado de la incicdencia y actualizarlo
		            incidenciaRepository.save(incidenciaActualizada);
		        }

	    	}
	    	return ResponseEntity.ok().body(incidenciaActualizada);
	    }
	    catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "editar incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "editar incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
		
	}
	
	
	/**
	 * metodo get para cambiar el atributo pendiente a false para confirmar que la incidencia ya esta cerrada
	 * @param id
	 * @return incidenciaActualizada con el atributo booleano pendiente false 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/resolver_incidencia/{id}")
	public ResponseEntity<?> resolverIncidencia(@PathVariable Integer id) 
	{
	    try 
	    {
	        // buscar la incidencia existente por su ID
	        Optional<IncidenciaTic> incidenciaExistente = incidenciaRepository.findById(id);
	    	
	        IncidenciaTic incidenciaActualizada = incidenciaExistente.get();
	        //miramos si la incidencia exite
	        if (incidenciaExistente.isPresent()) 
	        {
	           
	            // verificar si ya está resuelta
	            if (incidenciaActualizada.getStatus().equals(Costantes.STD_REALIZADO)) 
	            {
	                return ResponseEntity.badRequest().body("La incidencia ya ha sido resuelta.");
	            }
	            
	            // cambiar el estado de pendiente a false
	            incidenciaActualizada.setStatus(Costantes.STD_REALIZADO);
	            
	            // guardar los cambios
	            incidenciaRepository.save(incidenciaActualizada);
	            
	            
	        } 
	        return ResponseEntity.ok().body(incidenciaActualizada);
	       
	    } 
	    catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "checkear incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "checkear incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
	}


	
	@RequestMapping(method = RequestMethod.DELETE, value = "/borrar_incidencia", consumes = { "multipart/form-data" })
	public ResponseEntity<?> cancelarYBorrarPorFormulario(@ModelAttribute IncidenciaTic incidenciaTic) 
	{
		try 
		{			
			 IncidenciaTic incidenciaABorrar= new IncidenciaTic();
			 incidenciaABorrar= incidenciaRepository.getReferenceById(incidenciaTic.getId());
			
			if(incidenciaABorrar.getStatus().equals(Costantes.STD_PENDIENTE)) 
			{
				
			incidenciaRepository.deleteById(incidenciaTic.getId());
			
			} else 
			{
				
				return ResponseEntity.status(500).body("No puedes cancelarla porque ya no esta pendiente");
			}
			return ResponseEntity.ok().body("Incidencia con el id: " + incidenciaTic.getId() + " ha sido borrada correctamente");
			
			
		} catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "borrar incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "borrar incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
		
	}
}
