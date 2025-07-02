import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login extends JFrame {
    private JPanel panelPrincipal;
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JButton entrarButton;
    private JButton registrarButton;

    public Login() {
        setTitle("ANIMALEANDO COL - Inicio de sesión");
        setContentPane(panelPrincipal);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCredenciales();
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroUsuario reg = new RegistroUsuario();
                reg.setVisible(true);
            }
        });
    }

    private void verificarCredenciales() {
        String usuarioIngresado = usuarioField.getText().trim();
        String contrasenaIngresada = new String(contrasenaField.getPassword()).trim();

        if (usuarioIngresado.isEmpty() || contrasenaIngresada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete ambos campos.");
            return;
        }

        boolean credencialesValidas = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 4) { // nombre, cedula, direccion, email
                    String email = datos[3].trim();
                    String contrasena = datos.length > 4 ? datos[4].trim() : ""; // Contraseña opcional si la añadiste

                    if (usuarioIngresado.equals(email) && contrasenaIngresada.equals(contrasena)) {
                        credencialesValidas = true;
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de usuarios.");
            return;
        }

        if (credencialesValidas) {
            JOptionPane.showMessageDialog(this, "Bienvenido/a " + usuarioIngresado);
            PaginaPrincipal menu = new PaginaPrincipal();
            menu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
        }
    }
}