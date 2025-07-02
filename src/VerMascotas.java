import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VerMascotas extends JFrame {
    private JPanel panelPrincipal;
    private JButton mascota1Button;
    private JButton mascota2Button;
    private JButton mascota3Button;
    private JButton volverButton;

    private List<String> mascotas = new ArrayList<>();

    public VerMascotas() {
        setTitle("Listado de Mascotas");
        setContentPane(panelPrincipal);
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cargarMascotasDesdeArchivo();

        mascota1Button.setVisible(false);
        mascota2Button.setVisible(false);
        mascota3Button.setVisible(false);

        if (mascotas.size() >= 1) {
            mascota1Button.setText("Mascota 1");
            mascota1Button.setVisible(true);
            mascota1Button.addActionListener(e -> mostrarDetalleMascota(0));
        }
        if (mascotas.size() >= 2) {
            mascota2Button.setText("Mascota 2");
            mascota2Button.setVisible(true);
            mascota2Button.addActionListener(e -> mostrarDetalleMascota(1));
        }
        if (mascotas.size() >= 3) {
            mascota3Button.setText("Mascota 3");
            mascota3Button.setVisible(true);
            mascota3Button.addActionListener(e -> mostrarDetalleMascota(2));
        }

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra esta ventana
            }
        });
    }

    private void cargarMascotasDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mascotas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null && mascotas.size() < 3) {
                mascotas.add(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de mascotas.");
        }
    }

    private void mostrarDetalleMascota(int indice) {
        if (indice >= 0 && indice < mascotas.size()) {
            String[] datos = mascotas.get(indice).split(",");
            if (datos.length >= 12) {
                String detalle =
                        "Nombre: " + datos[0] + "\n" +
                                "Raza: " + datos[1] + "\n" +
                                "Fecha de nacimiento: " + datos[2] + "\n" +
                                "Edad: " + datos[3] + "\n" +
                                "Sexo: " + datos[4] + "\n" +
                                "Especie: " + datos[5] + "\n" +
                                "Peso: " + datos[6] + " Kg\n" +
                                "Esterilizado: " + datos[7] + "\n" +
                                "Vacunas: " + datos[8] + "\n" +
                                "Enfermedades: " + datos[9] + "\n" +
                                "Microchip: " + datos[10] + "\n" +
                                "Dueño: " + datos[11];
                JOptionPane.showMessageDialog(this, detalle, "Información de Mascota", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registro incompleto.");
            }
        }
    }
}