package pions;
import utileJeux.Couleurs;

public class PionAPoser extends Pion {
	String symbole;
	public PionAPoser(String symbole) {
		super(Couleurs.POSER);
		this.symbole = symbole;
	}
	
	@Override
	public String toString() {
		return symbole;
	}

}
