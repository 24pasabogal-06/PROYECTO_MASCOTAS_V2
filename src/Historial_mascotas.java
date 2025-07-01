// PanelVerMascotas.java
import javax.swing.*;
import java.awt.*;

public class Historial_mascotas extends JPanel {
    private JTextArea area;

    public Historial_mascotas() {
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);

        JButton btnActualizar = new JButton("Actualizar Lista");

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btnActualizar, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> actualizarLista());
    }

    private void actualizarLista() {
        area.setText("");
        for (Mascota m : Registro_Mascota.listaMascotas) {
            area.append(m.toString() + "\n");
        }
    }
}
