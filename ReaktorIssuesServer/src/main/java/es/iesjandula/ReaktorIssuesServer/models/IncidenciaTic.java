package es.iesjandula.ReaktorIssuesServer.models;

<<<<<<< Updated upstream
import java.time.LocalDateTime;

=======
>>>>>>> Stashed changes
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
	@Column (length=10)
	private String numeroAula;
	
	/**
	 * atributo para registrar el nombre del profesor
	 */

	@Column (length=100)
	private String nombreProfesor;
	
	/**
	 * atributo para registrar la fecha y hora
	 */

<<<<<<< Updated upstream
	@Column(nullable = false)
	private LocalDateTime fechaActual = LocalDateTime.now();
=======
	@Column(length = 50)
	private String fechaActual;
>>>>>>> Stashed changes
	
	/**
	 * atributo para regitrar la descripccion de la incidencia
	 */

	@Column (length=400)
	private String descripcionIncidencia;
	
	/**
	 * atributo para identificar si esta resuelta
	 */

	
	@Column (length=15)
	private String status=Costantes.STD_PENDIENTE;
	
	
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
	public IncidenciaTic(String numeroAula, String nombreProfesor,
<<<<<<< Updated upstream
			String descripcionIncidencia) {
		super();
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = LocalDateTime.now();
=======
			String descripcionIncidencia, String fechaActural) {
		super();
		this.numeroAula = numeroAula;
		this.nombreProfesor = nombreProfesor;
		this.fechaActual = fechaActural;
>>>>>>> Stashed changes
		this.descripcionIncidencia = descripcionIncidencia;
		
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

<<<<<<< Updated upstream
	public LocalDateTime getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDateTime fechaActual) {
=======
	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
>>>>>>> Stashed changes
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
