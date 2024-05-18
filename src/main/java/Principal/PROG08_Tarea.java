package Principal;

import java.util.Scanner;


import Objetos.*;
import Validadores.Validaciones;
/**
 * Esta clase se encarga de ejecutar el programa además de la funciones con el usuario,
 * haciendo de puente entre las otras clases y el usuario.
 * @author Francisco Luna Raya
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
        
        catalogo.iniciarLibrosPredefinidos();
        
        int eleccion;

        do {
            menu();

            System.out.println("\nIntroduzca un número acorde al menú (1-9) ");
            
            eleccion = scanner.nextInt();
            if (0 < eleccion && eleccion < 10) {
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
                        editarLibro();
                        scanner.nextLine();
                        break;
                    case 4:
                        bajaLibro();
                        scanner.nextLine();
                        break;
                    case 5:
                        buscarPorTitulo();
                        scanner.nextLine();
                        break;
                    case 6:
                        buscarPorAnyo();
                        scanner.nextLine();
                        break;
                    case 7:
                        catalogo.listaOrdenadaTitulo();
                        scanner.nextLine();
                        break;
                    case 8:
                        catalogo.listaOrdenadaAnyoAutor();
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

    /**
     * Con esta opción se solicitará por consola primero el ISBN del nuevo libro que se quiere dar de alta. 
     * Si ya existe un libro con ese ISBN se mostrará un mensaje de error y se indicará que no se puede dar de alta por este motivo. 
     * Si no, se irán pidiendo todos los datos necesarios de un libro por consola y se dará de alta.
     */
    public static void altaNuevoLibro(){
        
        boolean isbnValido = false;
        do {
            System.out.println("\nIntroduzca un ISBN valido: ");
            isbn = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorIsbn(isbn);
                isbnValido = true;
                catalogo.isbnExiste(isbn);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isbnValido);

        if (!catalogo.isbnExiste(isbn)) {
            
        
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
        }else{

            System.out.println("\nEl ISBN ya existe, y no se ha podido crear correctamente");
        }
        
    }

    /**
     * Con esta opción se solicitará por consola primero el ISBN del libro que se quiere editar. 
     * Si ya existe un libro con ese ISBN se irán solicitando todos los datos restantes del libro por consola y una vez introducidos todos se actualizará. 
     * Si no existe ningún libro con ese ISBN, se mostrará un mensaje de error.
     */
    public static void editarLibro(){

        boolean isbnValido = false;
        do {
            System.out.println("\nIntroduzca el ISBN del libro que desea editar: ");
            isbn = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorIsbn(isbn);
                isbnValido = true;
                catalogo.isbnExiste(isbn);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isbnValido);

        if (catalogo.isbnExiste(isbn)) {
            
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

            catalogo.editarLibro(isbn, titulo, anyoPublicacion, nombreAutor, apellidosAutor, genero, sinopsis);
        }else{

            System.out.println("\nEl ISBN no existe, primero deberá crear el libro");
        }
    }

    /**
     * Con esta opción se solicitará por consola primero el ISBN del libro que se quiere dar de baja. 
     * Si no existe un libro con ese ISBN se mostrará un mensaje de error al usuario. Si por el contrario si que existe, 
     * se mostrará un mensaje de confirmación indicando si está seguro de que se quiere borrar el libro con ISBN xxxx y Título yyyy 
     * (donde xxxx e yyyy son el ISBN y título del libro respectivamente). 
     * Si el usuario responde con la letra s el libro se borrará. De lo contrario, se dejará en el catálogo.
     */
    public static void bajaLibro (){
        
        boolean isbnValido = false;
        do {
            System.out.println("\nIntroduzca el ISBN del libro que desea editar: ");
            isbn = scanner.nextLine();
            scanner.nextLine();
            try {
                Validaciones.validadorIsbn(isbn);
                isbnValido = true;
                catalogo.bajaLibro(isbn);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isbnValido);
        
    }

    /**
     * Con esta opción se solicitará al usuario un texto para realizar una búsqueda de todos aquellos libros que contengan dicho texto en alguna parte del título. 
     * No se tendrá en cuenta mayúsculas ni minúsculas y se mostrará un listado de los libros encontrados como el de la opción 1. 
     * Si no se encuentra ningún libro se mostrará un mensaje por consola informando al usuario.
     */
    public static void buscarPorTitulo (){
        System.out.println("\nIntroduzca el título o palabra clave del libro que desea buscar: ");
        String textoBuscar = scanner.nextLine();
        while (textoBuscar.isEmpty()) {
            textoBuscar = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
            if (textoBuscar.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }
        catalogo.buscarLibroPorTitulo(textoBuscar);
    }

    /**
     * Con esta opción se solicitará al usuario un año para buscar todos aquellos libros cuyo año de publicación coincida con el introducido monstrándose 
     * un listado de los libros encontrados como el de la opción 1. 
     * Si no se encuentra ningún libro se mostrará un mensaje por consola informando al usuario.
     */
    public static void buscarPorAnyo (){
        System.out.println("\nIntroduzca el año de publicación del libro que desea buscar: ");
        int anyoBuscar = scanner.nextInt();
        catalogo.buscarLibroPorAnyo(anyoBuscar);
    }

}

