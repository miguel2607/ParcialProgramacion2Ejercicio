package org.example.Entity;

import jakarta.persistence.*;

public class BibliotecaListener {

    @PrePersist

    public void prePersist(Biblioteca biblioteca){
        System.out.println("Biblioteca a ser persistida " + biblioteca );
    }

    @PostPersist
    public void postPersist(Biblioteca biblioteca){
        System.out.println("Biblioteca a ser persistida " + biblioteca);
    }

    @PreUpdate
    public  void preUpdate(Biblioteca biblioteca){
        System.out.println("Biblioteca a ser actualizada " + biblioteca);

    }

    @PostUpdate
    public void posUpdate(Biblioteca biblioteca){
        System.out.println("Biblioteca a ser actualizada " + biblioteca);

    }


    @PreRemove
    public void preRemove(Biblioteca biblioteca ){
        System.out.println("Biblioteca a ser eliminada " + biblioteca);

    }

    @PostRemove
    public void postRemove(Biblioteca biblioteca){
        System.out.println("Biblioteca eliminada" + biblioteca);
    }



}
