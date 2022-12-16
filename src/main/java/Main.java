import entitys.LibroEntity;
import entitys.SocioEntity;
import jakarta.persistence.*;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

       // insertarSocio();
       // leerSocio();
        insertarLibro();
        //leerLibro();
    }

    public static void insertarSocio() {
        SocioEntity socio = new SocioEntity();
        socio.setCodigo(7);
        socio.setNombre("Jorge");
        socio.setApellidos("Perez");
        socio.setFechaNacimiento(new Date(1990, 12, 12));
        socio.setDomicilio("Calle 1");
        socio.setTelefono("123456789");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(socio);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void insertarLibro() {
        LibroEntity libro = new LibroEntity();
        libro.setCodigo(7);
        libro.setTitulo("Hamburguesas");
        libro.setAutor("Cervantes");
        libro.setEditorial("Anaya");
        libro.setAno(1605);
        libro.setIsbn("123456789");
        libro.setNumeroEjemplares(10);
        libro.setNumeroPaginas(1000);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void leerSocio() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        SocioEntity socio = entityManager.find(SocioEntity.class, 7);
        System.out.println(socio.getNombre());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public static void leerLibro() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Session session = entityManager.unwrap(Session.class);
        LibroEntity libro = session.get(LibroEntity.class, 5);
        if (libro != null) {
            System.out.println(libro.getTitulo());
        }else {
            System.out.println("No existe");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}



