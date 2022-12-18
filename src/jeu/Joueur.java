package jeu;
import utileJeux.Couleurs;

public class Joueur {
	// la couleur du joueur
	private Couleurs couleur;
	// le score du joueur
	private int pts;
	
	/**
	 * @brief constructeur de Joueur
	 * @param couleur : la couleur du joueur
	 */
	public Joueur(Couleurs couleur) {
		this.couleur = couleur;
		this.pts = 0;
	}
	
	/**
	 * @return la couleur du joueur
	 */
	public Couleurs getCouleur() {
		return this.couleur;
	}
	
	/**
	 * @brief change la couleur du joueur 
	 * @param c : la nouvelle couleur du joueur
	 */
	public void setCouleur(Couleurs c) {
		this.couleur = c;
	}
	
	/**
	 * @brief ajoute des points au score du joueur
	 * @param pts : le nombre de points à ajouter
	 */
	public void incPts(int pts) {
		this.pts += pts;
	}
	
	/**
	 * @return le score du joueur
	 */
	public int getPts() {
		return this.pts;
	}
	
	public String toString() {
		return couleur + "";
	}
}
