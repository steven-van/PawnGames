package appli;
import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.Othello;
import jeuxPions.Puissance4;
import swing.JeuGUI;
import utileJeux.Couleurs;

public class Appli {
	
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur(Couleurs.NOIR);
		Joueur j2 = new Joueur(Couleurs.BLANC);
		IJeu othello = new Othello(j1, j2);
		othello.jouer();
		
		//new JeuGUI();
		
		/*
		Joueur j1 = new Joueur(Couleurs.JAUNE);
		Joueur j2 = new Joueur(Couleurs.ROUGE);
		IJeu puissance4 = new Puissance4(j1,j2);
		puissance4.jouer();
		*/

	}
}
