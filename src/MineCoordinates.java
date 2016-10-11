import java.awt.Color;
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
	
	// Método para contar cuántas minas hay alrededor del click.
	
	public int MinesNearbyCounter(int x, int y){
		
		int counter = 0;
		
		for(int i = x-1; i <= x+1; i++){
			for(int j = y-1; j <= y+1; j++){
				
				// La conjunción de dos negaciones es la negación de una disjunción, fundamentos memories.
				
				if(!(i == x && j == y)){
				
					if(CompareSelection(i, j))
						counter++;
					
					}
				}
			}
		
		return counter;
		
	}
	
	// Recursión para pintar todos los grises cerca luego de clickear uno inicialmente.
	
	public void PaintAdjacent(int x, int y){
		
		if(x > 9 || y > 9 || x < 0 || y < 0){return;}
		
		if(CompareSelection(x, y)){return;}
		
		else {
			
			if(a[x][y] == Color.GRAY){return;}
			
			a[x][y] = Color.GRAY;
			PaintAdjacent(x+1, y);
			PaintAdjacent(x-1, y);
			PaintAdjacent(x, y+1);
			PaintAdjacent(x, y-1);
			
		}
		
	}
	

}
