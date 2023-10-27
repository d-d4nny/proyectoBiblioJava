package entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="autores", schema="gbp_operacional")
public class Autor {	
	

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_autor", nullable=false)
	private long idAutor;
	
	@Column(name="nombre_autor")
	private String nombreAutor;
	
	@Column(name="apellidos_autor")
	private String apellidosAutor;
	
    @OneToMany(mappedBy="autor")
    List<Rel_Autor_Libro> autoresRelAutorLibro;

    
	//CONSTRUCTORES
    public Autor() {
    	super();
    }


	public Autor(String nombreAutor, String apellidosAutor) {
		super();
		
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
	}
    
    
}
