package org.example;

import org.example.Entity.Biblioteca;
import org.example.Service.BibliotecaService;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final BibliotecaService bibliotecaService = new BibliotecaService();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            System.out.println("\nBIBLIOTECAS");
            System.out.println("1. Nueva Biblioteca");
            System.out.println("2. Leer Biblioteca");
            System.out.println("3. Actualizar Biblioteca");
            System.out.println("4. Eliminar Biblioteca");
            System.out.println("5. Lista de Bibliotecas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opccion = scanner.nextInt();
            scanner.nextLine();
            switch (opccion){
                case 1:
crearBiblioteca();
                    break;
                case 2:
leerBiblioteca();
                    break;
                case 3:
actualizarBiblioteca();
                    break;
                case 4:
eliminarBiblioteca();
                    break;
                case 5:
listaDeBibliotecas();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opccion invalida");
            }
        }
    }

    public static void crearBiblioteca(){
        System.out.println("Nombre completo de la biblioteca");
        String nombre = scanner.nextLine();

        System.out.println("Escriba el Id de la biblioteca");
        int id = scanner.nextInt();

        System.out.println("Escriba la direccion de la biblioteca");
        String Direccion = scanner.next();
        System.out.println("");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNombreBiblioteca(nombre);
        biblioteca.setDireccion(Direccion);
        biblioteca.setId(id);

        bibliotecaService.crearBiblioteca(biblioteca);
        System.out.println("Biblioteca creada");
    }


private static void leerBiblioteca(){
    System.out.println("Id de la biblioteca");
    Long id = scanner.nextLong();
    Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(id);

    if (biblioteca != null){
        System.out.println(biblioteca);
    }else{
        System.out.println("Biblioteca no encontrada");
    }
}

private static void actualizarBiblioteca(){
    System.out.println("Id de la biblioteca a actualizar");
    Long id = scanner.nextLong();
    scanner.nextLine();
    Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(id);
    if (biblioteca != null){
        System.out.println("Digite el nuevo nombre de la biblioteca");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()){
            biblioteca.setNombreBiblioteca(nombre);
        }
        System.out.println("Escriba la nueva direccion de la biblioteca");

        String direccion = scanner.nextLine();
        if (!direccion.isEmpty()){
            biblioteca.setDireccion(direccion);
        }
    }




}

private static void  eliminarBiblioteca(){
    System.out.println("Id de la biblioteca a eliminar");
    Long id = scanner.nextLong();
    bibliotecaService.eliminarUsuario(id);
    System.out.println("Usuario eliminado");
}

private static void listaDeBibliotecas(){
    List<Biblioteca> bibliotecas = bibliotecaService.obtenerTodasLasBibliotecas();

    if (bibliotecas.isEmpty()){
        System.out.println("no hay bibliotecas registradas");
    }else{
        for (Biblioteca biblioteca : bibliotecas){
            System.out.println(biblioteca);
        }
    }
}







}