import java.util.Random;
// import javax.swing.JFrame;

public class MineCoordinates {
	
	private Coordinates[] MineCoordinates;
	//private Coordinates Coordinates;
	
	// Creates an objects array to place the mines coordinates.
	
	public MineCoordinates(int length){
		
		MineCoordinates = new Coordinates[length];
		
	} 
	
	// Uses the Coordinates class to create coordinates with random numbers.
	
	private Coordinates CreateCoordinates() {
		
		Random generator = new Random();
		
		return new Coordinates(generator.nextInt(9), generator.nextInt(9));
		
	}
	
	// Fills up the MineCoordinates array with the use of the CreateCoordinates method.
	
	public void PopulateMineCoordinates() {
		
		for(int i=0; i < MineCoordinates.length; i++){

			MineCoordinates[i] = CreateCoordinates();
			
		}
		
	}
	

	
	// Method created to compare two different coordinates.
	
	public boolean CompareCoordinates(int x, int y, Coordinates b) {
		
		return x == b.getX() && y == b.getY();
				
	}	
	
	// Uses the CompareCoordinates method to compare the clicked grid coordinate with all the mines coordinates.
	
	MyMouseAdapter MouseAdapter;
	
	public boolean CompareSelection() { 
		
		MouseAdapter = new MyMouseAdapter();
		
		for(int i=0; i < MineCoordinates.length; i++){ // STUCK ON THIS METHOD!
			
			if(CompareCoordinates(MouseAdapter.getCompareX(), MouseAdapter.getCompareY(), MineCoordinates[i])){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	

}
