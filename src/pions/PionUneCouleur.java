package pions;
import utileJeux.Couleurs;

public class PionUneCouleur extends Pion {
	
	/**
	 * @brief constructeur de PionUneCouleur
	 * @param couleur : la couleur du pion
	 */
	public PionUneCouleur(Couleurs couleur) {
		super(couleur);
	}
	
	
	public String toString() {
		return super.getCouleur().toString();
	}
}
