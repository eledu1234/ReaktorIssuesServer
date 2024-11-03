package es.iesjandula.reaktor_Issues_Server.models;

import java.time.LocalDateTime;

import es.iesjandula.reaktor_Issues_Server.utils.Costantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="incidencia")
public class IncidenciaTic{
	
	/**
	 * atributo unico id para identifica incidencia
	 */
	@Id
	@Column (length=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * atributo para registrar el numero de aula
	 */
	@Column (length=30)
	private String numeroAula;
	
	/**
	 * atributo para registrar el nombre del profesor
	 */

	@Column (length=100)
	private String nombreProfesor;
	
	/**
	 * atributo para registrar la fecha y hora
	 */

	@Column(nullable = false)
	private LocalDateTime fechaActual;
	
	/**
	 * atributo para regitrar la descripccion de la incidencia
	 */

	@Column (length=15)
	private String tipo;
	
	/**
	 * contructor vacio
	 */
	
	@Column (length=400)
	private String descripcionIncidencia;
	
	/**
	 * atributo para identificar si esta resuelta
	 */

	
	@Column (length=15)
	private String status;
	
	
	/**
	 * contructor vacio
	 */
	public IncidenciaTic() {
		
	}

	/**
	 * constructor de la clase IncidenciaTic
	 * @param numeroAula
	 * @param nombreProfesor
	 * @param descripcionIncidencia
	 */
	public IncidenciaTic(String numeroAula, String nombreProfesor, String tipo,
			String descripcionIncidencia) {
		super();
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
		this.tipo = tipo;
		this.descripcionIncidencia = descripcionIncidencia;
		this.status =Costantes.STD_PENDIENTE;
		
	}
	/**
	 * getters y setters de la clase IncidenciaTic
	 * 
	 */
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(String numeroAula) {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	
	/**
	 * metodo toString para mostrar el objeto
	 */
	@Override
	public String toString() {
		return "IncidenciaTic [id=" + id + ", numeroAula=" + numeroAula + ", nombreProfesor=" + nombreProfesor
				+ ", fechaActual=" + fechaActual + ", descripcionIncidencia=" + descripcionIncidencia + ", status="
				+ status + "]";
	}

	
	

	
	
	
}
