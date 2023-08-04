import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	
	/**
	 * 
	 * @author Michael Bushman
	 *
	 */
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	            	while (true) {
	            		//gets the current direction in queue
	            		direction = carQueue.deleteQueue();
	            		//switch case based on the direction number
	            		switch (direction) {
	            		//up direction
	            		case 0:
	            			//increase y by 20
	            			y = y + 20;
	            			//checks if the y is at its max boundaries
	            			if (y > 400)
	            				//resets the y to 380
	            				y = 380;
	            			break;
	            		//down direction
	            		case 1:
	            			//decreases y by 20
	            			y = y - 20;
	            			//checks if the y is at its min boundaries
	            			if (y < 0)
	            				//resets the y to 20
	            				y = 20;
	            			break;
	            		//right direction
	            		case 2:
	            			x = x + 20;
	            			//checks if the x is at its max boundaries
	            			if (x > 300)
	            				//resets the x is 280
	            				x = 280;
	            			break;
	            		//left direction
	            		case 3:
	            			x = x - 20;
	            			//checks if the x is at its min boundaries
	            			if (x < 0)
	            				//resets the x to 20
	            				x = 20;
	            			break;
	            		
	            	}
	               repaint();
	               //sets the speed to match the other cars
	               Thread.sleep(delay * 1000);
	               
	            	}
	            }
	            catch (InterruptedException exception) {
	            	exception.printStackTrace();
	            }
	            finally {}
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}
