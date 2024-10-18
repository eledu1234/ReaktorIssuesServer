package es.iesjandula.ReaktorIssuesServer.models;

import java.time.LocalDateTime;

import es.iesjandula.ReaktorIssuesServer.utils.Costantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="incidencia")
public class IncidenciaTic{
	
	@Id
	@Column (length=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (length=10)
	private Double numeroAula;
	
	@Column (length=100)
	private String nombreProfesor;
	
	@Column(nullable = false)
	private LocalDateTime fechaActual = LocalDateTime.now();
	
	@Column (length=400)
	private String descripcionIncidencia;
	
	@Column (length=15)
	private String status=Costantes.STD_PENDIENTE;
	
	
	public IncidenciaTic() {
		
	}

	public IncidenciaTic(Double numeroAula, String nombreProfesor,
			String descripcionIncidencia) {
		super();
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
		this.descripcionIncidencia = descripcionIncidencia;
		
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IncidenciaTic [id=" + id + ", numeroAula=" + numeroAula + ", nombreProfesor=" + nombreProfesor
				+ ", fechaActual=" + fechaActual + ", descripcionIncidencia=" + descripcionIncidencia + ", status="
				+ status + "]";
	}

	
	

	
	
	
}
