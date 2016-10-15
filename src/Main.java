import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("Elvrex Mine Sweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(325, 350);

		Panel Panel = new Panel();
		myFrame.add(Panel);
		
		// Fills the Mines array with 10 objects from the Coordinates class.

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);
		myMouseAdapter.MinesArray();

	myFrame.setVisible(true);
	
	}
}