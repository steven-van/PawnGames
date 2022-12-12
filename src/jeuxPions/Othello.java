package jeuxPions;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import jeu.Joueur;
import pions.Pion;
import pions.PionAPoser;
import pions.PionDeuxCouleurs;
import utileJeux.Coord;
import utileJeux.Couleurs;
import utileJeux.Directions;
import utileJeux.Plateau;

public class Othello extends Jeu2JoueursAPion {
	
	// joueur 1 = NOIRS
	// joueur 2 = BLANC

	final static int COTE = 8;

	// les coords des pions attaquables par coord de coup possible
	Map coupsPossibles = new HashMap<Coord, Coord[]>();
	Map nbPionsAttaquables = new HashMap<Coord, Integer>();

	boolean personnePeutJouer=false;
	
	public Othello(Joueur joueur1, Joueur joueur2) {
		 super(new Plateau(COTE, COTE), joueur1, joueur2);
		 initialisationJeu();
		 super.setJoueurCourant(getPremierJoueur());
	}
	
	@Override
	public void initialisationJeu() {
		Pion pNoir1 = new PionDeuxCouleurs(Couleurs.NOIR, Couleurs.BLANC);
		Pion pNoir2 = new PionDeuxCouleurs(Couleurs.NOIR, Couleurs.BLANC);
		super.getPlateau().poser(pNoir1, new Coord(5, 4));
		super.getPlateau().poser(pNoir2, new Coord(4, 5));
		Pion pBlanc1 = new PionDeuxCouleurs(Couleurs.BLANC, Couleurs.NOIR);
		Pion pBlanc2 = new PionDeuxCouleurs(Couleurs.BLANC, Couleurs.NOIR);
		super.getPlateau().poser(pBlanc1, new Coord(4, 4));
		super.getPlateau().poser(pBlanc2, new Coord(5, 5));
		super.getJoueur1().incPts(2);
		super.getJoueur2().incPts(2);
	}

	@Override
	public Joueur getPremierJoueur() {
		return super.getJoueur1();
	}

	@Override
	public boolean isVainqueur(Joueur j) {
		Joueur joueurAdverse = (j.getCouleur() == super.getJoueurCourant().getCouleur()) ? super.getJoueurAdverse() : super.getJoueurCourant();
		return (j.getPts() > joueurAdverse.getPts());
	}
	
	@Override
	public boolean isFinDePartie() {
		return super.getPlateau().isFull() || personnePeutJouer;
	}
	
	@SuppressWarnings("unchecked")
	public boolean searchCoupsPossibles() {
		// case fait partie du plateau
		initCoupsPossibles();
		
		for(int li=1; li <= super.getPlateau().getNbLignes(); li++) {
			for(int col=1; col <= super.getPlateau().getNbColonnes(); col++) {
				//System.out.println(col+";"+li);
				
				if(super.getPlateau().getCase(new Coord(col, li)) == null) {
					
					Coord[] pionsAttaquablesTmp = new Coord[COTE*COTE];
					int nbPionsAttaquablesTmp = 0;
					boolean attaque = false;
					
					// pour chaque direction
					for (Directions d : Directions.values()){
						//System.out.println(d);
						Pion caseTmp;
						
						// case associée à la direction
						int xDir = d.getX();
						int yDir = d.getY();
						
						Coord[] tabCoordPionsTmp = new Coord[COTE];
						caseTmp = super.getPlateau().getCase(new Coord(col, li));
						int i=0; // le nb de pas dans une direction 
						int j=0; // le nb de cases attaquées dans une direction
						int currentX, currentY;
						
						attaque = false;
						
						do {
							i++; // le nb de pas dans une direction
							currentX = col + xDir*i;
							currentY = li + yDir*i;
							Coord coordTmp = new Coord(currentX, currentY); // le nouveau pas
					
							if(super.getPlateau().isValidCoord(coordTmp)){
								
								caseTmp = super.getPlateau().getCase(coordTmp); // la case correspondante
								
								if(caseTmp != null) { // la case est occupée
									
									if(caseTmp.getCouleur() == super.getJoueurAdverse().getCouleur()) { // par un pion adverse
										// cette case est susceptible  d'être attaquée
										j++;
										tabCoordPionsTmp[j-1] = coordTmp;
									}
									else if(caseTmp.getCouleur() == super.getJoueurCourant().getCouleur()){ // par lui-même
										attaque = true;
										if(j > 0){
											// on tombe sur la couleur du joueur courant
											// => on peut attaquer les cases précédentes
											for(int l=0; l<j; l++) { // pour chaque case attaquable avant
												nbPionsAttaquablesTmp++;
												pionsAttaquablesTmp[nbPionsAttaquablesTmp-1] = tabCoordPionsTmp[l];
											}
										}
									}
								}
							}
						} while((caseTmp != null) && (!attaque));
						
					}
					// aucune case attaquable
					if(nbPionsAttaquablesTmp > 0) {
						Coord cTmp = new Coord(col, li);
						this.nbPionsAttaquables.put(cTmp, new Integer(nbPionsAttaquablesTmp));
						this.coupsPossibles.put(cTmp, pionsAttaquablesTmp);
					}
				}
			}
		}
		return (this.coupsPossibles.size() > 0);
	}

