package jeu;
import utileJeux.Couleurs;

public class Joueur {
	private Couleurs couleur;
	private int pts;
	
	public Joueur(Couleurs couleur) {
		this.couleur = couleur;
		this.pts = 0;
	}
	
	public Couleurs getCouleur() {
		return this.couleur;
	}
	
	public void setCamp(Couleurs c) {
		this.couleur = c;
	}
	
	public void incPts(int pts) {
		this.pts += pts;
	}
	
	public int getPts() {
		return this.pts;
	}
	
	public String toString() {
		return couleur + "";
	}
}
