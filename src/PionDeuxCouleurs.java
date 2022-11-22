
public class PionDeuxCouleurs extends Pion {
	private String couleur1;
	private String couleur2;
	
	public PionDeuxCouleurs(String couleur, String couleur1, String couleur2) {
		super(couleur);
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
	}
	
	public void changeCouleur() {
		super.setCouleur( (super.getCouleur()==couleur1) ? couleur2 : couleur1 );
	}
	
	public String toString() {
		return super.getCouleur();
	}
	
	public static void main(String[] args) {
		PionDeuxCouleurs p = new PionDeuxCouleurs("noir", "noir", "blanc");
		System.out.println(p);
		p.changeCouleur();
		System.out.println(p);
	}
}
