import java.util.ArrayList;

public class Othello extends Jeu2JoueursAPion {
	
	// joueur 1 = NOIRS
	// joueur 2 = BLANCS
	
	final static int COTE = 8;
	private Coord[] coordPionsAttaquables;
	private int nbPionsAttaquables;
	
	public Othello(Joueur joueur1, Joueur joueur2) {
		 super(new Plateau(COTE, COTE), joueur1, joueur2);
		 initialisationJeu();
		 super.setJoueurCourant(joueur1);
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
	}

	@Override
	public Joueur getPremierJoueur() {
		return null;
	}

	@Override
	public boolean isVainqueur(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutJouer(Coord c) {
		
		Joueur jCourant = super.getJoueurCourant();
		
		// case fait partie du plateau
		if(!((c.getX() < 0 || c.getX() > COTE) && (c.getX() < 0 || c.getX() > COTE))) {
			
			Pion caseTmp;
			initPionsAttaquables();
			
			// pour chaque direction
			for (Directions d : Directions.values()){
						
				// case associée à la direction
				int xDir = d.getX();
				int yDir = d.getY();
				
				System.out.println(c.getX()+" "+c.getY() + " " + d + " \t=> "+ xDir + ";"+ yDir);
				
				Coord[] tabCoordPionsTmp = new Coord[COTE];
				caseTmp = super.getPlateau().getCase(new Coord(c.getX(), c.getY()));
				int i=0;
				int j=0;
				int currentX;
				int currentY;
				
				do {
					i++;
					currentX = c.getX() + xDir*i;
					currentY = c.getY() + yDir*i;
					
					if(currentX == 0) currentX = 1;
					if(currentY == 0) currentY = 1;
					
					caseTmp = super.getPlateau().getCase(new Coord(currentX, currentY));
					
					System.out.println("**i="+i+" / colonne "+ currentX + "; ligne "+currentY+" "+(caseTmp != null ? caseTmp.getCouleur():""));
					System.out.println(caseTmp);
					
					if(caseTmp != null) {
						if(caseTmp.getCouleur() != jCourant.getCouleur()) {
							// cette case est susceptible  d'être attaquée
							System.out.println("stockage tmp " + caseTmp);
							j++;
							tabCoordPionsTmp[j-1] = new Coord(currentX, currentY);
						}
						else if(j != 0){
							System.out.println("ATTAQUABLE par direction : "+ d +" !!");
							// on tombe sur la couleur du joueur courant
							// => on peut attaquer les cases précédentes
							for(int l=0; l<j; l++){
								System.out.println("stockage " + tabCoordPionsTmp[l]);
								this.nbPionsAttaquables++;
								this.coordPionsAttaquables[nbPionsAttaquables-1] = tabCoordPionsTmp[l];
							}
						}
					}
					
					System.out.println();
				} while((caseTmp != null) && (caseTmp.getCouleur() != jCourant.getCouleur()));
				
			}
			// aucune case attaquable
			if(this.coordPionsAttaquables.length > 0) {
				return true;
			} 
			
		}	
			
		return false;
	}
	
	public void initPionsAttaquables() {
		this.coordPionsAttaquables = new Coord[COTE*COTE];
		this.nbPionsAttaquables=0;
	}

	@Override
	public String saisie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jouer() {
		Coord coup = new Coord(3, 4);
		if(peutJouer(coup)) {
			System.out.println("Possible\n");
			for(int l=0; l<nbPionsAttaquables; l++) {
				((PionDeuxCouleurs) super.getPlateau().getCase(this.coordPionsAttaquables[l])).changeCouleur();
			}
			Pion nouveauPion = new PionDeuxCouleurs(super.getJoueurCourant().getCouleur(), super.getJoueurAdverse().getCouleur());
			super.getPlateau().poser(nouveauPion, coup);
			
		} else {
			System.out.println("pas possible");
		}

	}

}