import java.awt.*;
import javax.swing.*;

public class Morpion {

    public static void main(String[] args) {
        
        // Crée une nouvelle fenêtre JFrame
        JFrame window = new JFrame();
        // Crée une nouvelle instance de Game en passant la fenêtre JFrame
        Game game = new Game(window);

        // Définit la disposition de la fenêtre en grille 3x3
        window.setLayout(new GridLayout(3, 3));
        
        // Boucle pour ajouter les boutons de CaseMorpion à la fenêtre
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Crée une nouvelle case de morpion avec ses coordonnées et le jeu
                CaseMorpion cm = new CaseMorpion(i, j, game);            
                // Ajoute le bouton de la case à la fenêtre
                window.add(cm.getButton());
            }
        }
        
        // Centre la fenêtre sur l'écran
        window.setLocationRelativeTo(null);
        // Définit la taille de la fenêtre
        window.setSize(500, 500);
        // Définit l'action de fermeture de la fenêtre pour terminer l'application
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Rend la fenêtre visible
        window.setVisible(true);
    }

}
