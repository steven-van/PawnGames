package appli;
import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.Othello;
import swing.JeuGUI;
import utileJeux.Couleurs;

public class Appli {
	
	public static void main(String[] args) {
		Joueur j1 = new Joueur(Couleurs.NOIR);
		Joueur j2 = new Joueur(Couleurs.BLANC);
		IJeu othello = new Othello(j1, j2);
		othello.jouer();
	}
}
