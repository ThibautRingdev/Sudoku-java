import java.awt.*;         // Importe toutes les classes pour les composants GUI et les graphiques de l'AWT
import java.awt.event.*;   // Importe toutes les classes pour la gestion des événements dans AWT (comme le clavier, la souris)
import javax.swing.*;      // Importe toutes les classes pour créer des composants GUI avec Swing

public class Sudoku {
    class Tile extends JButton {
        int r;
        int c;
        Tile(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int boardWidth = 600;   // Largeur de la fenêtre
    int boardHeight = 650;  // Hauteur de la fenêtre

    JFrame frame = new JFrame("Sudoku"); // Fenêtre principale du jeu

    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    int[][] puzzle = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    int[][] solution = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };


    Sudoku() {
        frame.setVisible(true);
        // Définir la taille de la fenêtre
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application lorsque la fenêtre est fermée

        // Centrer la fenêtre sur l'écran
        frame.setLocationRelativeTo(null);

        // Utilise le layout BorderLayout pour organiser les éléments
        frame.setLayout(new BorderLayout());

        // Configuration du label :
        textLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Police Arial, taille 30, gras
        textLabel.setHorizontalAlignment(JLabel.CENTER);     // Centre le texte à l'intérieur du label
        textLabel.setText("Sudoku: 0");                      // Texte affiché au lancement
        textPanel.setLayout(new BorderLayout());             // Définit un layout pour le panel
        textPanel.add(textLabel, BorderLayout.CENTER);

        // Ajoute le panel à la fenêtre, en haut ("NORTH") du BorderLayout
        frame.add(textPanel, BorderLayout.NORTH);

        // Crée une grille 9x9 pour le panneau du plateau du Sudoku
        boardPanel.setLayout(new GridLayout(9, 9));
        // Ajouter les boutons/tuiles correspondant à chaque case du puzzle
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Tile tile = new Tile(r, c);
                int value = puzzle[r][c];
                if (value != 0) {
                    tile.setText(String.valueOf(value));
                    tile.setEnabled(false);
                    tile.setBackground(new Color(220, 220, 220));
                } else {
                    tile.setText("");
                }
                tile.setFont(new Font("Arial", Font.BOLD, 20));
                boardPanel.add(tile);
            }
        }

        // Ajoute le panneau de la grille au centre
        frame.add(boardPanel, BorderLayout.CENTER);
    }
}
