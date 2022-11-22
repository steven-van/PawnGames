
public class Coord {
	private int x;
	private int y;
	
	public Coord(int ligne, int colonne) {
		this.y = ligne-1;
		this.x = colonne-1;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;	
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
