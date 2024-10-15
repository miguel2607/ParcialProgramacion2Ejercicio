package org.example.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Entity.Biblioteca;

import java.util.List;

public class BibliotecaRepository {
    private final EntityManagerFactory emf;


    public BibliotecaRepository (){
        emf = Persistence.createEntityManagerFactory("UniversidadPU");
    }

    public void crearBiblioteca (Biblioteca biblioteca){

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(biblioteca);
            em.getTransaction().commit();
        }
    }

    public Biblioteca leerBiblioteca(Long id){
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Biblioteca.class, id);
        }finally {
            em.close();
        }
    }

    public List<Biblioteca> leerBibliotecas(){
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT B FROM b", Biblioteca.class)
                    .getResultList();
        }
    }

    public void ActualizarBiblioteca(Biblioteca biblioteca){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(biblioteca);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }


    public void eliminarBiblioteca(Long id){

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Biblioteca biblioteca = em.find(Biblioteca.class , id);

            if (biblioteca != null){
                em.remove(biblioteca);
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }





    public void cerrar (){
        emf.close();
    }






}
