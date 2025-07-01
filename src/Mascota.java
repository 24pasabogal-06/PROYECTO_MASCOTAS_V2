public class Mascota {
    private String nombre;
    private String tipo;
    private Dueño dueno;

    public Mascota(String nombre, String tipo, Dueño dueno) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dueno = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Dueño getDueño() {
        return dueno;
    }

    @Override
    public String toString() {
        return nombre + " - Tipo: " + tipo + ", Dueño: " + dueno.getNombre();
    }
}
