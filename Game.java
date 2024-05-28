import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {

    private int indicateurJoueur; // Indique le joueur actuel (1 ou 2)
    private int[][] plateau; // Représente le plateau de jeu sous forme de grille 3x3
    private JFrame parentFrame; // Référence à la fenêtre principale pour afficher des dialogues

    // Constructeur initialisant la fenêtre parent, le joueur et le plateau de jeu
    public Game(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        indicateurJoueur = 1;
        plateau = new int[3][3];
    }

    // Méthode pour effectuer un coup de jeu
    public void jouer(int x, int y) {
        plateau[x][y] = indicateurJoueur;
        if (checkVictoire(indicateurJoueur)) {
            // Affiche un message de victoire dans la console et dans une boîte de dialogue
            System.out.println("Victoire du joueur " + indicateurJoueur + " !");
            JOptionPane.showMessageDialog(parentFrame, "Victoire du joueur " + indicateurJoueur + " !");
            return;
        } else {
            if (checkPartieNulle()) {
                // Affiche un message de partie nulle dans la console et dans une boîte de dialogue
                System.out.println("Partie nulle");
                JOptionPane.showMessageDialog(parentFrame, "Partie nulle");
            } else {
                // Change le joueur actuel pour le prochain tour
                if (indicateurJoueur == 1)
                    indicateurJoueur = 2;
                else
                    indicateurJoueur = 1;
            }
        }
    }

    // Méthode pour vérifier si un joueur a gagné
    public boolean checkVictoire(int j) {
        int compteur = 0;

        // Vérification des lignes horizontales
        for (int i = 0; i < plateau.length; i++) {
            for (int k = 0; k < plateau[i].length; k++) {
                if (plateau[i][k] == j)
                    compteur++;
            }
            if (compteur == plateau.length)
                return true;
            else
                compteur = 0;
        }

        // Vérification des colonnes verticales
        for (int i = 0; i < plateau.length; i++) {
            for (int k = 0; k < plateau[i].length; k++) {
                if (plateau[k][i] == j)
                    compteur++;
            }
            if (compteur == plateau.length)
                return true;
            else
                compteur = 0;
        }

        // Vérification de la diagonale principale
        for (int i = 0; i < plateau.length; i++) {
            if (plateau[i][i] == j)
                compteur++;
        }
        if (compteur == plateau.length)
            return true;

        compteur = 0;

        // Vérification de la diagonale secondaire
        int i = plateau.length - 1;
        int k = 0;

        while (k < plateau.length && i >= 0) {
            if (plateau[i][k] == j)
                compteur++;
            i--;
            k++;
        }

        if (compteur == plateau.length)
            return true;

        return false;
    }

    // Méthode pour vérifier si la partie est nulle
    public boolean checkPartieNulle() {
        int compteur = 0;

        // Compte le nombre de cases occupées
        for (int i = 0; i < plateau.length; i++)
            for (int k = 0; k < plateau[i].length; k++)
                if (plateau[i][k] != 0)
                    compteur++;

        // Si toutes les cases sont occupées, c'est une partie nulle
        if (compteur == plateau.length * plateau.length)
            return true;
        else
            return false;
    }

    // Getter pour obtenir le joueur actuel
    public int getIndicateurJoueur() {
        return indicateurJoueur;
    }

    // Setter pour définir le joueur actuel
    public void setIndicateurJoueur(int indicateurJoueur) {
        this.indicateurJoueur = indicateurJoueur;
    }

    // Getter pour obtenir le plateau de jeu
    public int[][] getPlateau() {
        return plateau;
    }

    // Setter pour définir le plateau de jeu
    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }
}
