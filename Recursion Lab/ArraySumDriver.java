//Michael Bushman
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int index = 0;
		int number1 = 3;
		int number2 = 6;
		int number3 = 9;

		
		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
		System.out.println("fibonaccc(3) = " + fibonacci(number1));
		System.out.println("fibonacci(6) = " + fibonacci(number2));
		System.out.println("fibonacci(9) = " + fibonacci(number3));
		System.out.println("fibonacciDynamic(3) = " + fibonacciDynamic(number1));
		System.out.println("fibonacciDynamic(6) = " + fibonacciDynamic(number2));
		System.out.println("fibonacciDynamic(9) = " + fibonacciDynamic(number3));


	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static int sumOfArray(Integer[] arr, int num) {
		if (num < 0)
			return 0;
		
		return arr[num] + sumOfArray(arr, num-1);
	}
	
	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int fibonacciDynamic(int n){
		int value[] = new int [n+2];
		value[0] = 0;
		value[1] = 1;
		
		for (int i = 2; i <= n; i++) 
			value[i] = value[i-1] + value[i-2];
		
		return value[n];
	} 
}