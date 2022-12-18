package utileJeux;
import pions.Pion;

public class Plateau {
	// le tableau de case contenant chacune un Pion ou null
	private Pion[][] cases;
	
	// le nb de lignes du tableau
	private int nbLignes;
	
	// le nb de colonnes du tableau
	private int nbColonnes;
	
	// le nb de pions dans le tableau
	private int nbPions;
	
	/**
	 * @brief constructeur de plateau
	 * @param nbLignes : le nb de lignes du tableau
	 * @param nbColonnes : le nb de colonnes du tableau
	 */
	public Plateau(int nbLignes, int nbColonnes) {
		this.nbPions = 0;
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.cases = new Pion[nbLignes][nbColonnes];
		// initialisation du plateau
		for(int i=0; i<nbLignes; i++) {
			for(int j=0; j<nbColonnes; j++) {
				this.cases[i][j] = null;
			}
		};
	}
	
	/**
	 * @brief pose un pion à une coordonnée du plateau
	 * @param p : le pion à poser
	 * @param c : la coordonnée du plateau
	 */
	public void poser(Pion p, Coord c) {
		//pions[y][x]
		if(isValidCoord(c)) {
			this.cases[c.getY()-1][c.getX()-1] = p;
			if(p != null) this.nbPions++;
		}
	}
	
	/**
	 * @param c : la coordonnée du plateau
	 * @return le pion correspondant à la coordonnée du plateau
	 */
	public Pion getCase(Coord c) {
		return this.cases[c.getY()-1][c.getX()-1];
	}
	
	/**
	 * @return le nb de pions du plateau
	 */
	public int getNbPions() {
		return this.nbPions;
	}
	
	/**
	 * @return le tableau de cases du plateau
	 */
	public Pion[][] getTabCases() {
		return this.cases;
	}
	
	/**
	 * @param c : la coordonnée du plateau
	 * @return true si la coordonnée fait partie du plateau ; false sinon
	 */
	public boolean isValidCoord(Coord c) {
		return c.getY() > 0 && c.getY() <= this.nbLignes && c.getX() > 0 && c.getX() <= this.nbColonnes;
	}
	
	/**
	 * @param c : la coordonnée du plateau
	 * @return true si la coordonnée fait partie du plateau ; false sinon
	 */
	@Override
	public String toString() {
		StringBuilder bld = new StringBuilder();
		for(int i=0; i<this.cases.length; i++) {
			for(int j=0; j<this.cases[i].length; j++) {
				bld.append(this.cases[i][j]);
				bld.append("\t");
			}
			bld.append("\n\n");
		};
		return bld.toString();
	}
	
	/**
	 * @return true si le tableau de cases est plein ; false sinon
	 */
	public boolean isFull() {
		return this.getNbPions() == (this.nbColonnes*this.nbLignes);
	}

	/**
	 * @return le nb de lignes du tableau
	 */
	public int getNbLignes() {
		return this.nbLignes;
	}
	
	/**
	 * @return le nb de colonnes du tableau
	 */
	public int getNbColonnes() {
		return this.nbColonnes;
	}

}
