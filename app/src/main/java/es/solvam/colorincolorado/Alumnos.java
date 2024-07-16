package es.solvam.colorincolorado;

public class Alumnos {
    private int id;
    private String nombre;
    private String apellido;
    private String nomPadre;
    private String telefono;
    private String clase;

    public Alumnos(int id, String nombre, String apellido, String nomPadre, String telefono, String clase) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nomPadre = nomPadre;
        this.telefono = telefono;
        this.clase = clase;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNomPadre() {
        return nomPadre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getClase() {
        return clase;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNomPadre(String nomPadre) {
        this.nomPadre = nomPadre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
