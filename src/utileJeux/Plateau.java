package utileJeux;
import pions.Pion;

public class Plateau {
	private Pion[][] cases;
	private int nbLignes;
	private int nbColonnes;
	private int nbPions;
	
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
	
	public void poser(Pion p, Coord c) {
		//pions[y][x]
		if(isValidCoord(c)) {
			this.cases[c.getY()-1][c.getX()-1] = p;
			if(p != null) this.nbPions++;
		}
	}
	
	public Pion getCase(Coord c) {
		return this.cases[c.getY()-1][c.getX()-1];
	}
	
	public int getNbPions() {
		return this.nbPions;
	}
	
	public Pion[][] getTabCases() {
		return this.cases;
	}
	
	public boolean isValidCoord(Coord c) {
		return c.getY() > 0 && c.getY() <= this.nbLignes && c.getX() > 0 && c.getX() <= this.nbColonnes;
	}
	
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
	
	public boolean isFull() {
		return this.getNbPions() == (this.nbColonnes*this.nbLignes);
	}

	public int getNbLignes() {
		return this.nbLignes;
	}
	
	public int getNbColonnes() {
		return this.nbColonnes;
	}

}