	@Override
	public boolean peutJouer(Coord c) {
		
		// case fait partie du plateau
		if(!((c.getX() < 0 || c.getX() > COTE) && (c.getX() < 0 || c.getX() > COTE))) {
						
			// pour chaque coup possible
			Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
	        while (iterator.hasNext()) {
	            Map.Entry<Coord, Coord[]> entry = iterator.next();
	            if(entry.getKey().getX()==c.getX() && entry.getKey().getY()==c.getY()) return true;
	        }
		}
		return false;
	}
	

	public void initCoupsPossibles() {
		this.coupsPossibles = new HashMap<Coord, Coord[]>();
		this.nbPionsAttaquables = new HashMap<Coord, Integer>();
	}

	// ----------------------
	// source : https://www.baeldung.com/java-check-string-number
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	// ----------------------
	
	@Override
	public String saisie() {
		Scanner scanner = new Scanner(System.in);
		boolean erreur = false;
		boolean nombre = true;
		//boolean saisieValide = false;
		
		String choixStr="";
		int choixInt=-1;
		
		do {
			if(erreur) { 
				System.out.println("Mauvaise saisie, veuillez entrer un nombre entre 1 et "+this.coupsPossibles.size());
			}
			else {
				System.out.println("Veuillez choisir un coup possible parmis les propositions ci-dessus entre 1 et "+this.coupsPossibles.size());
			}
			System.out.print("Votre choix : ");
			
			choixStr = scanner.next();
			
			if(isNumeric(choixStr))choixInt=Integer.parseInt(choixStr);
			erreur = !(nombre && choixInt > 0 && choixInt <= this.coupsPossibles.size());
		} while (erreur);
		
		
		//scanner.close(); 
		Coord coordChoisie = getCoupPossible(choixInt-1);
		return coordChoisie.getX() + ";" + coordChoisie.getY();
	}
	
	private Coord getCoupPossible(int i) {
		Set<Coord> keySet = this.coupsPossibles.keySet();
		Coord[] keyArray = keySet.toArray(new Coord[keySet.size()]);
		return keyArray[i];
	}
	
	private void remettreNullCoupsPossibles() {
		Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
		while (iterator.hasNext()) {
            Map.Entry<Coord, Coord[]> entry = iterator.next();	
        	super.getPlateau().poser(null, new Coord(entry.getKey().getX(), entry.getKey().getY()));  
        }
	}
	
	private void poserNullCoupsPossibles() {
		int j=0;
		Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
		while (iterator.hasNext()) {
			j++;
            Map.Entry<Coord, Coord[]> entry = iterator.next();	
            //System.out.println(entry.getKey().getX()+" "+ entry.getKey().getY());
        	super.getPlateau().poser(new PionAPoser("("+j+")"), new Coord(entry.getKey().getX(), entry.getKey().getY()));  
        }
	}

	private String afficherCoupsPossibles() {
		int j=0;
		StringBuilder str = new StringBuilder();
		Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
		while (iterator.hasNext()) {
			j++;
            Map.Entry<Coord, Coord[]> entry = iterator.next();
            str.append("("+ j + ") Coup : (" + entry.getKey().getX() + ";" + entry.getKey().getY() + ") => Attaquables : ");
    
            for(int i=0; i < (int) this.nbPionsAttaquables.get(entry.getKey()); i++) {
            	str.append("(" + entry.getValue()[i].getX() + ";" + entry.getValue()[i].getY() + ") ");
            }
            
            str.append("\n");
            
        }
		return str.toString();
	}
	
