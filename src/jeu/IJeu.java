package jeu;

public interface IJeu {
	void initialisationJeu();
	Joueur getPremierJoueur();
	Joueur getJoueurCourant();
	void setJoueurCourant(Joueur j);
	boolean isFinDePartie();
	boolean isVainqueur(Joueur j);
	String saisie();
	boolean jouer();
}
