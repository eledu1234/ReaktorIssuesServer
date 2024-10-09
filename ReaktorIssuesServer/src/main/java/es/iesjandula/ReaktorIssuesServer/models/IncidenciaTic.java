package es.iesjandula.ReaktorIssuesServer.models;

import java.time.LocalDateTime;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="incidencia")
public class IncidenciaTic{
	
	@Id
	@Column (length=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (length=10, unique=true)
	private Double numeroAula;
	
	@Column (length=100)
	private String nombreProfesor;
	
	@Column(nullable = false)
	private LocalDateTime fechaActual = LocalDateTime.now();
	
	@Column (length=400)
	private String descripcionIncidencia;
	
	@Column ()
	private boolean check = false;
	
	
	
	

	public IncidenciaTic(Integer id, Double numeroAula, String nombreProfesor, LocalDateTime fechaActual,
			String descripcionIncidencia, boolean check) {
		super();
		this.id = id;
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
		this.descripcionIncidencia = descripcionIncidencia;
		this.check = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "IncidenciaTic [id=" + id + ", numeroAula=" + numeroAula + ", nombreProfesor=" + nombreProfesor
				+ ", fechaActual=" + fechaActual + ", descripcionIncidencia=" + descripcionIncidencia + ", check="
				+ check + "]";
	}

	
	

	
	
	
}
