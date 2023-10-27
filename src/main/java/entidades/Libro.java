package entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="libros", schema="gbp_operacional")
public class Libro {	
	

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_libro", nullable=false)
	private long idLibro;
	
	@Column(name="isbn_libro", nullable=false)
	private String isbnLibro;
	
	@Column(name="titulo_libro")
	private String tituloLibro;
	
	@Column(name="edicion_libro")
	private String edicionLibro;
	
	@ManyToOne
    @JoinColumn(name="id_editorial")
    Editorial editorial;
	
	@ManyToOne
    @JoinColumn(name="id_genero")
    Genero genero;
	
	@ManyToOne
    @JoinColumn(name="id_coleccion")
    Coleccion coleccion;
	
	@OneToMany(mappedBy="libro")
    List<Rel_Autor_Libro> libroRelAutorLibro;
	
	//CONSTRUCTORES
	public Libro() {
		super();
	}

	public Libro(long idLibro, String isbnLibro, String tituloLibro, String edicionLibro, Editorial editorial,
			Genero genero, Coleccion coleccion) {
		super();
		
		this.idLibro = idLibro;
		this.isbnLibro = isbnLibro;
		this.tituloLibro = tituloLibro;
		this.edicionLibro = edicionLibro;
		this.editorial = editorial;
		this.genero = genero;
		this.coleccion = coleccion;
	}
}
