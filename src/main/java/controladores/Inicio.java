package controladores;

import entidades.Acceso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import servicios.ImplCrearUsu;

public class Inicio {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
    	
    	
    	Acceso acceso = new Acceso(1, "Usu","Acceso usuarios biblioteca");
		Acceso acceso2 = new Acceso(2, "Emp","Empleados biblioteca");
    	
		em.persist(acceso);
		em.persist(acceso2);
		
		ImplCrearUsu newUsu = new ImplCrearUsu();
		
		newUsu.agregarUsuario();

		em.close();
        emf.close();
	}

}
