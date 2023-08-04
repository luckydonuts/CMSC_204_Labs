import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * 
 * @author Michael Bushman
 *
 */
public class CarQueue {
	//variables
	Queue<Integer>direction;
	Random rand = new Random();
;
	//constructor that adds 5 or 6 directions 
	public CarQueue() {
		direction = new LinkedList<>();
		direction.add(0);
		direction.add(3);
		direction.add(1);
		direction.add(2);
		direction.add(3);
		direction.add(1);
		direction.add(0);
		direction.add(1);


	}
	
	public void addToQueue() {
		//implements Runnable
		class Run implements Runnable {
			@Override
			//implements run method
			public void run() {
				// TODO Auto-generated method stub
				try {
					//runs while true
					while (true) {
						//adds a random direction, either up, down, right or left
						direction.add(rand.nextInt(4));
						//sleeps the thread
						Thread.sleep(100);
					}
				}
				catch (Exception error) {
					error.printStackTrace(); 
				}
			}
		}
		//starts the thread
		Run run = new Run();
		Thread thread = new Thread(run);
		thread.start();
	}
	//returns the integer of the removed direction in queue
	public int deleteQueue() {
		return direction.remove();
	}
}
