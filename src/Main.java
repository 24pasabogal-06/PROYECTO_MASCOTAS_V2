import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      // Establecer apariencia del sistema (opcional)
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception ignored) {
         // Se ignora cualquier excepción para no detener la aplicación
      }

      // Iniciar desde la interfaz de Login
      javax.swing.SwingUtilities.invokeLater(() -> {
         Login login = new Login();
         login.setVisible(true);
      });
   }
}