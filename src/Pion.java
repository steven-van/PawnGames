
public abstract class Pion {
	private Couleurs couleur;
	
	public Pion(Couleurs couleur) {
		this.couleur = couleur;
	}
	
	public void setCouleur(Couleurs c) {
		this.couleur = c;
	}
	public Couleurs getCouleur() {
		return this.couleur;
	}
}
