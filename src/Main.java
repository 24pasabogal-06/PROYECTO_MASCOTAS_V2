import javax.swing.*;

public class Main {
   // Ventanas (instancias de cada interfaz)
   static PaginaPrincipal pagina_Principal;
   static Historial_mascotas Historial_mascotas;
   static RegistroUsuario registro_usuario;
   static RegistroMascota registroMascota;
   static Reporte reporte;

   public static void main(String[] args) {
      // Iniciar la aplicación en el hilo de eventos
      SwingUtilities.invokeLater(() -> {
         pagina_Principal = new PaginaPrincipal();
         Historial_mascotas = new Historial_mascotas();
         registro_usuario = new RegistroUsuario();
         registroMascota = new RegistroMascota();
         reporte = new Reporte();

         mostrarPagina_Principal();
         conectarBotones();
      });
   }

   // Métodos para mostrar ventanas
   public static void mostrarPagina_Principal() {
      pagina_Principal.setVisible(true);
   }

   public static void mostrarRegistroUsuario() {
      pagina_Principal.setVisible(false);
      registro_usuario.setVisible(true);
   }

   public static void mostrarHistorialMascotas() {
      pagina_Principal.setVisible(false);
      Historial_mascotas.setVisible(true);
   }

   public static void mostrarRegistroMascota() {
      pagina_Principal.setVisible(false);
      registroMascota.setVisible(true);
   }

   public static void mostrarReporte() {
      pagina_Principal.setVisible(false);
      reporte.setVisible(true);
   }

   // Conectar todos los botones entre interfaces
   public static void conectarBotones() {
      // Pagina Principal
      pagina_Principal.registroDeMascotasButton.addActionListener(e -> mostrarRegistroMascota());
      pagina_Principal.verMascotasButton.addActionListener(e -> mostrarHistorialMascotas());
      pagina_Principal.crearReporteButton.addActionListener(e -> mostrarReporte());
      pagina_Principal.salirButton.addActionListener(e -> System.exit(0));

      // Registro Mascota (volver a principal)
      registroMascota.volverButton.addActionListener(e -> {
         registroMascota.setVisible(false);
         mostrarPagina_Principal();
      });

      // Historial Mascotas
      Historial_mascotas.volverButton.addActionListener(e -> {
         Historial_mascotas.setVisible(false);
         mostrarPagina_Principal();
      });

      // Registro Usuario
      registro_usuario.registrarButton.addActionListener(e -> {
         registro_usuario.setVisible(false);
         mostrarPagina_Principal();
      });

      // Reporte
      reporte.volverButton.addActionListener(e -> {
         reporte.setVisible(false);
         mostrarPagina_Principal();
      });
   }
}
