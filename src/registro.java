// PanelRegistrarDueno.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class registro extends JPanel {
    public static ArrayList<Dueno> listaDuenos = new ArrayList<>();

    public registro() {
        setLayout(new GridLayout(3, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        add(lblNombre);
        add(txtNombre);
        add(lblCedula);
        add(txtCedula);
        add(new JLabel()); // Espacio
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            Dueno nuevo = new Dueno(txtNombre.getText(), txtCedula.getText());
            listaDuenos.add(nuevo);
            JOptionPane.showMessageDialog(this, "Dueño registrado.");
            txtNombre.setText("");
            txtCedula.setText("");
        });
    }
}
