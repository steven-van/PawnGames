import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;

public class Othello extends Jeu2JoueursAPion {
	
	// joueur 1 = NOIRS
	// joueur 2 = BLANCS
	
	final static int COTE = 8;
	private Coord[] coordPionsAttaquables;
	// les coords des pions attaquables par coord de coup possible
	@SuppressWarnings("rawtypes")
	Map coupsPossibles = new HashMap<Coord, Coord[]>();
	Map nbPionsAttaquables = new HashMap<Coord, Integer>();
	//private int nbPionsAttaquables;
	
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
	}

	@Override
	public Joueur getPremierJoueur() {
		return super.getJoueur1();
	}

	@Override
	public boolean isVainqueur(Joueur j) {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean searchCoupsPossibles() {
		// case fait partie du plateau
		initCoupsPossibles();

		//initPionsAttaquables();
		
		for(int li=1; li <= super.getPlateau().getNbLignes(); li++) {
			for(int col=1; col <= super.getPlateau().getNbColonnes(); col++) {
				//System.out.println(col+";"+li);
				Coord[] pionsAttaquablesTmp = new Coord[COTE*COTE];
				int nbPionsAttaquablesTmp = 0;
				
				// pour chaque direction
				for (Directions d : Directions.values()){
					
					Pion caseTmp;
					
					// case associée à la direction
					int xDir = d.getX();
					int yDir = d.getY();
					
					Coord[] tabCoordPionsTmp = new Coord[COTE];
					caseTmp = super.getPlateau().getCase(new Coord(li, col));
					int i=0;
					int j=0;
					int currentX;
					int currentY;
					
					do {
						i++;
						currentX = col + xDir*i;
						currentY = li + yDir*i;
						
						if(super.getPlateau().isValidCoord(new Coord(currentX, currentY))){
							
							caseTmp = super.getPlateau().getCase(new Coord(currentX, currentY));
							
							if(caseTmp != null) {
								if(caseTmp.getCouleur() != super.getJoueurCourant().getCouleur()) {
									// cette case est susceptible  d'être attaquée
									j++;
									tabCoordPionsTmp[j-1] = new Coord(currentX, currentY);
								}
								else if(j > 0){
									//System.out.println("ATTAQUABLE par direction : "+ d +" !!");
									// on tombe sur la couleur du joueur courant
									// => on peut attaquer les cases précédentes
									for(int l=0; l<j; l++) {
										nbPionsAttaquablesTmp++;
										pionsAttaquablesTmp[nbPionsAttaquablesTmp-1] = tabCoordPionsTmp[l];
									}
								}
							}
						}
					} while((caseTmp != null) && (caseTmp.getCouleur() != super.getJoueurCourant().getCouleur()));
				}
				// aucune case attaquable
				if(nbPionsAttaquablesTmp > 0) {
					Coord cTmp = new Coord(col, li);
					this.nbPionsAttaquables.put(cTmp, new Integer(nbPionsAttaquablesTmp));
					this.coupsPossibles.put(cTmp, pionsAttaquablesTmp);
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

	@Override
	public String saisie() {
		Scanner scanner = new Scanner(System.in);
		boolean erreur = false;
		boolean saisieValide = false;
		int ligne=-1; int colonne=-1;
		String aSaisir = "colonne";
		int saisi;
		
		System.out.println("Coups possibles (colonne;ligne): ");
		StringBuilder str = new StringBuilder();
		
		Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
        
		while (iterator.hasNext()) {
            Map.Entry<Coord, Coord[]> entry = iterator.next();
            str.append("Key : (" + entry.getKey().getX() + ";" + entry.getKey().getY() + ") => values : ");
    
            for(int i=0; i < (int) this.nbPionsAttaquables.get(entry.getKey()); i++) {
            	str.append("(" + entry.getValue()[i].getX() + ";" + entry.getValue()[i].getY() + ") ");
            }
            
            str.append("\n");
        }
		System.out.println(str.toString());
		
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
		} while (!saisieValide);
		
		//scanner.close(); 
		return Integer.toString(colonne)+";"+Integer.toString(ligne);
	}
	
	@Override
	public boolean isFinDePartie() {
		return isVainqueur(super.getJoueurCourant()) || super.getPlateau().isFull();
	}

	@Override
	public void jouer() {
		do {
			System.out.println("C'est aux "+super.getJoueurCourant().getCouleur()+"S de jouer.");
			
			if(searchCoupsPossibles()) {
				
				Iterator<Map.Entry<Coord, Coord[]>> iterator = this.coupsPossibles.entrySet().iterator();
				
				while (iterator.hasNext()) {
		            Map.Entry<Coord, Coord[]> entry = iterator.next();	
	            	super.getPlateau().poser(new PionAPoser(), new Coord(entry.getKey().getX(), entry.getKey().getY()));  
		        }
				System.out.println(this.getPlateau());
				
				String saisie = saisie();
				int x = Integer.parseInt(saisie.split(";")[0]);
				int y = Integer.parseInt(saisie.split(";")[1]);
				Coord coup = new Coord(x, y);
				
				if(peutJouer(coup)) {
					System.out.println("Possible :\n");
			        
					iterator = this.coupsPossibles.entrySet().iterator();
					while (iterator.hasNext()) {
			            Map.Entry<Coord, Coord[]> entry = iterator.next();
			            if((entry.getKey().getX() == coup.getX()) && (entry.getKey().getY() == coup.getY())) {
			            	
			            	for(int i=0; i < (int) this.nbPionsAttaquables.get(entry.getKey()); i++) {
			            		((PionDeuxCouleurs) super.getPlateau().getCase(new Coord(entry.getValue()[i].getX(), entry.getValue()[i].getY()))).changeCouleur();
			                }
			            }
			        }
					
					iterator = this.coupsPossibles.entrySet().iterator();
					while (iterator.hasNext()) {
			            Map.Entry<Coord, Coord[]> entry = iterator.next();	
		            	super.getPlateau().poser(null, new Coord(entry.getKey().getX(), entry.getKey().getY()));  
			        }
					
					Pion nouveauPion = new PionDeuxCouleurs(super.getJoueurCourant().getCouleur(), super.getJoueurAdverse().getCouleur());
					super.getPlateau().poser(nouveauPion, coup);
					
					Joueur j = (super.getJoueurCourant().getCouleur() ==  super.getJoueur1().getCouleur()) ? super.getJoueur2() : super.getJoueur1();
					super.setJoueurCourant(j);
				} else {
					System.out.println("Vous ne pouvez pas jouer ce coup.");
				}
				
			} else {
				System.out.println("Vous ne pouvez rien jouer, passez votre tour.");
			}
			System.out.println(this.getPlateau());
		} while(!this.isFinDePartie());

	}

}