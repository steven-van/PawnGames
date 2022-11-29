
public class Othello extends Jeu2JoueursAPion {
	
	public Othello(Plateau plateau, Joueur joueur1, Joueur joueur2) {
		 super(plateau, joueur1, joueur2);
		 initialisationJeu();
	}
	
	@Override
	public void initialisationJeu() {
		Pion pNoir1 = new PionDeuxCouleurs("Noir", "Blanc", "Noir");
		Pion pNoir2 = new PionDeuxCouleurs("Noir", "Blanc", "Noir");
		super.getPlateau().poser(pNoir1, new Coord(4, 5));
		super.getPlateau().poser(pNoir2, new Coord(5, 4));
	}

	@Override
	public Joueur getPremierJoueur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVainqueur(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutJouer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String saisie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jouer() {
		// TODO Auto-generated method stub

	}

}
