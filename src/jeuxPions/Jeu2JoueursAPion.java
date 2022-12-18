package jeuxPions;

import jeu.IJeu;
import jeu.Joueur;
import utileJeux.Coord;
import utileJeux.Plateau;

public abstract class Jeu2JoueursAPion implements IJeu {
	// le plateau de jeu
	private Plateau plateau;
	
	// le joueur 1
	private Joueur joueur1;
	
	// le joueur 2
	private Joueur joueur2;
	
	// le joueur courant
	private Joueur joueurCourant;

	/**
	 * @brief constructeur de Jeu2JoueursAPion
	 * @param plateau : le plateau de jeu
	 * @param joueur1 : le joueur 1
	 * @param joueur2 : le joueur 2
	 */
	public Jeu2JoueursAPion(Plateau plateau, Joueur joueur1, Joueur joueur2) {
		this.plateau = plateau;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	/**
	 * @return le joueur courant
	 */
	@Override
	public Joueur getJoueurCourant() {
		return this.joueurCourant;
	}

	/**
	 * @return le joueur adverse
	 */
	public Joueur getJoueurAdverse() {
		return (this.joueurCourant.getCouleur() == joueur1.getCouleur()) ? joueur2 : joueur1;
	}

	/**
	 * @brief change le joueur courant
	 * @param j : le nouveau joueur courant
	 */
	@Override
	public void setJoueurCourant(Joueur j) {
		this.joueurCourant = j;
	}

	/**
	 * @brief initialisation du jeu (à spécialiser)
	 */
	@Override
	public abstract void initialisationJeu();

	/**
	 * @return le premier joueur à jouer (à spécialiser)
	 */
	@Override
	public abstract Joueur getPremierJoueur();

	/**
	 * @param j : le joueur
	 * @return true si le joueur est vainqueur ; false sinon (à spécialiser)
	 */
	@Override
	public abstract boolean isVainqueur(Joueur j);

	/**
	 * @param c : la coordonnée
	 * @return true s'il est possible de jouer cette coordonnée ; false sinon (à spécialiser)
	 */
	public abstract boolean peutJouer(Coord c);

	/**
	 * @return la chaine de caractères saisie au clavier (à spécialiser)
	 */
	@Override
	public abstract String saisie();

	/**
	 * @brief commence une partie (à spécialiser)
	 */
	@Override
	public abstract void jouer();

	/**
	 * @return true si c'est la fin de partie ; false sinon (à spécialiser)
	 */
	@Override
	public abstract boolean isFinDePartie();

	/**
	 * @return le joueur 1
	 */
	public Joueur getJoueur1() {
		return joueur1;
	}

	/**
	 * @brief change le joueur 1
	 * @param j : le nouveau joueur 1
	 */
	public void setJoueur1(Joueur j) {
		this.joueur1 = j;
	}

	/**
	 * @return le joueur 2
	 */
	public Joueur getJoueur2() {
		return joueur2;
	}

	/**
	 * @brief change le joueur 2
	 * @param j : le nouveau joueur 2
	 */
	public void setJoueur2(Joueur j) {
		this.joueur2 = j;
	}

	/**
	 * @return le plateau de jeu
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * @brief change le plateau de jeu
	 * @param p : le nouveau plateau
	 */
	public void setPlateau(Plateau p) {
		this.plateau = p;
	}

}