	@Override
	public void jouer() {
		boolean jPeutJouer=true;
		do {
			System.out.println("C'est aux "+super.getJoueurCourant().getCouleur()+"S de jouer (Pts : " + +super.getJoueurCourant().getPts() + ")\n");
			
			if(searchCoupsPossibles()) {
				
				poserNullCoupsPossibles();
				System.out.println(this.getPlateau());
				System.out.println("Coups possibles (colonne;ligne): ");
				System.out.println(afficherCoupsPossibles());
				
				boolean coup_accepte;
				
				do {	
					String saisie = saisie();
					int x = Integer.parseInt(saisie.split(";")[0]);
					int y = Integer.parseInt(saisie.split(";")[1]);
					Coord coup = new Coord(x, y);
				
					coup_accepte = peutJouer(coup);
					
					if(coup_accepte) {
				        
						// dépôt pion et attaque
						Iterator<Map.Entry<Coord, Coord[]>>iterator = this.coupsPossibles.entrySet().iterator();
						while (iterator.hasNext()) {
				            Map.Entry<Coord, Coord[]> entry = iterator.next();
				            if((entry.getKey().getX() == coup.getX()) && (entry.getKey().getY() == coup.getY())) {
				            	
				            	// maj des points
				            	super.getJoueurCourant().incPts((int)this.nbPionsAttaquables.get(entry.getKey()));
				            	
				            	// attaque
				            	for(int i=0; i < (int) this.nbPionsAttaquables.get(entry.getKey()); i++) {
				            		((PionDeuxCouleurs) super.getPlateau().getCase(new Coord(entry.getValue()[i].getX(), entry.getValue()[i].getY()))).changeCouleur();
				                }
				            }
				        }
						
						remettreNullCoupsPossibles();
						
						Pion nouveauPion = new PionDeuxCouleurs(super.getJoueurCourant().getCouleur(), super.getJoueurAdverse().getCouleur());
						super.getPlateau().poser(nouveauPion, coup);
						
						Joueur j = (super.getJoueurCourant().getCouleur() ==  super.getJoueur1().getCouleur()) ? super.getJoueur2() : super.getJoueur1();
						
						super.setJoueurCourant(j);
						
						System.out.println(this.getPlateau());
					} else {
						System.out.println("\n### Vous ne pouvez pas jouer ce coup ###");
					}
					
				} while(!coup_accepte);
				
			} else {
				System.out.println("Vous ne pouvez rien jouer, passez votre tour.");
				if(!jPeutJouer) { personnePeutJouer = true; break;
				} else { jPeutJouer = false;}
			}

			System.out.println("-------------------------------------");
		} while(!this.isFinDePartie());
		
		Joueur vainqueur = 
				isVainqueur(super.getJoueur1()) ? 
						super.getJoueur1() : 
							((isVainqueur(super.getJoueur2()) ? 
									super.getJoueur2():null));
		if(vainqueur == null) {
			System.out.println("égalité avec " + super.getJoueur1().getPts() + " pts chacun.");
		} else {
			System.out.println(vainqueur + " a gagné avec "+vainqueur.getPts()+" pts.");
		}

	}

}

/*
int ligne=-1; int colonne=-1;
String aSaisir = "colonne";
do {
	if(erreur) { 
		System.out.println("Mauvaise saisie, veuillez entrer un nombre entre 1 et "+COTE);
	}
	else {
		System.out.println("Veuillez entrer une "+aSaisir+" (1 à "+COTE+") du pion que vous voulez placer");
	}
	System.out.print("Votre choix : ");
	saisi = scanner.nextInt();
	if(!erreur) {
		if(aSaisir == "colonne") {
			aSaisir = "ligne";
			colonne = saisi;
		} else if(aSaisir == "ligne") {
			ligne = saisi; break;
		}
	}
	if(saisieValide = (saisi < 1 || saisi > COTE)){
		erreur = true;
	}
} while (!saisieValide);*/