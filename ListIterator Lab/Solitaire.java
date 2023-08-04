import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
/**
 * @author Michael Bushman
 */
public class Solitaire {
	//Stimulates a Solitaire game
	public static void main(String[]args) {
		ArrayList<Integer>solitaireList =  new ArrayList<Integer>();
		createGame(solitaireList);
		display(solitaireList);
		sameDigits(solitaireList);
	}
	//Creates the ArrayList of 12 random integers between 10 and 99
	public static void createGame(ArrayList<Integer>solitaireList) {
		
		Random random = new Random();
		int randomNumber = 0;

		for (int i = 0; i < 12; i++) {
			randomNumber = random.nextInt(100-10)+10;
			solitaireList.add(randomNumber);
		}
	}
	//Displays the beginning set of integers
		public static void display(ArrayList<Integer>solitaireList) {
			
			ListIterator<Integer>solitareIterator = solitaireList.listIterator();
			System.out.println("Before Game: ");

			while(solitareIterator.hasNext()) {
				System.out.print(solitareIterator.next() + " ");
			}
			System.out.println();
		}
	//Checks if two integers have equal pairs and removes them from the ListIterator
	public static void sameDigits(ArrayList<Integer>solitaireList) {
		ListIterator<Integer>solitareIterator = solitaireList.listIterator();
		int firstNumber = 0;
		int secondNumber = 0;
		
		while(solitareIterator.hasNext()) {
			firstNumber = solitareIterator.next();
				
			if(!solitareIterator.hasNext()) 
				break;
				
			secondNumber = solitareIterator.next();
			if(removable(firstNumber, secondNumber)) {
				solitareIterator.remove();
				solitareIterator.previous();
				solitareIterator.remove();
			}
		}
		System.out.println();
		System.out.println("After Game: ");
		display(solitaireList);
		
		if (solitaireList.size() == 0)
			System.out.print("Congrats, You Won!");
	}
	//Checks if the first and second digits of the two integer pairs are the same
	public static boolean removable(Integer firstNumber, Integer secondNumber) {
		if (firstNumber/10 == secondNumber/10 || firstNumber%10 == secondNumber%10)
			return true;
		else 
			return false;
	}
}
