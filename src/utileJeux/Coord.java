package utileJeux;

public class Coord {
	// l'abscisse
	private int x;
	// l'ordonnée
	private int y;
	
	/**
	 * @brief constructeur de coordonnée
	 * @param colonne : la colonne
	 * @param ligne : la ligne
	 */
	public Coord(int colonne, int ligne) {
		this.x = colonne;
		this.y = ligne;
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
	
	/**
	 * @brief change la valeur de x
	 * @param x : la nouvelle abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @brief change la valeur de y
	 * @param y : la nouvelle ordonnée
	 */
	public void setY(int y) {
		this.y = y;
	}
}
