
public class Appli {
	
	public static void main(String[] args) {
		Joueur j1 = new Joueur(Couleurs.NOIR);
		Joueur j2 = new Joueur(Couleurs.BLANC);
		IJeu othello = new Othello(j1, j2);
		
		System.out.println(((Jeu2JoueursAPion) othello).getPlateau());
		
		othello.jouer();
		
		System.out.println(((Jeu2JoueursAPion) othello).getPlateau());
	}
}
