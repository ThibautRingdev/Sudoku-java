import java.awt.*;         // Importe toutes les classes pour les composants GUI et les graphiques de l'AWT
import java.awt.event.*;   // Importe toutes les classes pour la gestion des événements dans AWT (comme le clavier, la souris)
import javax.swing.*;      // Importe toutes les classes pour créer des composants GUI avec Swing

public class Sudoku {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Sudoku");

    Sudoku() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quitte l'application lorsque la fenêtre est fermée
        frame.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        frame.setLayout(new BorderLayout()); // Utilise BorderLayout comme layout manager du frame
    }
}
