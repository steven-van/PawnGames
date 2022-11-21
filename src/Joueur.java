
public class Joueur {
	private String camp;
	
	public String getCamp() {
		return this.camp;
	}
	
	public void setCamp(String c) {
		this.camp = c;
	}
	
	public String toString() {
		return "Le joueur est dans le camp " + camp;
	}
}
