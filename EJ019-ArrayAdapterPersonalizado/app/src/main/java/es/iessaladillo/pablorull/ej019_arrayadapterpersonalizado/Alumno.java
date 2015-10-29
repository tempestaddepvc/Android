package es.iessaladillo.pablorull.ej019_arrayadapterpersonalizado;

/**
 * Created by Usuario on 29/10/2015.
 */
public class Alumno {
    protected String nombre;
    protected int edad;
    protected String telefono;

    public Alumno(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
