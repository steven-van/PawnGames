
public enum Directions {
	NORD(0, -1), 
	SUD(0, 1), 
	EST(1, 0), 
	OUEST(-1, 0), 
	NORD_EST(-1, 1), 
	NORD_OUEST(-1, -1), 
	SUD_EST(1, 1), 
	SUD_OUEST(-1, 1);
	
	int x; 
	int y;
	
	Directions(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
	
	public Directions getDirection(Coord dep, Coord arr){
		Coord d = getCoordDirection(dep, arr);		
		
		if((d.getX()==0) && (d.getY()==-1)) {
			return this.NORD;
		} 
		else if((d.getX()==0) && (d.getY()==1)) {
			return this.SUD;
		} 
		else if((d.getX()==1) && (d.getY()==0)) {
			return this.EST;
		} 
		else if((d.getX()==-1) && (d.getY()==0)) {
			return this.OUEST;
		} 
		else if((d.getX()==-1) && (d.getY()==1)) {
			return this.NORD_EST;
		} 
		else if((d.getX()==-1) && (d.getY()==-1)) {
			return this.NORD_OUEST;
		} 
		else if((d.getX()==1) && (d.getY()==1)) {
			return this.SUD_EST;
		} 
		else if((d.getX()==-1) && (d.getY()==1)) {
			return this.SUD_OUEST;
		} 
		return null;
	}
	
	private Coord getCoordDirection(Coord dep, Coord arr) {
		int coordX = 0;
		int coordY = 0;
		
		if(dep.getX() > arr.getX()) {
			coordX = 1;
		} else if(dep.getX() < arr.getX()) {
			coordX = -1;
		} else if(dep.getX() == arr.getX()) {
			coordX = 0;
		}
		
		if(dep.getY() > arr.getY()) {
			coordY = 1;
		} else if(dep.getY() < arr.getY()) {
			coordY = -1;
		} else if(dep.getY() == arr.getY()) {
			coordY = 0;
		}
		return new Coord(coordX, coordY);
	}
	
}
