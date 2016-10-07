import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	
	 private Random generator = new Random();
	 
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

	            Panel.repaint();
	            
	            break;
	            
	        case 3:        //Right mouse button
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
	            	
	            	
	            	
	            }
	              
	            break; 
	            
	        case 3:        //Right mouse button
	            break;
	            
	        default:    //Some other button (2 = Middle mouse button, etc.)
	            break;
	            
	        }
	    }

}
