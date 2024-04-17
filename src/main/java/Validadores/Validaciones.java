package Validadores;

/**
 * Esta clase almacena las funciones de validación, siendo un método estático diferente para validar cada uno de los datos que se puedan introducir de un libro. 
 * Si un dato de los introducidos en el alta o edición de un libro no es correcto se mostrará un mensaje de error.
 * @author Francisco Luna Raya
 */
public class Validaciones {
    
    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en el ISBN
     * @param isbn
     */
    public static void validadorIsbn (String isbn){
        
        if (!isbn.matches("^(978|979)\\d{1,5}\\d{1,7}\\d{1,6}\\d$")){
            throw new IllegalArgumentException("\nEl ISBN no es válido");
        }
    }

    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en el título
     * @param titulo
     */
    public static void validadorTitulo (String titulo){
        if (titulo.length() < 3){
            throw new IllegalArgumentException("\nEl titulo debe contener al menos 3 caracteres.");
        }
    }

    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en el año de publicación
     * @param anyoPublicacion
     */
    public static void validadorAnyoPublicacion (int anyoPublicacion){
        if (anyoPublicacion <= 0) {
            throw new IllegalArgumentException("\nEl año de publicación debe de ser superior a 0.");
        }
    }

    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en el nombre y apellidos del autor
     * @param nombreAutor
     * @param apellidosAutor
     */
    public static void validadorAutor (String nombreAutor, String apellidosAutor){
        if (!nombreAutor.matches("^[A-Za-z]{3,}$") || !apellidosAutor.matches("^[A-Za-z]{3,}( [A-Za-z]{3,})?$")){
            
            throw new IllegalArgumentException("\nEl nombre y apellido del autor deben tener al menos 3 caracteres y no pueden contener números");
        }
    }



    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en el genero
     * @param genero
     */
    public static void validadorGenero (String genero){
        if (!genero.equalsIgnoreCase("novela") && !genero.equalsIgnoreCase("ensayo") && !genero.equalsIgnoreCase("teatro") ) {
            throw new IllegalArgumentException("\nEl género debe de ser Novela, Ensayo o Teatro");
        }
    }
    
    /**
     * Esta función nos devuelve un error si no se cumplen los parámetros indicados en la sinopsis
     * @param sinopsis
     */
    public static void validadorSinopsis (String sinopsis){
        if (!sinopsis.matches("^[a-zA-Z].*")) {
            throw new IllegalArgumentException("\nLa sinopsis debe empezar por una letra");
        }
    }
}
