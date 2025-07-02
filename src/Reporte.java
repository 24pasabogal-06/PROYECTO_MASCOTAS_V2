import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro_Mascota extends JFrame {

    private JTextField campoMascota;
    private JTextField campoDescripcion;
    private JButton btnVolver;
    private JButton btnIngresar;

    public Registro_Mascota() {
        setTitle("Registro de Mascota");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblMascota = new JLabel("Mascota:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblMascota, gbc);

        campoMascota = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(campoMascota, gbc);

        campoDescripcion = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(campoDescripcion, gbc);

        btnVolver = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(btnVolver, gbc);

        btnIngresar = new JButton("Ingresar");
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(btnIngresar, gbc);

        // Acción para el botón Ingresar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreMascota = campoMascota.getText();
                String descripcion = campoDescripcion.getText();
                JOptionPane.showMessageDialog(null, "Mascota registrada:\nNombre: " + nombreMascota + "\nDescripción: " + descripcion);
            }
        });

        // Acción para el botón Volver
        btnVolver.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            // Aquí puedes abrir la ventana anterior si la tienes
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Registro_Mascota::new);
    }
}
