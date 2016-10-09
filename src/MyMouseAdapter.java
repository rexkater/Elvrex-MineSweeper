//import java.awt.Color;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Random;

//import java.util.Random;
import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	
	// private Random generator = new Random();
	   public int compareX;
	   public int compareY;
	   private MineCoordinates Mines;
	 
	    public void mousePressed(MouseEvent e) {
	        
	        switch (e.getButton()) {
	        
	        case 1:        //Left mouse button
	            Component c = e.getComponent();
	            while (!(c instanceof JFrame)) {
	                c = c.getParent();
	                if (c == null) {
	                    return;
	                }
	            }
	        	
	            JFrame myFrame = (JFrame) c;
	            Panel Panel = (Panel) myFrame.getContentPane().getComponent(0);
	            Insets myInsets = myFrame.getInsets();
	            int x1 = myInsets.left;
	            int y1 = myInsets.top;
	            e.translatePoint(-x1, -y1);
	            int x = e.getX();
	            int y = e.getY();
	            Panel.x = x;
	            Panel.y = y;
	            Panel.mouseDownGridX = Panel.getGridX(x, y);
	            Panel.mouseDownGridY = Panel.getGridY(x, y);
	            
	            compareX = Panel.mouseDownGridX;
	            compareY = Panel.mouseDownGridY;

	            Panel.repaint();
	            
	            break;
	            
	        case 3:        //Right mouse button
	        	
	            Component d = e.getComponent();
	            while (!(d instanceof JFrame)) {
	                d = d.getParent();
	                if (d == null) {
	                    return;
	                }
	            }
	        	
	            JFrame myFrame2 = (JFrame) d;
	            Panel Panel2 = (Panel) myFrame2.getContentPane().getComponent(0);
	            Insets myInsets2 = myFrame2.getInsets();
	            int x3 = myInsets2.left;
	            int y3 = myInsets2.top;
	            e.translatePoint(-x3, -y3);
	            int x2 = e.getX();
	            int y2 = e.getY();
	            Panel2.x = x2;
	            Panel2.y = y2;
	            Panel2.mouseDownGridX = Panel2.getGridX(x2, y2);
	            Panel2.mouseDownGridY = Panel2.getGridY(x2, y2);
	            
	            compareX = Panel2.mouseDownGridX;
	            compareY = Panel2.mouseDownGridY;

	            Panel2.repaint();
	        	
	            break;
	            
	        default:    //Some other button (2 = Middle mouse button, etc.)
	            break;
	            
	        }
	    }
	    
	    public void mouseReleased(MouseEvent e) {
	    	
	        switch (e.getButton()) {
	        
	        case 1:        //Left mouse button
	            Component c = e.getComponent();
	            while (!(c instanceof JFrame)) {
	                c = c.getParent();
	                if (c == null) {
	                    return;
	                }
	            }
	           
	            JFrame myFrame = (JFrame)c;
	            Panel Panel = (Panel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
	            Insets myInsets = myFrame.getInsets();
	            int x1 = myInsets.left;
	            int y1 = myInsets.top;
	            e.translatePoint(-x1, -y1);
	            int x = e.getX();
	            int y = e.getY();
	            Panel.x = x;
	            Panel.y = y;
	            int gridX = Panel.getGridX(x, y);
	            int gridY = Panel.getGridY(x, y);
	            
	            if(gridX > 0 && gridX < 8 && gridY > 0 && gridY < 8){
	            	
	            	Mines = new MineCoordinates(10);
	            	Mines.PopulateMineCoordinates();
	            	
	            	if(Mines.CompareSelection()){
	            		
	            		Color newColor = Color.BLACK;
	            		Panel.colorArray[gridX][gridY] = newColor;
		            	Panel.repaint();
	            		
	            	}
	            	
	            }
	              
	            break; 
	            
	        case 3:        //Right mouse button
	        	
	        	 Component c2 = e.getComponent();
		            while (!(c2 instanceof JFrame)) {
		                c2 = c2.getParent();
		                if (c2 == null) {
		                    return;
		                }
		            }
		        	
		            JFrame myFrame2 = (JFrame) c2;
		            Panel Panel2 = (Panel) myFrame2.getContentPane().getComponent(0);
		            Insets myInsets2 = myFrame2.getInsets();
		            int x3 = myInsets2.left;
		            int y3 = myInsets2.top;
		            e.translatePoint(-x3, -y3);
		            int x2 = e.getX();
		            int y2 = e.getY();
		            Panel2.x = x2;
		            Panel2.y = y2;
		            Panel2.mouseDownGridX = Panel2.getGridX(x2, y2);
		            Panel2.mouseDownGridY = Panel2.getGridY(x2, y2);
		            int gridX2 = Panel2.getGridX(x2, y2);
		            int gridY2 = Panel2.getGridY(x2, y2);
		            
		            compareX = Panel2.mouseDownGridX;
		            compareY = Panel2.mouseDownGridY;

		            Panel2.repaint();
		            
		            if(gridX2 > 0 && gridX2 < 8 && gridY2 > 0 && gridY2 < 8){
		            	
		            	Mines = new MineCoordinates(10);
		            	Mines.PopulateMineCoordinates();
		            	
		            	if(Mines.CompareSelection()){
		            		
		            		Color newColor = Color.RED;
		            		Panel2.colorArray[gridX2][gridY2] = newColor;
			            	Panel2.repaint();
		            		
		            	}
		            	
		            }
	        	
	            break;
	            
	        default:    //Some other button (2 = Middle mouse button, etc.)
	            break;
	            
	        }
	    }
	    
		public int getCompareX() {
			return compareX;
		}

		public int getCompareY() {
			return compareY;
		}

}
