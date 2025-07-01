public class Dueño {
    private String nombre;
    private String cedula;

    public Dueño(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return nombre + " - Cédula: " + cedula;
    }
}
