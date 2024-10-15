package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Bibliotecas")
@EntityListeners(Biblioteca.class)


public class Biblioteca {
@Column (nullable = false)
    private String nombreBiblioteca;

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


@Column (nullable = false)
private String direccion;

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreBiblioteca='" + nombreBiblioteca + '\'' +
                ", id=" + id +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
