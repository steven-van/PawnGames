
public class Othello extends Jeu2JoueursAPion {
	
	public Othello(Joueur joueur1, Joueur joueur2) {
		 super(new Plateau(8, 8), joueur1, joueur2);
		 initialisationJeu();
	}
	
	@Override
	public void initialisationJeu() {
		Pion pNoir1 = new PionDeuxCouleurs("Noir", "Blanc", "Noir");
		Pion pNoir2 = new PionDeuxCouleurs("Noir", "Blanc", "Noir");
		super.getPlateau().poser(pNoir1, new Coord(4, 5));
		super.getPlateau().poser(pNoir2, new Coord(5, 4));
		Pion pBlanc1 = new PionDeuxCouleurs("Blanc", "Blanc", "Noir");
		Pion pBlanc2 = new PionDeuxCouleurs("Blanc", "Blanc", "Noir");
		super.getPlateau().poser(pBlanc1, new Coord(4, 4));
		super.getPlateau().poser(pBlanc2, new Coord(5, 5));
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
	public boolean peutJouer(Coord c) {
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
	
	public static void main(String[] args) {
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		IJeu othello = new Othello(j1, j2);
		System.out.println(((Jeu2JoueursAPion) othello).getPlateau());
	}

}
