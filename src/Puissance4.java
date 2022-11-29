import java.util.Scanner;

public class Puissance4 extends Jeu2JoueursAPion {
	
	public Puissance4(Joueur joueur1, Joueur joueur2) {
		super(new Plateau(6,7), joueur1, joueur2);
		initialisationJeu();
	}

	@Override
	public void initialisationJeu() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public boolean isVainqueur(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String saisie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer la colonne (1 à 7) du pion que vous voulez placer");
		System.out.print("Votre choix : ");
		int col = scanner.nextInt();
		while(col < 1 || col > 7) {
			System.out.println("Mauvaise saisie, veuillez entrer un nombre entre 1 et 7 \n");
			System.out.print("Votre choix : ");
			col = scanner.nextInt();
		}
		scanner.close();
		return Integer.toString(col);
	}

	@Override
	public void jouer() {
		String col = saisie();
		for(int i = 0; i < super.getPlateau().getNbLignes(); i++) {
			
		};


	}

	@Override
	public boolean peutJouer(Coord c) {
		if(super.getPlateau().getCase(c) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Joueur getPremierJoueur() {
		int min = 1;
		int max = 2;
		int numJoueur = (min + (int)(Math.random() * (max - min) + 1));
		Joueur j = numJoueur == 1 ? super.getJoueur1() : super.getJoueur2();
		super.setJoueurCourant(j);
		return j;
	}

}
