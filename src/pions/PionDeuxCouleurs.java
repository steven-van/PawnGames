package pions;
import utileJeux.Couleurs;

public class PionDeuxCouleurs extends Pion {
	// la couleur 1
	private Couleurs couleur1;
	// la couleur 2
	private Couleurs couleur2;
	
	/**
	 * @brief constructeur de PionDeuxCouleurs
	 * @param couleurCourante : la couleur courante 
	 * @param couleurAutre : la seconde couleur
	 */
	public PionDeuxCouleurs(Couleurs couleurCourante, Couleurs couleurAutre) {
		super(couleurCourante);
		this.couleur1 = couleurCourante;
		this.couleur2 = couleurAutre;
	}
	
	/**
	 * @brief change la couleur courante 
	 */
	public void changeCouleur() {
		super.setCouleur( (super.getCouleur()==couleur1) ? couleur2 : couleur1 );
	}
	
	@Override
	public String toString() {
		return super.getCouleur().toString();
	}
	
}
