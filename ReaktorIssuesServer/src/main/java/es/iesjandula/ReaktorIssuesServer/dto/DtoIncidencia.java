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
	
	private boolean check;

	public DtoIncidencia(Long id, Double numeroAula, String nombreProfesor, LocalDateTime fechaActual,
			String descripcionIncidencia, boolean check) {
		super();
		this.id = id;
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
		this.descripcionIncidencia = descripcionIncidencia;
		this.check = false;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Double numeroAula) {
		this.numeroAula = numeroAula;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public LocalDateTime getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDateTime fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getDescripcionIncidencia() {
		return descripcionIncidencia;
	}

	public void setDescripcionIncidencia(String descripcionIncidencia) {
		this.descripcionIncidencia = descripcionIncidencia;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DtoIncidencia [id=");
		builder.append(id);
		builder.append(", numeroAula=");
		builder.append(numeroAula);
		builder.append(", nombreProfesor=");
		builder.append(nombreProfesor);
		builder.append(", fechaActual=");
		builder.append(fechaActual);
		builder.append(", descripcionIncidencia=");
		builder.append(descripcionIncidencia);
		builder.append(", check=");
		builder.append(check);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
