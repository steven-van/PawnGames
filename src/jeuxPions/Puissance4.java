package jeuxPions;
import java.util.Scanner;

import jeu.Joueur;
import pions.Pion;
import pions.PionUneCouleur;
import utileJeux.Coord;
import utileJeux.Directions;
import utileJeux.Plateau;

public class Puissance4 extends Jeu2JoueursAPion {
	private static final int NB_LIGNE_PAR_DEFAUT = 6;
	private static final int NB_COLONNE_PAR_DEFAUT 	= 7;
	
	public Puissance4(Joueur joueur1, Joueur joueur2) {
		super(new Plateau(NB_LIGNE_PAR_DEFAUT,NB_COLONNE_PAR_DEFAUT), joueur1, joueur2);
		super.setJoueurCourant(getPremierJoueur());
	}
	
	@Override
	public void initialisationJeu() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isVainqueur(Joueur j) {
		int ligMax = super.getPlateau().getNbLignes();
		int colMax = super.getPlateau().getNbColonnes(); 
		System.out.println("Chargement en cours...");
		
		for(int indiceLig=1; indiceLig<=ligMax; indiceLig++) {
			for(int indiceCol=1; indiceCol<=colMax; indiceCol++) {
				
				/*if (this.getPlateau().getTabCases()[indiceLig][indiceCol] != null) {
					if ( indiceCol<=colMax 	&& compterJeton(indiceLig, indiceCol, 1, 1) == 4
				 			// diagonale : vers le bas et à droite 
						|| indiceCol<=colMax && compterJeton(indiceLig, indiceCol, -1, 1) == 4
							// vers le haut et à droite
						|| indiceLig<=ligMax  && compterJeton(indiceLig, indiceCol, 0, 1) == 4
							// horizontal vers la droite
						|| indiceLig<= ligMax && compterJeton(indiceLig, indiceCol, 1, 0) == 4
							// vertical du haut vers le bas
						) {
						System.out.println("Le joueur" + j + " a gagné");
						return true;
					}
				}
				*/
				Coord coordTmp = new Coord(indiceCol, indiceLig);
				if(super.getPlateau().getCase(coordTmp) != null) {
					// pour chaque direction
					for (Directions d : Directions.values()){
						Pion caseTmp;
						int nbPions = 1;
						int i=0;
						// case associée à la direction
						int xDir = d.getX();
						int yDir = d.getY();
						
						if(super.getPlateau().isValidCoord(coordTmp)) {
							
							caseTmp = super.getPlateau().getCase(coordTmp);
							int currentX, currentY;
						
							
							while((caseTmp != null) && (caseTmp.getCouleur() == j.getCouleur())){
								
								i++; // le nb de pas dans une direction
								currentX = indiceCol + xDir*i;
								currentY = indiceLig + yDir*i;
								coordTmp = new Coord(currentX, currentY); // le nouveau pas
						
								if(super.getPlateau().isValidCoord(coordTmp)) {
									
									caseTmp = super.getPlateau().getCase(coordTmp); // la case correspondante
									
									if((caseTmp != null) && (caseTmp.getCouleur() == j.getCouleur())){ // par lui-même
										nbPions++;
										if(nbPions == 4) {
											System.out.println("Le joueur " + j + " a gagné");
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public String saisie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("C'est au tour du joueur " + super.getJoueurCourant());
		System.out.println("Veuillez entrer la colonne (1 à 7) du pion que vous voulez placer");
		System.out.print("Votre choix : ");
		int col = scanner.nextInt();
		while(col < 1 || col > 7) {
			System.out.println("Mauvaise saisie, veuillez entrer un nombre entre 1 et 7 \n");
			System.out.print("Votre choix : ");
			col = scanner.nextInt();
		}
		//scanner.close();
		return Integer.toString(col);
	}

	@Override
	public void jouer() {
		System.out.println(super.getPlateau());
		do {
			int col = Integer.parseInt(saisie());
			int cptLignes = super.getPlateau().getNbLignes();
			
			while(super.getPlateau().getCase(new Coord(col, 1)) != null) {
				System.out.println("La colonne est remplie");
				col = Integer.parseInt(saisie());
			}
			
			while(cptLignes >= 0 && super.getPlateau().getCase(new Coord(col, cptLignes)) != null) {
				cptLignes--;
			}
			
			Coord c = new Coord(col, cptLignes);
			if(peutJouer(c)) {
				Pion p = new PionUneCouleur(super.getJoueurCourant().getCouleur());
				super.getPlateau().poser(p, c);
				System.out.println(super.getPlateau());
				super.setJoueurCourant(super.getJoueurAdverse());
			}
		} while(!isFinDePartie());

		

	
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
		int min = 0;
		int max = 2;
		int numJoueur = (min + (int)(Math.random() * (max - min) + 1));
		Joueur j = numJoueur == 1 ? super.getJoueur1() : super.getJoueur2();
		return j;
	}

	@Override
	public boolean isFinDePartie() {
		if(isVainqueur(super.getJoueurAdverse()) || super.getPlateau().isFull()) {
			return true;
		} else {
			return false;
		}
	
	}
	

	
	/*private int compterJeton(int lig, int col, int ligDir, int colDir)
	{
		int cpt = 0; 		// compte le nombre de jeton aligné
		int ligCpt = lig;	// s'occupe de la direction de la ligne (nord ou sud) du comptage des jetons
		int colCpt = col; 	// s'occupe de la direction la colonne (ouest ou est) du comptage des jetons

		while(ligCpt >= 0 && ligCpt < this.getPlateau().getNbLignes() 
				&& colCpt >= 0 && colCpt < this.getPlateau().getNbColonnes() 
				&& this.getPlateau().getTabCases()[ligCpt][colCpt].getCouleur() == this.getPlateau().getTabCases()[lig][col].getCouleur() 
		{
			ligCpt += ligDir; 
			colCpt += colDir;
			cpt++;
		}

		return cpt;
	}
	*/

}
