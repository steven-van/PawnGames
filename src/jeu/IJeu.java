package jeu;

public interface IJeu {
	/**
	 * @brief initialisation du jeu
	 */
	void initialisationJeu();
	
	/**
	 * @return le premier joueur à jouer
	 */
	Joueur getPremierJoueur();
	
	/**
	 * @return le joueur courant
	 */
	Joueur getJoueurCourant();
	
	/**
	 * @brief change le joueur courant
	 * @param j : le nouveau joueur courant
	 */
	void setJoueurCourant(Joueur j);
	
	/**
	 * @return true si c'est la fin de partie ; false sinon
	 */
	boolean isFinDePartie();

	/**
	 * @param j : le joueur
	 * @return true si le joueur est vainqueur ; false sinon
	 */
	boolean isVainqueur(Joueur j);
	
	/**
	 * @return la chaine de caractères saisie au clavier 
	 */
	String saisie();

	/**
	 * @brief commence une partie
	 * @return true si l'utilisateur continue la partie ; false sinon
	 */
	boolean jouer();
}

