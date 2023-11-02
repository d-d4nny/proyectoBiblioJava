package controladores;

import entidades.Acceso;
import entidades.Coleccion;
import entidades.Editorial;
import entidades.Genero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import servicios.ImplCrearLibroAutor;
import servicios.ImplUsuarioCRUD;

public class Inicio {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
    	
    	
    	//Acceso acceso = new Acceso(1, "Usu","Acceso usuarios biblioteca");
		//Acceso acceso2 = new Acceso(2, "Emp","Empleados biblioteca");
    	
	    //em.getTransaction().begin();
		//em.persist(acceso);
		//em.persist(acceso2);
		//em.getTransaction().commit();
		
		//ImplUsuarioCRUD usuCrud = new ImplUsuarioCRUD();
		
		
		//Editorial editorial = new Editorial(1, "Panini");
		//Genero genero = new Genero(1,"ficcion","genero de ficcion");
		//Coleccion coleccion = new Coleccion(1,"coleccion1");
		
		//em.getTransaction().begin();
		//em.persist(editorial);
		//em.persist(genero);
		//em.persist(coleccion);
		//em.getTransaction().commit();
		
		//ImplCrearLibroAutor newLibAut = new ImplCrearLibroAutor();
		
		//em.getTransaction().begin();
		//usuCrud.menuUserCRUD();
		//newLibAut.crearLibroAutor();
	    //em.getTransaction().commit();
		//em.close();
        //emf.close();
	}

}
