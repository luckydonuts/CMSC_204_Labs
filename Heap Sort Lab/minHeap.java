import java.util.Arrays;
/**
 * 
 * @author Michael Bushman
 *
 */
public class minHeap {

	public static void main(String[]args) {
		int[] array = {3, 6, 33, 9, 74, 40, 99};
		int length = array.length;
		heapSort(array, length);
		System.out.println(Arrays.toString(array));
	}
	
	public static void heapify (int[]array, int length, int i) {
		int left = 2 * i + 1;
		int right  = 2 * i + 2;
		int largest = i;
		
		if (left < length && array[left] > array[largest])
			largest = left;
		
		if (right < length && array[left] > array[largest])
			largest = right;
		
		if (largest != i) {
			int temporary = array[i];
			array[i] = array[largest];
			array[largest] = temporary;
			heapify(array, length, largest);
		}
	}
	
	public static void heapSort(int[]array, int length) {
		if (length == 0)
			return;
		
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(array, length, i);
		}
		
		for (int i = length-1; i >=0; i--) {
			int temporary = array[0];
			array[0] = array[i];
			array[i] = temporary;
			heapify(array, i, 0);
		}
	}
}
