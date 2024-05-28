import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CaseMorpion {

    private JButton button; // Bouton représentant une case du Morpion
    private Game game; // Référence au jeu en cours
    private final int x, y; // Coordonnées de la case dans le plateau

    // Constructeur initialisant les coordonnées et le jeu, et créant un bouton
    public CaseMorpion(final int x, final int y, final Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.button = new JButton();

        // Ajout d'un ActionListener au bouton pour gérer les clics
        button.addActionListener(new ActionListener() {

            // Méthode appelée lorsqu'on clique sur le bouton
            public void actionPerformed(ActionEvent evenement) {
                // Met à jour le texte du bouton en fonction du joueur actuel
                if (game.getIndicateurJoueur() == 1)
                    button.setText("X");
                else
                    button.setText("O");
                
                // Désactive le bouton après qu'il soit cliqué
                button.setEnabled(false);
                
                // Appelle la méthode jouer de la classe Game avec les coordonnées de la case
                game.jouer(x, y);
            }

        });

    }

    // Getter pour obtenir le bouton
    public JButton getButton() {
        return button;
    }

    // Setter pour définir le bouton
    public void setButton(JButton button) {
        this.button = button;
    }

    // Getter pour obtenir le jeu
    public Game getGame() {
        return game;
    }

    // Setter pour définir le jeu
    public void setGame(Game game) {
        this.game = game;
    }

    // Getter pour obtenir la coordonnée x de la case
    public int getX() {
        return x;
    }

    // Getter pour obtenir la coordonnée y de la case
    public int getY() {
        return y;
    }

}
