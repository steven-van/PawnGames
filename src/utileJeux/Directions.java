package utileJeux;

/**
 * @brief enumération des directions utiles pour le parcours du tableau
 */
public enum Directions {
	NORD(0, -1), 
	SUD(0, 1), 
	EST(1, 0), 
	OUEST(-1, 0), 
	NORD_EST(1, -1), 
	NORD_OUEST(-1, -1), 
	SUD_EST(1, 1), 
	SUD_OUEST(-1, 1);
	
	// l'abscisse
	private int x;
	// l'ordonnée
	private int y;
	
	/**
	 * @brief constructeur de direction
	 * @param x : l'abscisse
	 * @param y : l'ordonnée
	 */
	Directions(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return l'abscisse
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * @return l'ordonnée
	 */
	public int getY() {
		return this.y;	
	}
	
}
