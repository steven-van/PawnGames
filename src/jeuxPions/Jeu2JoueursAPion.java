package jeuxPions;

import java.util.Scanner;

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
	
	// si le joueur veut quitter la partie
	private boolean quitterPartie = false;

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
	 * @return true si l'utilisateur veut quitter la partie
	 */
	public boolean questionFinDePartie() {
		System.out.println("Voulez-vous quitter la partie? (1) oui ; ailleurs sinon");
		Scanner sc = new Scanner(System.in);
		String choix = sc.next();
		choix = choix.trim();
		
		if(!choix.isEmpty()) {
			try {
				int choixInt = Integer.parseInt(choix);
		        if(choixInt == 1) {
		        	this.quitterPartie = true;
					System.out.println("quitter");
					return true;
				} else {
					this.quitterPartie = false;
					return false;
				}
			} catch (NumberFormatException nfe) {
				this.quitterPartie = false;
				return false;
		    }
		} else {
			this.quitterPartie = false;
			return false;
		}
	}
	
	/**
	 * @return quitterPartie 
	 */
	public boolean getQuitterPartie() {
		return this.quitterPartie;
	}
	
	/**
	 * @brief commence une partie (à spécialiser)
	 * @return true si l'utilisateur continue la partie ; false sinon
	 */
	@Override
	public abstract boolean jouer();

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
