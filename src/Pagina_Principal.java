import javax.swing.*;

public class Pagina_Principal extends JFrame {
    public JButton registroDeMascotasButton;
    public JButton verMascotasButton;
    public JButton crearReporteButton;
    public JButton salirButton;

    public Pagina_Principal() {
        setTitle("Página Principal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        registroDeMascotasButton = new JButton("Registrar Mascotas");
        verMascotasButton = new JButton("Ver Historial de Mascotas");
        crearReporteButton = new JButton("Crear Reporte");
        salirButton = new JButton("Salir");

        add(registroDeMascotasButton);
        add(verMascotasButton);
        add(crearReporteButton);
        add(salirButton);
    }
}
