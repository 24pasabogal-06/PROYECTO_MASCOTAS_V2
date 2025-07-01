// VentanaPrincipal.java
import javax.swing.*;

public class Interfaz extends JFrame {
    public Interfaz() {
        setTitle("Gestión de Mascotas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear las pestañas
        JTabbedPane pestañas = new JTabbedPane();

        pestañas.addTab("Registrar Dueño", new registro());
        pestañas.addTab("Registrar Mascota", new Registro_Mascota());
        pestañas.addTab("Ver Mascotas", new Historial_mascotas());

        add(pestañas);

        setVisible(true);
    }
}
