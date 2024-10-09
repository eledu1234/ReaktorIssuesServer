package es.iesjandula.ReaktorIssuesServer.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;


public class IssuesServerException extends Exception
{
	/** Serial Version UID */
	private static final long serialVersionUID = 4514190388643824325L ;
	
	/** Codigo de error para la excepcion */
	private int code ;
	
	/** Mensaje de error para la excepcion */
	private String message ;
	
	/** Excepcion de error para la excepcion */
	private Exception exception ;
	
	/**
	 * @param code código del error
	 * @param message mensaje del error
	 */
	public IssuesServerException(int code, String message) 
	{
		super(message);
		
		this.code 	 = code ;
		this.message = message ;
	}
	/**
	 * 
	 * @param code código del error
	 * @param message mensaje del error
	 * @param exception excepcion del error
	 */
	public IssuesServerException(int code, String message, Exception exception) 
	{
		super(message,exception) ;
		
		this.code 	   = code ;
		this.message   = message ;
		this.exception = exception ;
	}
	
	
	/**
	 * Metodo que mapea el error para mostrarlo de forma ordenada al usuario
	 * @return mapException con clave valor <String,String>
	 */
	public Map<String, String> StackTrace()
	{
		Map <String, String> mapException= new HashMap<String, String>();
		
		mapException.put("code", String.valueOf(code));
		mapException.put("message", message);
		
		if(this.exception != null)
		{
			String stackTrace = ExceptionUtils.getStackTrace(this.exception);
			mapException.put("stackTrace", stackTrace);
		}
		return mapException;
	}
	
}
