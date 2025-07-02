import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroUsuario extends JFrame {
    private JPanel panelPrincipal;
    private JTextField nombreField;
    private JTextField cedulaField;
    private JTextField direccionField;
    private JTextField emailField;
    private JButton registrarButton;
    private JButton volverButton;

    public RegistroUsuario() {
        setTitle("Registro de Usuario");
        setContentPane(panelPrincipal);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuarioEnTxt();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });
    }

    private void registrarUsuarioEnTxt() {
        String nombre = nombreField.getText().trim();
        String cedula = cedulaField.getText().trim();
        String direccion = direccionField.getText().trim();
        String email = emailField.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(nombre + "," + cedula + "," + direccion + "," + email);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Usuario guardado correctamente.");
            // Limpiar campos
            nombreField.setText("");
            cedulaField.setText("");
            direccionField.setText("");
            emailField.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar en archivo.");
        }
    }
}