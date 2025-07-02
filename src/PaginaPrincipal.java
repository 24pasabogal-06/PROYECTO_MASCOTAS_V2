import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PaginaPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JButton registroButton;
    private JButton verButton;
    private JButton reporteButton;
    private JButton salirButton;

    public PaginaPrincipal() {
        setTitle("ANIMALEANDO COL");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroMascota registro = new RegistroMascota();
                registro.setVisible(true);
            }
        });

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMascotas();
            }
        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad de reporte próximamente...");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa
            }
        });
    }

    private void mostrarMascotas() {
        JTextArea area = new JTextArea(20, 50);
        area.setEditable(false);
        try (BufferedReader reader = new BufferedReader(new FileReader("mascotas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                area.append(linea + "\n");
            }
        } catch (IOException e) {
            area.setText("No se pudo leer el archivo de mascotas.\n¿Está vacío o no existe?");
        }

        JScrollPane scrollPane = new JScrollPane(area);
        JOptionPane.showMessageDialog(this, scrollPane, "Listado de Mascotas", JOptionPane.INFORMATION_MESSAGE);
    }
}