
public interface IJeu {
	void initialisationJeu();
	Joueur getPremierJoueur();
	boolean isFinDePartie();
	boolean isVainqueur(Joueur j);
	boolean peutJouer(Joueur j);
	String saisie();
	void jouer();
}
