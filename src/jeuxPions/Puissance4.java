package jeuxPions;
import java.util.Scanner;

import jeu.Joueur;
import pions.Pion;
import pions.PionUneCouleur;
import utileJeux.Coord;
import utileJeux.Plateau;

public class Puissance4 extends Jeu2JoueursAPion {
	private int nbPionsJ1;
	private int nbPionsJ2;
	
	public Puissance4(Joueur joueur1, Joueur joueur2) {
		super(new Plateau(6,7), joueur1, joueur2);
		this.nbPionsJ1 = 21;
		this.nbPionsJ2 = 21;
		initialisationJeu();
	}
	
	public int getNbPionsJ1() {
		return this.nbPionsJ1;
	}
	
	public int getNbPionsJ2() {
		return this.nbPionsJ2;
	}

	public int setNbPionsJ1() {
		return this.nbPionsJ1;
	}
	
	public int setNbPionsJ2() {
		return this.nbPionsJ2;
	}
	
	@Override
	public void initialisationJeu() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public boolean isVainqueur(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String saisie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer la colonne (1 à 7) du pion que vous voulez placer");
		System.out.print("Votre choix : ");
		int col = scanner.nextInt();
		while(col < 1 || col > 7) {
			System.out.println("Mauvaise saisie, veuillez entrer un nombre entre 1 et 7 \n");
			System.out.print("Votre choix : ");
			col = scanner.nextInt();
		}
		scanner.close();
		return Integer.toString(col);
	}

	@Override
	public void jouer() {
		int col = Integer.parseInt(saisie());
		for(int i = 0; i < super.getPlateau().getNbLignes(); i++) {
			if(super.getPlateau().getTabCases()[i][col] == null) {
				Coord c = new Coord(col, i-1);
				if(peutJouer(c)) {
					Pion p = new PionUneCouleur(super.getJoueurCourant().getCouleur());
					super.getPlateau().poser(p, c);
				}
				
			} 
		}
		System.out.println("La colonne est déja remplie");
		

	}

	@Override
	public boolean peutJouer(Coord c) {
		if(super.getPlateau().getCase(c) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Joueur getPremierJoueur() {
		int min = 1;
		int max = 2;
		int numJoueur = (min + (int)(Math.random() * (max - min) + 1));
		Joueur j = numJoueur == 1 ? super.getJoueur1() : super.getJoueur2();
		super.setJoueurCourant(j);
		return j;
	}

	@Override
	public boolean isFinDePartie() {
		// TODO Auto-generated method stub
		return false;
	}

}