import java.util.Random;

public class MineCoordinates {
	
	private Coordinates[] MineCoordinates;
	
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
	
	public boolean CompareSelection(int x, int y) { 
		
		for(int i=0; i < MineCoordinates.length; i++){ 
			
			if(CompareCoordinates(x, y, MineCoordinates[i])){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	// Checks if there's a mine nearby.
	
	public boolean MinesNearby(int x, int y) {
		
		 if(CompareSelection(x+1, y) || 
		   CompareSelection(x-1, y) ||
		   CompareSelection(x, y-1) ||
		   CompareSelection(x+1, y-1) ||
		   CompareSelection(x-1, y-1) ||
		   CompareSelection(x, y+1) ||
		   CompareSelection(x+1, y+1) ||
		   CompareSelection(x-1, y+1)){
			
			return true;
			
		} 
		
		 else return false;
		
	}

}
