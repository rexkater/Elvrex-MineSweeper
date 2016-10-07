import java.util.Random;

public class MineCoordinates {
	
	private Coordinates[] MineCoordinates;
	
	public MineCoordinates(int length){
		
		MineCoordinates = new Coordinates[length];
		
	}
	
	private Coordinates CreateCoordinates() {
		
		Random generator = new Random();
		
		return new Coordinates(generator.nextInt(9), generator.nextInt(9));
		
	}
	
	public void PopulateMineCoordinates() {
		
		for(int i=0; i < MineCoordinates.length; i++){
			
			MineCoordinates[i] = CreateCoordinates();
			
		}
		
	}
	
	public boolean CompareCoordinates(int x, int y, Coordinates b) {
		
		return x == b.getX() && y == b.getY();
				
	}
	
	public void CompareSelection() {
		
		
		
		for(int i=0; i < MineCoordinates.length; i++){

		//	CompareCoordinates(, , MineCoordinates[i]);
			
		}
		
	}

}
