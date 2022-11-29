
public interface IJeu {
	void initialisationJeu();
	Joueur getPremierJoueur();
	boolean isFinDePartie();
	boolean isVainqueur(Joueur j);
	String saisie();
	void jouer();
}
