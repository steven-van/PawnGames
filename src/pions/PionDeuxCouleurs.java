package pions;
import utileJeux.Couleurs;

public class PionDeuxCouleurs extends Pion {
	private Couleurs couleur1;
	private Couleurs couleur2;
	
	public PionDeuxCouleurs(Couleurs couleurCourante, Couleurs couleurAutre) {
		super(couleurCourante);
		this.couleur1 = couleurCourante;
		this.couleur2 = couleurAutre;
	}
	
	public void changeCouleur() {
		super.setCouleur( (super.getCouleur()==couleur1) ? couleur2 : couleur1 );
	}
	
	@Override
	public String toString() {
		return super.getCouleur().toString();
	}
	
	public static void main(String[] args) {
		PionDeuxCouleurs p = new PionDeuxCouleurs(Couleurs.NOIR, Couleurs.BLANC);
		System.out.println(p);
		p.changeCouleur();
		System.out.println(p);
	}
}
