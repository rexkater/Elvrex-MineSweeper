import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("Color Grid");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(350, 380);

		Panel Panel = new Panel();
		myFrame.add(Panel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

	myFrame.setVisible(true);
	
	}
}