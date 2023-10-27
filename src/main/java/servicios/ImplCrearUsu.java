package servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

import entidades.Acceso;
import entidades.Usuario;

public class ImplCrearUsu {
    public void agregarUsuario() {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del nuevo usuario:");

        System.out.print("DNI del usuario (formato: 12345678A): ");
        String dni = scanner.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos del usuario: ");
        String apellidos = scanner.nextLine();

        System.out.print("Teléfono del usuario (9 números): ");
        String telefono = scanner.nextLine();

        System.out.print("Email del usuario: ");
        String email = scanner.nextLine();


        System.out.print("Clave del usuario: ");
        String clave = scanner.nextLine();


        // Crear una instancia de Usuario con los datos ingresados a través del constructor
        Usuario usuario = new Usuario(
            0, // El valor de idUsuario se asignará automáticamente al persistir en la base de datos
            dni,
            nombre,
            apellidos,
            telefono,
            email,
            clave,
            false,
            null, // fchFinBloqueo
            Calendar.getInstance(), // fchAltaUsuario
            null, // fchBajaUsuario
            new Acceso(1, "Usu","Acceso usuarios biblioteca") // Acceso
        );

        // Iniciar una transacción y guardar el usuario en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(usuario); // Guarda el nuevo usuario en la base de datos
            transaction.commit(); // Confirma la transacción
            System.out.println("Usuario agregado exitosamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            System.err.println("Error al agregar usuario: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    private boolean validarDNI(String dni) {
        return Pattern.matches("\\d{8}[A-Z]", dni);
    }

    private boolean validarTelefono(String telefono) {
        return Pattern.matches("\\d{9}", telefono);
    }

    private boolean validarEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }
}
