
public class PionUneCouleur extends Pion {
	
	public PionUneCouleur(Couleurs couleur) {
		super(couleur);
	}

	public String toString() {
		return super.getCouleur().toString();
	}
}
