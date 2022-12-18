package appli;
import java.util.Scanner;

import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.Othello;
import jeuxPions.Puissance4;
import swing.JeuGUI;
import utileJeux.Couleurs;

public class Appli {
	
	public static String strMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("A quel jeu voulez-vous jouer ?\n");
		sb.append("(1) Othello\n");
		sb.append("(2) Puissance4\n");
		sb.append("(3) Interface graphique\n");
		sb.append("tappe (4) pour quitter");
		return sb.toString();
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(strMenu());
			String choix = sc.next();
			choix = choix.trim();
			
			if(!choix.isEmpty()) {
			
				try {
			        int choixInt = Integer.parseInt(choix);
			        if(choixInt == 1) {
						Joueur j1 = new Joueur(Couleurs.NOIR);
						Joueur j2 = new Joueur(Couleurs.BLANC);
						IJeu othello = new Othello(j1, j2);
						if(!othello.jouer()) {
							continue;
						}
					} else if(choixInt == 2) {
						Joueur j1 = new Joueur(Couleurs.JAUNE);
						Joueur j2 = new Joueur(Couleurs.ROUGE);
						IJeu puissance4 = new Puissance4(j1,j2);
						if(!puissance4.jouer()) {
							continue;
						}
					} else if(choixInt == 3) {
						new JeuGUI();
					} else if (choixInt == 4) {
						break;
					} else {
						System.out.println("Saisie invalide, veuillez réessayer");
					}
			    } catch (NumberFormatException nfe) {
			    	System.out.println("Saisie invalide, veuillez réessayer");
			    }
			}
		} 
		System.out.println("Au revoir");
		
	}
}
