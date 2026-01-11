import java.awt.*;         
import java.awt.event.*;   
import javax.swing.*;      

public class Sudoku {
    class Tile extends JButton {
        int r;
        int c;

        Tile(int r, int c) {
            this.r = r;
            this.c = c;

            // Permettre de sélectionner la tuile et d'entrer un chiffre avec le clavier si la case est modifiable
            this.setFocusPainted(false);

            // Listener pour récupérer le focus quand on clique
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    requestFocusInWindow();
                }
            });

            // Listener pour ajouter un chiffre quand l'utilisateur tape un chiffre
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // Si la case était bloquée (pré-remplie), on ignore
                    if (!isEnabled()) return;

                    char keyChar = e.getKeyChar();
                    if (keyChar >= '1' && keyChar <= '9') {
                        setText(String.valueOf(keyChar));
                        puzzle[r][c] = keyChar - '0';
                        // Feedback visuel si le chiffre est correct
                        if (solution[r][c] == (keyChar - '0')) {
                            setForeground(new Color(34,139,34)); // Vert si juste
                        } else {
                            setForeground(Color.RED); // Rouge sinon
                        }
                    } else if (keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE || keyChar == '0') {
                        setText("");
                        puzzle[r][c] = 0;
                        setForeground(Color.BLACK);
                    }
                }
            });
        }
    }

    int boardWidth = 600;   
    int boardHeight = 650;  

    JFrame frame = new JFrame("Sudoku"); 
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    // Les grilles sont passées non-final pour que les Tile y accèdent
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
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        textLabel.setHorizontalAlignment(JLabel.CENTER);     
        textLabel.setText("Sudoku: Ajoutez des chiffres !"); 
        textPanel.setLayout(new BorderLayout());             
        textPanel.add(textLabel, BorderLayout.CENTER);

        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(9, 9));
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
                    tile.setEnabled(true);
                    tile.setBackground(Color.WHITE);

                    // On peut cliquer pour le focus (géré plus haut)
                    tile.setFocusable(true);
                }
                tile.setFont(new Font("Arial", Font.BOLD, 20));
                boardPanel.add(tile);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);
    }
}
