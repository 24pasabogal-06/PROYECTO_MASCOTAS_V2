import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroMascota extends JFrame {
    private JPanel panelPrincipal;
    private JTextField nombreField;
    private JTextField razaField;
    private JTextField fechaNacimientoField;
    private JTextField edadField;
    private JTextField sexoField;
    private JTextField especieField;
    private JTextField pesoField;
    private JTextField esterilizadoField;
    private JTextField vacunasField;
    private JTextField enfermedadesField;
    private JTextField microchipField;
    private JTextField duenoField;
    private JButton registrarButton;
    private JButton volverButton;

    public RegistroMascota() {
        setTitle("Registro de Mascota");
        setContentPane(panelPrincipal);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMascotaEnTxt();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
    }

    private void guardarMascotaEnTxt() {
        String nombre = nombreField.getText().trim();
        String raza = razaField.getText().trim();
        String fechaNacimiento = fechaNacimientoField.getText().trim();
        String edad = edadField.getText().trim();
        String sexo = sexoField.getText().trim();
        String especie = especieField.getText().trim();
        String peso = pesoField.getText().trim();
        String esterilizado = esterilizadoField.getText().trim();
        String vacunas = vacunasField.getText().trim();
        String enfermedades = enfermedadesField.getText().trim();
        String microchip = microchipField.getText().trim();
        String dueno = duenoField.getText().trim();

        if (nombre.isEmpty() || raza.isEmpty() || fechaNacimiento.isEmpty() || edad.isEmpty()
                || sexo.isEmpty() || especie.isEmpty() || peso.isEmpty() || esterilizado.isEmpty()
                || vacunas.isEmpty() || enfermedades.isEmpty() || microchip.isEmpty() || dueno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mascotas.txt", true))) {
            writer.write(nombre + "," + raza + "," + fechaNacimiento + "," + edad + "," + sexo + "," + especie + ","
                    + peso + "," + esterilizado + "," + vacunas + "," + enfermedades + "," + microchip + "," + dueno);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Mascota registrada exitosamente.");

            // Limpiar los campos
            nombreField.setText("");
            razaField.setText("");
            fechaNacimientoField.setText("");
            edadField.setText("");
            sexoField.setText("");
            especieField.setText("");
            pesoField.setText("");
            esterilizadoField.setText("");
            vacunasField.setText("");
            enfermedadesField.setText("");
            microchipField.setText("");
            duenoField.setText("");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
        }
    }
}