public class Dueño {
    private String nombre;
    private String cedula;
    private String Direccion;
    private String Email;

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

    public String getDireccion() {return Direccion;}

    public String getEmail() {return Email;}

    @Override
    public String toString() {
        return nombre + " - Cédula: " + cedula;
    }
}
