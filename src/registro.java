// PanelRegistrarDueno.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class registro extends JPanel {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton registrarButton;
    public static ArrayList<Dueño> listaDueños = new ArrayList<>();

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
            Dueño nuevo = new Dueño(txtNombre.getText(), txtCedula.getText());
            listaDueños.add(nuevo);
            JOptionPane.showMessageDialog(this, "Dueño registrado.");
            txtNombre.setText("");
            txtCedula.setText("");
        });
    }
}
