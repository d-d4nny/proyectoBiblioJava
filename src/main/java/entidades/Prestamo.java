package entidades;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="prestamo", schema="gbp_operacional")
public class Prestamo {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prestamo", nullable=false)
	private long idPrestamo;
	
	@Column(name="fch_inicio_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchInicioPrestamo;
	
	@Column(name="fch_fin_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchFinPrestamo;
	
	@Column(name="fch_entrega_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchEntregaPrestamo;
	
	@ManyToOne
    @JoinColumn(name="id_libro")
    Libro libro;
	
	@ManyToOne
    @JoinColumn(name="id_usuario")
    Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name="id_estado_prestamo")
    Estado_Prestamo estadoPrestamo;
	
	//CONSTRUCTORES
	public Prestamo() {
		super();
	}

	public Prestamo(long idPrestamo, Calendar fchInicioPrestamo, Calendar fchFinPrestamo, Calendar fchEntregaPrestamo,
			Libro libro, Usuario usuario, Estado_Prestamo estadoPrestamo) {
		super();
		this.idPrestamo = idPrestamo;
		this.fchInicioPrestamo = fchInicioPrestamo;
		this.fchFinPrestamo = fchFinPrestamo;
		this.fchEntregaPrestamo = fchEntregaPrestamo;
		this.libro = libro;
		this.usuario = usuario;
		this.estadoPrestamo = estadoPrestamo;
	}
	
	
	
	

}
