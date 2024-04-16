package Validadores;

/**
 *
 * @author fluna
 */
public class Validaciones {
    
    public static void validadorIsbn (String isbn){
        if (!isbn.matches("^-.*")) {
            throw new IllegalArgumentException("\nEl ISBN introducido es erróneo");
        }
    }

    public static void validadorTitulo (String titulo){
        if (!titulo.matches(titulo)){
            throw new IllegalArgumentException("El titulo debe contener al menos 3 letras");
        }
    }
    public static void validadorAnyoPublicacion (int anyoPublicacion){
        if (anyoPublicacion < 0) {
            throw new IllegalArgumentException("\nEl año de publicación debe de ser superior a 0.");
        }
    }

    public static void validadorAutor (String nombreAutor, String apellidosAutor){
        if (!nombreAutor.matches(apellidosAutor) || !apellidosAutor.matches(apellidosAutor)) {
            throw new IllegalArgumentException("\nEl nombre y apellido del autor debe de ser superior a 3 letras y no contener números");
        }
    }

    public static void validadorGenero (String genero){
        if (!genero.toLowerCase().matches("novela, ensayo o teatro")) {
            throw new IllegalArgumentException("\nEl género debe de ser Novela, Ensayo o Teatro");
        }
    }
    
    public static void validadorSinopsis (String sinopsis){
        if (!sinopsis.matches("^-.*")) {
            throw new IllegalArgumentException("La sinopsis debe empezar por \"-\"");
        }
    }
}
