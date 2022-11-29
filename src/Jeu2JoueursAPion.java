
public abstract class Jeu2JoueursAPion implements IJeu {
	private Plateau plateau;
	private Joueur joueur1;
	private Joueur joueur2;
	
	public Jeu2JoueursAPion(Plateau plateau, Joueur joueur1, Joueur joueur2) {
		this.plateau = plateau;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	@Override
	public abstract void initialisationJeu();

	@Override
	public abstract Joueur getPremierJoueur();

	@Override
	public abstract boolean isVainqueur(Joueur j);

	@Override
	public abstract boolean peutJouer(Joueur j);

	@Override
	public abstract String saisie();

	@Override
	public abstract void jouer();

	@Override
	public boolean isFinDePartie() {
		// TODO Auto-generated method stub
		return false;
	}
	
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
