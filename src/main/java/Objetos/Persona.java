package Objetos;

/**
 *
 * @author fluna
 */
public class Persona {
    private String nombre;
    private String apellidos;

    public Persona (String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return Devuelve un string con los datos del autor
     */
    @Override
    public String toString(){
        return("Datos Autor {Nombre: " + getNombre() + " | Apellidos" + getApellidos() +" }");
    }
}
