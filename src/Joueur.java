
public class Joueur {
	private Couleurs couleur;
	
	public Joueur(Couleurs couleur) {
		this.couleur = couleur;
	}
	
	public Couleurs getCouleur() {
		return this.couleur;
	}
	
	public void setCamp(Couleurs c) {
		this.couleur = c;
	}
	
	public String toString() {
		return "Le joueur est dans le camp " + couleur;
	}
}
