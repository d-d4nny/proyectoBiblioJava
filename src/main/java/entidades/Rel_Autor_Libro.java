package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rel_autores_libros", schema="gbp_operacional")
public class Rel_Autor_Libro {	
	

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rel_autores_libros", nullable=false)
	private long idRelAutorLibro;
	
    @ManyToOne
    @JoinColumn(name="id_libro")
    Libro libro;
    
    @ManyToOne
    @JoinColumn(name="id_autor")
    Autor autor;
    
    
    //CONSTRUCTORES
    public Rel_Autor_Libro() {
    	super();
    }
}
