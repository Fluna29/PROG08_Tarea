package Objetos;

/**
 * Esta clase permitirá almacenar la información de todos los libros del catálogo
 * de la biblioteca.
 * @author Francisco Luna Raya
 */
public class Libro {
    private String isbn;
    private String titulo;
    private int anyoPublicacion;
    private Persona autor;
    private String genero;
    private String sinopsis;

    public Libro (String isbn, String titulo, int anyoPublicacion, Persona autor, String genero, String sinopsis){
        this.isbn = isbn;
        this.titulo = titulo;
        this.anyoPublicacion = anyoPublicacion;
        this.autor = autor;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    /**
     * @return String return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return int return the anyoPublicacion
     */
    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    /**
     * @param anyoPublicacion the anyoPublicacion to set
     */
    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    /**
     * @return Persona return the autor
     */
    public Persona getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    /**
     * @return String return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return String return the sinopsis
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * @param sinopsis the sinopsis to set
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * @return Devuelve un String con los datos del libro
     */
    @Override
    public String toString(){
        return("Datos Libro {ISBN: " + getIsbn() + " | Título: " + getTitulo() + " | Año Publicación: " + getAnyoPublicacion() + " | Autor: " + autor.toString() + " | Género: " + getGenero() + " | Sinopsis: " + getSinopsis() + " }");
    }
}
