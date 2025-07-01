// PanelRegistrarMascota.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Registro_Mascota extends JPanel {
    public static ArrayList<Mascota> listaMascotas = new ArrayList<>();

    public Registro_Mascota() {
        setLayout(new GridLayout(4, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblTipo = new JLabel("Tipo:");
        JTextField txtTipo = new JTextField();

        JLabel lblDueno = new JLabel("Dueño:");
        JComboBox<Dueño> cmbDuenos = new JComboBox<>();

        JButton btnGuardar = new JButton("Guardar");

        // Actualizar ComboBox
        updateDuenosCombo(cmbDuenos);

        add(lblNombre);
        add(txtNombre);
        add(lblTipo);
        add(txtTipo);
        add(lblDueno);
        add(cmbDuenos);
        add(new JLabel());
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            Dueño duenoSeleccionado = (Dueño) cmbDuenos.getSelectedItem();
            if (duenoSeleccionado != null) {
                Mascota nueva = new Mascota(txtNombre.getText(), txtTipo.getText(), duenoSeleccionado);
                listaMascotas.add(nueva);
                JOptionPane.showMessageDialog(this, "Mascota registrada.");
                txtNombre.setText("");
                txtTipo.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un dueño.");
            }
        });
    }

    private void updateDuenosCombo(JComboBox<Dueño> combo) {
        combo.removeAllItems();
        for (Dueño d : registro.listaDueños) {
            combo.addItem(d);
        }
    }
}
