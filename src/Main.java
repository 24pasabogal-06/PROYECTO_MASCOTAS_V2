import java.awt.event.ActionListener;
import models.Dueño;

import javax.swing.*;

 public static void main(String[] args) {
    JFrame frame = new JFrame("Interfaz UI");
    frame.setContentPane(new GUI.Interfaz()_UI().panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


    System.out.println("Hello, World!");

}