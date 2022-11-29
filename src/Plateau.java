

public class Plateau {
	private Pion[][] cases;
	int nbLignes;
	int nbColonnes;
	
	public Plateau(int nbLignes, int nbColonnes) {
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
		if(isValidCoord(c)) this.cases[c.getY()][c.getX()] = p;
	}
	
	public Pion getCase(Coord c) {
		return this.cases[c.getY()][c.getX()];
	}
	
	public boolean isValidCoord(Coord c) {
		return c.getY() < this.nbLignes && c.getX() < this.nbColonnes;
	}
	
	public String toString() {
		StringBuilder bld = new StringBuilder();
		for(int i=0; i<this.cases.length; i++) {
			for(int j=0; j<this.cases[i].length; j++) {
				bld.append(this.cases[i][j]);
				bld.append("  ");
			}
			bld.append("\n\n");
		};
		return bld.toString();
	}
	
}
