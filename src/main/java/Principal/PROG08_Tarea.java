package Principal;

import java.util.Scanner;
import Objetos.*;
import Validadores.Validaciones;
/**
 *
 * @author fluna
 */
public class PROG08_Tarea {

    static Scanner scanner = new Scanner(System.in);
    static Catalogo catalogo = new Catalogo();

    static String isbn;
    static String titulo;
    static int anyoPublicacion;
    static String nombreAutor;
    static String apellidosAutor;
    static Persona autor;
    static String genero;
    static String sinopsis;

    public static void main(String[] args) {
        
        int eleccion;

        do {
            menu();

            System.out.println("\nIntroduzca un número acorde al menú (1-7) ");
            
            eleccion = scanner.nextInt();
            if (0 < eleccion && eleccion < 8) {
                switch (eleccion) {
                    case 1:
                        catalogo.devolverListadoLibros();
                        scanner.nextLine();
                        break;
                    case 2:
                        altaNuevoLibro();
                        scanner.nextLine();
                        break;
                    case 3:

                        scanner.nextLine();
                        break;
                    case 4:
                        
                        scanner.nextLine();
                        break;
                    case 5:
                        
                        scanner.nextLine();
                        break;
                    case 6:
                        
                        scanner.nextLine();
                        break;
                    case 7:
                        scanner.nextLine();
                        break;
                    case 8:
                        scanner.nextLine();
                        break; 
                    case 9:
                        System.out.println("\nHasta la próxima");
                        break;
                    default:
                        System.out.println("\nERROR");
                        break;
                }
            }else{
                System.out.println("\nDebe introducir un número acorde al menú (1-9)");
                scanner.nextLine();
            }
        } while (eleccion != 9);
    }
    
    /**
     * Esta función devuelve el texto del menú visual
     */
    public static void menu(){

        System.out.println("\n====MENÚ PRINCIPAL====");
        System.out.println(" 1. Mostrar listado completo de libros");
        System.out.println(" 2. Dar de alta un nuevo libro");
        System.out.println(" 3. Editar un libro existente");
        System.out.println(" 4. Dar de baja un libro existente");
        System.out.println(" 5. Buscar un libro por título");
        System.out.println(" 6. Buscar un libro por año de publicación");
        System.out.println(" 7. Mostrar listado de libros ordenado por título");
        System.out.println(" 8. Mostrar listado de libros ordenado por año de publicación y autor");
        System.out.println(" 9. Salir");
    }

    public static void altaNuevoLibro(){
        
        boolean isbnValido = false;
        do {
            System.out.println("\nIntroduzca un ISBN valido: ");
            isbn = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorIsbn(isbn);
                isbnValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isbnValido);

        boolean tituloValido = false;
        do {
            System.out.println("\nIntroduzca el título del libro: ");
            titulo = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorTitulo(titulo);
                tituloValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!tituloValido);

        boolean anyoValido = false;
        do {
            System.out.println("\nIntroduzca el año de publicación del libro: ");
            anyoPublicacion = scanner.nextInt();
            try {
                Validaciones.validadorAnyoPublicacion(anyoPublicacion);
                anyoValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!anyoValido);

        boolean autorValido = false;
        do {
            System.out.println("\nIntroduzca el nombre del autor: ");
            nombreAutor = scanner.nextLine();
            scanner.nextLine();
            System.out.println("\nIntroduzca el apellido o los apellidos del autor: ");
            apellidosAutor = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorAutor(nombreAutor, apellidosAutor);
                Persona autor = new Persona(nombreAutor, apellidosAutor);
                autorValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!autorValido);

        boolean generoValido = false;
        do {
            System.out.println("\nIntroduzca el género del libro: ");
            genero = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorGenero(genero);
                generoValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!generoValido);

        boolean sinopsisValido = false;
        do {
            System.out.println("\nIntroduzca la sinopsis del libro: ");
            sinopsis = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorSinopsis(sinopsis);
                sinopsisValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!sinopsisValido);
        
        catalogo.altaLibro(isbn, titulo, anyoPublicacion, nombreAutor, apellidosAutor, genero, sinopsis);
        
    }
}

