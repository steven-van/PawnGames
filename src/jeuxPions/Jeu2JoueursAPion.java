package jeuxPions;

import jeu.IJeu;
import jeu.Joueur;
import utileJeux.Coord;
import utileJeux.Plateau;

public abstract class Jeu2JoueursAPion implements IJeu {
	private Plateau plateau;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurCourant;

	public Jeu2JoueursAPion(Plateau plateau, Joueur joueur1, Joueur joueur2) {
		this.plateau = plateau;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	@Override
	public Joueur getJoueurCourant() {
		return this.joueurCourant;
	}

	public Joueur getJoueurAdverse() {
		return (this.joueurCourant.getCouleur() == joueur1.getCouleur()) ? joueur2 : joueur1;
	}

	@Override
	public void setJoueurCourant(Joueur j) {
		this.joueurCourant = j;
	}

	@Override
	public abstract void initialisationJeu();

	@Override
	public abstract Joueur getPremierJoueur();

	@Override
	public abstract boolean isVainqueur(Joueur j);

	public abstract boolean peutJouer(Coord c);

	@Override
	public abstract String saisie();

	@Override
	public abstract void jouer();

	@Override
	public abstract boolean isFinDePartie();

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur j) {
		this.joueur1 = j;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur j) {
		this.joueur2 = j;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau p) {
		this.plateau = p;
	}

}
