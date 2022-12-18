package jeuxPions;
import java.util.Scanner;

import jeu.Joueur;
import pions.Pion;
import pions.PionUneCouleur;
import utileJeux.Coord;
import utileJeux.Directions;
import utileJeux.Plateau;

public class Puissance4 extends Jeu2JoueursAPion {
	// le nombre de ligne du plateau
	private static final int NB_LIGNE_PAR_DEFAUT = 6;
	// le nombre de colonne du plateau
	private static final int NB_COLONNE_PAR_DEFAUT 	= 7;
	
	/**
	 * constructeur du Puissance4
	 * @param joueur1 : le joueur 1 
	 * @param joueur2 : le joueur 2
	 */
	public Puissance4(Joueur joueur1, Joueur joueur2) {
		super(new Plateau(NB_LIGNE_PAR_DEFAUT,NB_COLONNE_PAR_DEFAUT), joueur1, joueur2);
		super.setJoueurCourant(getPremierJoueur());
	}
	
	/**
	 * @brief initialisation du jeu
	 */
	@Override
	public void initialisationJeu() {
	}

	/**
	 * @param j : le joueur
	 * @return true si le joueur est vainqueur ; false sinon
	 */
	@Override
	public boolean isVainqueur(Joueur j) {
		int ligMax = super.getPlateau().getNbLignes();
		int colMax = super.getPlateau().getNbColonnes(); 
		System.out.println("Chargement en cours...");
		
		for(int indiceLig=1; indiceLig<=ligMax; indiceLig++) {
			for(int indiceCol=1; indiceCol<=colMax; indiceCol++) {
				
				Coord coordTmp = new Coord(indiceCol, indiceLig);
				if(super.getPlateau().getCase(coordTmp) != null) {
					// pour chaque direction
					for (Directions d : Directions.values()){
						
						Pion caseTmp;
						int nbPions = 1;
						// case associée à la direction
						int xDir = d.getX();
						int yDir = d.getY();
						int currentX, currentY;
						boolean conditionIncPions = false;
						
						do {
							currentX = indiceCol + xDir*nbPions;
							currentY = indiceLig + yDir*nbPions;
							coordTmp = new Coord(currentX, currentY); // le nouveau pas
							
							if(super.getPlateau().isValidCoord(coordTmp)) {
								
								caseTmp = super.getPlateau().getCase(coordTmp);
				
								conditionIncPions = (caseTmp != null) && (caseTmp.getCouleur() == j.getCouleur());
								
								if(conditionIncPions){ // par lui-même
									nbPions++; // le nb de ses pions dans une direction
									
									if(nbPions == 4) {
										System.out.println("Le joueur " + j + " a gagné");
										return true;
									}
								}
								else {
									break;
								}
								
							}else {
								break;
							}
						}while(conditionIncPions);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * @return la chaine de caractères saisie au clavier
	 */
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

	/**
	 * @brief commence une partie
	 * @return true si l'utilisateur continue la partie ; false sinon
	 */
	@Override
	public boolean jouer() {
		System.out.println(super.getPlateau());
		do {
			if(questionFinDePartie()) {
				break;
			}
			
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

		return false;
	}

	/**
	 * @param c : la coordonnée
	 * @return true s'il est possible de jouer cette coordonnée ; false sinon
	 */
	@Override
	public boolean peutJouer(Coord c) {
		if(super.getPlateau().getCase(c) == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return le premier joueur à jouer
	 */
	@Override
	public Joueur getPremierJoueur() {
		int min = 0;
		int max = 2;
		int numJoueur = (min + (int)(Math.random() * (max - min) + 1));
		Joueur j = numJoueur == 1 ? super.getJoueur1() : super.getJoueur2();
		return j;
	}

	/**
	 * @return true si c'est la fin de partie ; false sinon
	 */
	@Override
	public boolean isFinDePartie() {
		if(isVainqueur(super.getJoueurAdverse()) || super.getPlateau().isFull()) {
			return true;
		} else {
			return false;
		}
	
	}
	

}
