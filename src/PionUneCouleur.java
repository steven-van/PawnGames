
public class PionUneCouleur implements Pion {
	private String couleur;
	
	@Override
	public void setCouleur(String c) {
		this.couleur = c;

	}

	@Override
	public String getCouleur() {		
		return this.couleur;
	}

}
