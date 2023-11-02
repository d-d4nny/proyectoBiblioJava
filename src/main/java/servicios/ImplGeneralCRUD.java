package servicios;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ImplGeneralCRUD {

	public static void insertObject(EntityManager em, Object entityObject) {
        em.getTransaction().begin();
        em.persist(entityObject);
        em.getTransaction().commit();
        System.out.println("Objeto insertado con éxito.");
    }

	public static <T> void selectObjectByField(EntityManager em, T entityObject, String fieldName, Object value) {
        String className = entityObject.getClass().getSimpleName();
        String queryString = "SELECT e FROM " + className + " e WHERE e." + fieldName + " = :value";

        Query query = em.createQuery(queryString);
        query.setParameter("value", value);

        try {
            Object result = query.getSingleResult();
            System.out.println("Objeto encontrado: " + result.toString());
        } catch (Exception e) {
            System.out.println("Objeto no encontrado.");
        }
    }

    public static <T> void updateObject(EntityManager em, T entityObject) {
        em.getTransaction().begin();
        em.merge(entityObject);
        em.getTransaction().commit();
        System.out.println("Objeto actualizado con éxito.");
    }

    public static <T> void deleteObject(EntityManager em, T entityObject) {
        em.getTransaction().begin();
        em.remove(em.contains(entityObject) ? entityObject : em.merge(entityObject));
        em.getTransaction().commit();
        System.out.println("Objeto eliminado con éxito.");
    }
}
