package org.example.Service;

import org.example.Entity.Biblioteca;
import org.example.Repository.BibliotecaRepository;

import java.util.List;

public class BibliotecaService {

    private final BibliotecaRepository repository;


    public BibliotecaService() {
        this.repository = new BibliotecaRepository();
    }

    public void crearBiblioteca(Biblioteca biblioteca){
        repository.crearBiblioteca(biblioteca);
    }
    public Biblioteca obtenerBiblioteca (Long id){
        return repository.leerBiblioteca(id);
    }
    public List<Biblioteca> obtenerTodasLasBibliotecas() {
        return repository.leerBibliotecas();
    }

    public void actualizarBibliotecas(Biblioteca biblioteca) {

        repository.ActualizarBiblioteca(biblioteca);
    }

    public void eliminarUsuario(Long id)
    {
        repository.eliminarBiblioteca(id);
    }

    public void cerrar() {
        repository.cerrar();
    }




}
