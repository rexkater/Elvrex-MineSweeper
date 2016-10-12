
public class Coordinates {
	
	private int x;
	private int y;
	
	// Constructor for coordinate pairs.
	
	public Coordinates(int a, int b){
		
		this.x = a;
		this.y = b;
		
	}
	
	public String toString(){
		
		return "(" + getX() + ", " + getY() + ")";
		
	}
	
	// Getters

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	// Setters

	public void setX(int a) {
		this.x = a;
	}

	public void setY(int b) {
		this.y = b;
	}

}
