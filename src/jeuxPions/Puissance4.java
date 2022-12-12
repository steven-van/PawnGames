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
		int cptLignes = super.getPlateau().getNbLignes() - 1;
		
		if(super.getPlateau().getTabCases()[0][col] != null) {
			System.out.println("La colonne est déjà remplie");
			return;
		}
		
		while(super.getPlateau().getTabCases()[cptLignes][col] != null && cptLignes >= 0) {
			cptLignes--;
		}
		
		Coord c = new Coord(col, cptLignes);
		if(peutJouer(c)) {
			Pion p = new PionUneCouleur(super.getJoueurCourant().getCouleur());
			super.getPlateau().poser(p, c);
			if(super.getJoueurCourant() == super.getJoueur1()) {
				this.nbPionsJ1--;
			} else {
				this.nbPionsJ2--;
			}
		}
	
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
		if(super.getPlateau().isFull() || isVainqueur(super.getJoueur1()) || isVainqueur(super.getJoueur2())) {
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean estGagnant()
	{
		int ligMax = super.getPlateau().getNbLignes();
		int colMax = super.getPlateau().getNbColonnes(); 

		for(int indiceLig=0; indiceLig<ligMax; indiceLig++)
			{
				for(int indiceCol=0; indiceCol<colMax; indiceCol++)
				{
					if (this.getPlateau().getTabCases()[indiceLig][indiceCol] != null) 
					{
						if ( indiceCol<=colMax 	&& compterJeton(indiceLig, indiceCol, 1, 1) == 4
					 				// diagonale : vers le bas et à droite 
							|| indiceCol<=colMax 	&& compterJeton(indiceLig, indiceCol, -1, 1) == 4
									// vers le haut et à droite
							|| indiceLig<=ligMax  	&& compterJeton(indiceLig, indiceCol, 0, 1) == 4
									// horizontal vers la droite
							|| indiceLig<= ligMax	&& compterJeton(indiceLig, indiceCol, 1, 0) == 4
								// vertical du haut vers le bas
							)
						{
							return true;
						}
					}
				}
			}

		return false;
	}
	
	private int compterJeton(int lig, int col, int ligDir, int colDir)
	{
		int cpt 	=	0; 		// compte le nombre de jeton aligné
		int ligCpt 	=	lig;	// s'occupe de la direction de la ligne (nord ou sud) du comptage des jetons
		int colCpt 	=	col; 	// s'occupe de la direction la colonne (ouest ou est) du comptage des jetons

		while(ligCpt >= 0 && ligCpt < this.getPlateau().getNbLignes() && colCpt >= 0 && colCpt < this.getPlateau().getNbColonnes() 
				&& this.getPlateau().getTabCases()[ligCpt][colCpt] == this.getPlateau().getTabCases()[lig][col] )
		{
			ligCpt += ligDir; 
			colCpt += colDir;

			cpt++;

		}

		return cpt;
	}

}
