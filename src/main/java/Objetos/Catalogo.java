package Objetos;
/**
 * Esta clase almacenará todos los libros de la biblioteca en una colección de datos del tipo TreeMap. 
 * Esta clase tendrá métodos para realizar las opciones de menú indicadas en la descripción 
 * funcional tales como: dar de alta un libro, obtener un listado de libros, etc. 
 * Habrá un método para cada opción pero puede haber todos los métodos adicionales que quieras y 
 * también campos, etc. 
 * El programa principal interactuará con un objeto de esta clase para hacer lo
 * que se le pide para cada opción de menú.
 * @author Francisco Luna Raya
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Catalogo {
    
    private TreeMap <String, Libro> listadoLibros;

    /**
     * Inicializamos nuestro catálogo haciendo uso de un treemap ordenado
     * por el String del ISBN.
     */
    public Catalogo(){
        this.listadoLibros = new TreeMap<>();
        iniciarLibrosPredefinidos();
    }

    /**
     * En este método vamos a introducir 5 libros 
     * en nuestro catálogo de manera automática, para que cada vez
     * que se inicialice el programa estén estos 5.
     */
    private void iniciarLibrosPredefinidos(){
        listadoLibros.put("9788437604947", new Libro("9788437604947", "Cien años de soledad", 1967, new Persona("Gabriel", "García Márquez"), "Novela", "- La historia de la familia Buendía en el pueblo ficticio de Macondo."));
        listadoLibros.put("9788432217256", new Libro("9788432217256", "El amor en los tiempos del cólera", 1985, new Persona("Gabriel", "García Márquez"), "Novela", "- La historia de amor entre Florentino Ariza y Fermina Daza."));
        listadoLibros.put("9788497932399", new Libro("9788497932399", "Don Quijote de la Mancha", 1605, new Persona("Miguel de", "Cervantes"), "Novela", "- Las aventuras de un hidalgo que se vuelve loco leyendo libros de caballería."));
        listadoLibros.put("9788420655665", new Libro("9788420655665", "La casa de los espíritus", 1982, new Persona("Isabel", "Allende"), "Novela", "- La saga de la familia Trueba en un país latinoamericano ficticio."));
        listadoLibros.put("9788408089454", new Libro("9788408089454", "El laberinto de los espíritus", 2016, new Persona("Carlos", "Ruiz Zafón"), "Novela", "- La última entrega de la saga del Cementerio de los Libros Olvidados.")); 
    }

    /**
     * En esta función solicitamos el ISBN y lo comparamos con nuestro catalogo para ver si existe ya.
     * Si existe nos devolverá un true, es decir, no podremos crear nuestro libro,
     * si no existe, nos devolverá un false, es decir, podremos crear nuestro libro.
     * @param isbn
     * @return
     */
    public boolean isbnExiste (String isbn){

        if(listadoLibros.containsKey(isbn)){
            return true;
        }else{
            return false;  
        }
    }

    /**
     * Esta función nos devuelve un String con los datos de cada libro.
     * @return
     */
    public String devolverListadoLibros(){
        
        StringBuilder datosLibros = new StringBuilder();

        for (Libro libro : listadoLibros.values()) {
            datosLibros.append(libro.toString()).append("\n");
        }
    
        return datosLibros.toString();
    }
    
    /**
     * En esta función damos de alta al libro en nuestro catálogo, para ello hacemos uso de la
     * función isbnExiste para saber si nuestro isbn existe o no y si NO existe, los datos solicitados
     * son introducidos en nuestro catalogo para crear así ese libro.
     * @param isbn
     * @param titulo
     * @param anyoPublicacion
     * @param nombreAutor
     * @param apellidosAutor
     * @param genero
     * @param sinopsis
     * @return
     */
    public String altaLibro (String isbn, String titulo, int anyoPublicacion, String nombreAutor, String apellidosAutor, String genero, String sinopsis){
        
        if(!isbnExiste(isbn)){
            listadoLibros.put(isbn, new Libro(isbn, titulo, anyoPublicacion, new Persona(nombreAutor, apellidosAutor), genero, sinopsis));
            return "\nLibro dado de alta correctamente.";
        }else{
            throw new IllegalArgumentException("\nEl ISBN ya existe, y no se ha podido crear correctamente");
        }
    }

    /**
     * En esta función editamos a un libro de nuestro catálogo, para ello hacemos uso de la
     * función isbnExiste para saber si nuestro isbn existe o no y si existe, los datos solicitados
     * son introducidos en nuestro catalogo, sustituyendo los datos anteriores.
     * @param isbn
     * @param titulo
     * @param anyoPublicacion
     * @param nombreAutor
     * @param apellidosAutor
     * @param genero
     * @param sinopsis
     * @return
     */
    public String editarLibro (String isbn, String titulo, int anyoPublicacion, String nombreAutor, String apellidosAutor, String genero, String sinopsis){

        if (isbnExiste(isbn)){
            listadoLibros.put(isbn, new Libro(isbn, titulo, anyoPublicacion, new Persona(nombreAutor, apellidosAutor), genero, sinopsis));
            return "\nEl libro ha sido editado correctamente";
        }else{
            throw new IllegalArgumentException("\nEl ISBN no existe, primero deberá crear el libro");
        }
    }

    /**
     * En esta función comprabamos el ISBN y vemos que si existe nos envie un mensaje de confirmación para 
     * borrar el libro donde nos devuelve el ISBN del libro y el titulo y debemos responder con S si queremos
     * darle de baja o N si queremos dejarlo tal y como está.
     * @param isbn
     */
    public void bajaLibro (String isbn){
        
        if (isbnExiste(isbn)) {
            Scanner scanner = new Scanner(System.in);
            Libro libro = listadoLibros.get(isbn);
            System.out.println("\n¿Está seguro de que desea borrar el libro con ISBN: " + isbn + " y Título: " + libro.getTitulo() + " ? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                scanner.close();
                listadoLibros.remove(isbn);
                System.out.println("\nEl libro ha sido eliminado del catálogo.");
            } else {
                scanner.close();
                System.out.println("\nEl libro no ha sido eliminado del catálogo.");
            }
            
        }else{
            throw new IllegalArgumentException("\nEl ISBN introducido no existe");
        }
    }

    /**
     * En esta función vamos a buscar un libro por su titulo, para ello debemos obtener los
     * datos de todos los libros de nuestro catalogo y obtener de ellos los titulos y compararlos 
     * con nuestro titulo introducido y nos devuelven los libros que coincidan totalmente o parcialmente con 
     * el titulo introducido en la busqueda.
     * @param textoBusqueda
     */
    public void buscarLibroPorTitulo(String textoBusqueda) {
    
        textoBusqueda = textoBusqueda.toLowerCase();
        boolean coincide = false;

        for (Libro libro : listadoLibros.values()) {
            String tituloLibro = libro.getTitulo().toLowerCase();

            if (tituloLibro.contains(textoBusqueda)) {
                
                if (!coincide) {
                    System.out.println("\nLibros que coinciden con '" + textoBusqueda + "':");
                    coincide = true;
                }
                System.out.println(libro.toString());
            }
        }
        if (!coincide) {
            System.out.println("\nNo se encontraron libros que coincidan con ' " + textoBusqueda + " '.");
        }
    } 

    /**
     * En esta función vamos a buscar un libro por su año de publicación, para ello debemos obtener los
     * datos de todos los libros de nuestro catalogo y obtener de ellos los años y compararlos a nuestro año 
     * introducido.
     * Y nos devuelve los datos de los libros que hayan sido publicados en esos años.
     * @param anyoBusqueda
     */
    public void buscarLibroPorAnyo(int anyoBusqueda) {
    
        boolean coincide = false;

        for (Libro libro : listadoLibros.values()) {
            Integer anyoLibro = libro.getAnyoPublicacion();

            if (anyoLibro.equals(anyoBusqueda)) {
                
                if (!coincide) {
                    System.out.println("\nLibros que hayan sido publicados en el año" + anyoBusqueda + ":");
                    coincide = true;
                }
                System.out.println(libro.toString());
            }
        }
        if (!coincide) {
            System.out.println("\nNo se encontraron libros que hayan sido publicados en el año " + anyoBusqueda + ".");
        }
    } 
    
    public void listaOrdenadaTitulo (){
        
        Comparator<Libro> comparador = (libro1, libro2) -> libro1.getTitulo().compareToIgnoreCase(libro2.getTitulo());

        List<Libro> listaOrdenada = new ArrayList<>(listadoLibros.values());
        Collections.sort(listaOrdenada, comparador);

        System.out.println("\nListado de libros ordenado por título:");
        for (Libro libro : listaOrdenada) {
            System.out.println(libro.toString());
        }
    }

    public void listaOrdenadaAnyoAutor (){
        Comparator<Libro> comparador = (libro1, libro2) -> {
            
            int comparacionAnio = Integer.compare(libro1.getAnyoPublicacion(), libro2.getAnyoPublicacion());
            if (comparacionAnio != 0) {
                return comparacionAnio; 
            } else {
                String nombreCompleto1 = libro1.getAutor().getApellidos() + libro1.getAutor().getNombre();
                String nombreCompleto2 = libro2.getAutor().getApellidos() + libro2.getAutor().getNombre();
                return nombreCompleto1.compareToIgnoreCase(nombreCompleto2); 
            }
        };

        List<Libro> listaOrdenada = new ArrayList<>(listadoLibros.values());
        Collections.sort(listaOrdenada, comparador);

        System.out.println("\nListado de libros ordenado por año de publicación y autor:");
        for (Libro libro : listaOrdenada) {
            System.out.println(libro.toString());
        }
    }
}

