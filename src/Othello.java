
public class Othello extends Jeu2JoueursAPion {
	
	public Othello(Joueur joueur1, Joueur joueur2) {
		 super(new Plateau(8, 8), joueur1, joueur2);
		 initialisationJeu();
	}
	
	@Override
	public void initialisationJeu() {
		Pion pNoir1 = new PionDeuxCouleurs(Couleurs.NOIR, Couleurs.BLANC);
		Pion pNoir2 = new PionDeuxCouleurs(Couleurs.NOIR, Couleurs.BLANC);
		super.getPlateau().poser(pNoir1, new Coord(4, 5));
		super.getPlateau().poser(pNoir2, new Coord(5, 4));
		Pion pBlanc1 = new PionDeuxCouleurs(Couleurs.BLANC, Couleurs.NOIR);
		Pion pBlanc2 = new PionDeuxCouleurs(Couleurs.BLANC, Couleurs.NOIR);
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
		Joueur jCourant = super.getJoueurCourant();
		Joueur jAdverse = super.getJoueurAdverse();
		Pion p = new PionDeuxCouleurs(jCourant.getCouleur(), jAdverse.getCouleur());
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
		Joueur j1 = new Joueur(Couleurs.NOIR);
		Joueur j2 = new Joueur(Couleurs.BLANC);
		IJeu othello = new Othello(j1, j2);
		System.out.println(((Jeu2JoueursAPion) othello).getPlateau());
	}

}
