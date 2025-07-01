public class Mascota {
    private String nombre;
    private String tipo;
    private Dueño Dueño;

    public Mascota(String nombre, String tipo, Dueño dueno) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Dueño = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Dueño getDueño() {
        return Dueño;
    }

    @Override
    public String toString() {
        return nombre + " - Tipo: " + tipo + ", Dueño: " + Dueño.getNombre();
    }
}
