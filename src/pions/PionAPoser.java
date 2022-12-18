package pions;
import utileJeux.Couleurs;

public class PionAPoser extends Pion {
	// le symbole du pion
	String symbole;
	
	/**
	 * @brief constructeur de PionAPoser
	 * @param symbole : le symbole du pion
	 */
	public PionAPoser(String symbole) {
		super(Couleurs.POSER);
		this.symbole = symbole;
	}
	
	@Override
	public String toString() {
		return symbole;
	}

}
