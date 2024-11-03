package es.iesjandula.reaktor_Issues_Server.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.reaktor_Issues_Server.dto.DtoIncidencia;
import es.iesjandula.reaktor_Issues_Server.exceptions.IssuesServerException;
import es.iesjandula.reaktor_Issues_Server.models.IncidenciaTic;
import es.iesjandula.reaktor_Issues_Server.repository.IncidenciaRepository;
import es.iesjandula.reaktor_Issues_Server.utils.Costantes;
import lombok.extern.log4j.Log4j2;



@RequestMapping(value = "/incidenciasTic")
@RestController
@Log4j2
public class IncidenciasTicRestWeb 
{

	@Autowired
	private IncidenciaRepository incidenciaRepository;

	public IncidenciasTicRestWeb() 
	{

	}
	/**
	 * metodo post para registrar una incidencia
	 * @param incidenciaTic
	 * @return nuevaIncidencia
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/crear_incidencia")
	public ResponseEntity<?> insertarPorFormulario(
				@RequestBody DtoIncidencia incidenciaTic) 
	{
		try
		{
			
			
			// creamos una nueva incidencia y la guardamos 
		IncidenciaTic nuevaIncidencia = new IncidenciaTic();
		
		nuevaIncidencia.setNumeroAula(incidenciaTic.getNumeroAula());
		nuevaIncidencia.setNombreProfesor(incidenciaTic.getNombreProfesor());
		nuevaIncidencia.setTipo(incidenciaTic.getTipo());
		nuevaIncidencia.setDescripcionIncidencia(incidenciaTic.getDescripcionIncidencia());
		incidenciaRepository.saveAndFlush(nuevaIncidencia);

		
		//devolvemos incidencia
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
	
	/**
	 * metodo para mostrar todas las incidencias
	 * @param incidenciaTic
	 * @return incidenciasList
	 */
	@RequestMapping(method = RequestMethod.GET, value="/mostrar_incidencias")
	public ResponseEntity<?> mostrarIncidencias(
			@RequestBody IncidenciaTic incidenciaTic) 
	{
		try 
		{
			
			// Creacion de una lista para almacenar las incidencias no nulas
		    List<IncidenciaTic> incidenciasList = new ArrayList<>();
		    //encontramos todas las incidencias y la metemos en la lista
			incidenciasList= incidenciaRepository.findAll();
		    // devolvemos la lista de incidencias
		    return ResponseEntity.ok(incidenciasList);	
		}
		
		catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "motrar incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + " mostrar las incidencias", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
			   
	}
	
	
	/**
	 * metodo para mostrar una incidencia especifica
	 * @param incidenciaTic
	 * @return incidenciaABuscar
	 */
	@RequestMapping(method = RequestMethod.GET, value="/mostrar_incidencia")
	public ResponseEntity<?> mostrarIncidenciasPoId(
			@RequestBody DtoIncidencia incidenciaTic) 
	{
		try 
		{
			IncidenciaTic incidenciaABuscar = new IncidenciaTic();
			
			incidenciaABuscar.setId(incidenciaTic.getId());
			//buscamos incidencia por id
			incidenciaRepository.findById(incidenciaABuscar.getId()).get();
		    
			
		    // devolvemos incidenciaABuscar
		    return ResponseEntity.ok(incidenciaABuscar);	
		}
		
		catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "mostrar incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + " mostrar incidencias", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
			   
	}
	
	
	/**
	 * metodo post para editar una incidencia ya creada
	 * @param incidenciaTic
	 * @return incidenciaActualizada incidrncia ya editada subida a la base de datos
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/editar_incidencia")
	public ResponseEntity<?> editarIncidencia(@RequestBody DtoIncidencia incidenciaTic) 
	{
	    try 
	    {
	    	IncidenciaTic incidenciaAEditar = new IncidenciaTic();
			
	    	incidenciaAEditar.setId(incidenciaTic.getId());
	    	incidenciaAEditar.setNumeroAula(incidenciaTic.getNumeroAula());
	    	incidenciaAEditar.setNombreProfesor(incidenciaTic.getNombreProfesor());
	    	incidenciaAEditar.setTipo(incidenciaTic.getTipo());
	    	incidenciaAEditar.setDescripcionIncidencia(incidenciaTic.getDescripcionIncidencia());
	    	
	    	IncidenciaTic incidenciaActualizada = new IncidenciaTic();
	    	//buscar la incidencia mediante su id
	    	incidenciaActualizada = incidenciaRepository.findById(incidenciaAEditar.getId()).get();
	    	
	    	if(incidenciaRepository.findById(incidenciaAEditar.getId()) != null)
	    	{
	    	
		        if (incidenciaAEditar.getNumeroAula() != null) 
		        {
		        	
		            
		            incidenciaActualizada.setNumeroAula(incidenciaAEditar.getNumeroAula());
		            // comprobar el nuemro de aula y actualizarlo
		            
		        }
		        if (incidenciaAEditar.getNombreProfesor() != null) 
		        {
		            incidenciaActualizada.setNombreProfesor(incidenciaAEditar.getNombreProfesor());
		            // comprobar el nombre del profesor y actualizarlo
		            
		        }
		        if (incidenciaAEditar.getDescripcionIncidencia() != null) 
		        {
		            incidenciaActualizada.setDescripcionIncidencia(incidenciaAEditar.getDescripcionIncidencia());
		            // comprobar la descripcion de la incidencia  y actualizarlo
		            
		        }
		        if (incidenciaAEditar.getStatus() != null) 
		        {
		            incidenciaActualizada.setStatus(incidenciaAEditar.getStatus());
		            // comprobar el estado de la incicdencia y actualizarlo
		            
		        }
		        incidenciaRepository.saveAndFlush(incidenciaActualizada); //con uno basta
	    	}
	    	//devolvemos incidenciaActualizada
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
	 * metodo delete para borrar o cancelar una incidencia estando pendiente
	 * @param incidenciaTic
	 * @return incidenciaABorrar
	 */
	/*@RequestMapping(method = RequestMethod.DELETE, value = "/borrar_incidencia")
	public ResponseEntity<?> cancelarYBorrarPorFormulario(@RequestBody DtoIncidencia incidenciaTic) 
	{
		try 
		{			
			//creamos una icidencia a borrar
			 DtoIncidencia incidenciaABorrar= new DtoIncidencia();
			 //buscamos la incidencia por id y se la aignamos a incidenciaABorrar
			 incidenciaABorrar= incidenciaRepository.getReferenceById(incidenciaTic.getId());
			//comprobamos si la incidencia esta pendiente
			if(incidenciaABorrar.getStatus().equals(Costantes.STD_PENDIENTE)) 
			{
			//se borra por id
			incidenciaRepository.deleteById(incidenciaTic.getId());
			
			} else 
			{
				//controlamos si no esta pendiente
				return ResponseEntity.status(500).body("No puedes cancelarla porque ya no esta pendiente");
			}
			//devolvemos incidenciaABorrar
			return ResponseEntity.ok().body("Incidencia con el id: " + incidenciaTic.getId() + " ha sido borrada correctamente");
			
			
		} catch(Exception exception)
		{
			 IssuesServerException  issuesServerException= new IssuesServerException(Costantes.STD_CODE_ERROR, 
										 Costantes.STD_MESSAGE_ERROR + "borrar incidencia", exception);
			
			log.error(Costantes.STD_MESSAGE_ERROR + "borrar incidencia", issuesServerException);
			
			return ResponseEntity.status(500).body(issuesServerException.getBodyMesagge());
		}
		
	}*/
	@RequestMapping(method = RequestMethod.DELETE, value = "/borrar_incidencia")
	public ResponseEntity<?> cancelarYBorrarPorFormulario(@RequestBody DtoIncidencia incidenciaTic) 
	{
		try 
		{			
			//creamos una icidencia a borrar
			IncidenciaTic incidenciaABorrar = new IncidenciaTic();
			
			incidenciaABorrar.setId(incidenciaTic.getId());
			 
			 //buscamos la incidencia por id y se la aignamos a incidenciaABorrar
			incidenciaRepository.getReferenceById(incidenciaABorrar.getId());
			//comprobamos si la incidencia esta pendiente
			if(incidenciaABorrar.getStatus().equals(Costantes.STD_PENDIENTE)) 
			{
			//se borra por id
			incidenciaRepository.borrarIncidencia(incidenciaABorrar.getId());
			
			} else 
			{
				//controlamos si no esta pendiente
				return ResponseEntity.status(500).body("No puedes cancelarla porque ya no esta pendiente");
			}
			//devolvemos incidenciaABorrar
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
