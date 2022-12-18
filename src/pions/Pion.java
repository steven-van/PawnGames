package pions;

import utileJeux.Couleurs;

public abstract class Pion {
	// la couleur du pion
	private Couleurs couleur;
	
	/**
	 * @brief constructeur de Pion
	 * @param couleur : la couleur du pion 
	 */
	public Pion(Couleurs couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * @brief change la couleur du pion
	 * @param c : la nouvelle couleur
	 */
	public void setCouleur(Couleurs c) {
		this.couleur = c;
	}
	
	/**
	 * @return la couleur du pion
	 */
	public Couleurs getCouleur() {
		return this.couleur;
	}
}
