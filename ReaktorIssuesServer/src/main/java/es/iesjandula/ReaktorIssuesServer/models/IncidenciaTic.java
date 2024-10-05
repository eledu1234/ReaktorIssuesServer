package es.iesjandula.ReaktorIssuesServer.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class IncidenciaTic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8935654027241269590L;
	private Double numeroAula;
	private String nombreProfesor;
	private LocalDateTime fechaActual = LocalDateTime.now();
	private String descripcionIncidencia;
	
	
	public IncidenciaTic(Double numeroAula, String nombreProfesor, String descripcionIncidencia) {
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
		this.descripcionIncidencia = descripcionIncidencia;
	}

	public Double getNumeroAula() {
		return numeroAula;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public String getDescripcionIncidencia() {
		return descripcionIncidencia;
	}
	
	
	public LocalDateTime getFechaActual() {
		return fechaActual;
	}


	public void setNumeroAula(Double numeroAula) {
		this.numeroAula = numeroAula;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}


	public void setDescripcionIncidencia(String descripcionIncidencia) {
		this.descripcionIncidencia = descripcionIncidencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcionIncidencia, fechaActual, nombreProfesor, numeroAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidenciaTic other = (IncidenciaTic) obj;
		return Objects.equals(descripcionIncidencia, other.descripcionIncidencia)
				&& Objects.equals(fechaActual, other.fechaActual)
				&& Objects.equals(nombreProfesor, other.nombreProfesor) && Objects.equals(numeroAula, other.numeroAula);
	}

	@Override
	public String toString() {
		return "incidenciaTic [numeroAula=" + numeroAula + ", nombreProfesor=" + nombreProfesor + ", fechaActual="
				+ fechaActual + ", descripcionIncidencia=" + descripcionIncidencia + "]";
	}
	
	

	
	
	
}
