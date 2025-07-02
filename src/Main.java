import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      // Establecer apariencia del sistema (opcional)
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception ignored) {}

      // Iniciar desde la interfaz de login
      javax.swing.SwingUtilities.invokeLater(() -> {
         Login login = new Login();
         login.setVisible(true);
      });
   }
}