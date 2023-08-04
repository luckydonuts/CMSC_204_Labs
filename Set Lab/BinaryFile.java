import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 
 * @author Michael Bushman
 *
 */
public class BinaryFile {

	public static void main(String[]args) throws IOException {
		createIntegerFile();
		readBinaryFile();
	}
	
	public static void createIntegerFile() throws IOException {
		//Variables
		int [] randomIntegers = new int [25000];
		DataOutputStream output = new DataOutputStream(new FileOutputStream("Binary.dat"));
		PrintWriter writer = new PrintWriter("Ascii.txt");
		//Generates 25,000 random integers between 1000 and 9999
		for (int i = 0; i < randomIntegers.length; i++) 
			randomIntegers[i] = (int) (Math.random()*(10000-1000)+1000);
		
		//Writes each integers into the binary and text files
		for (int i = 0; i < randomIntegers.length; i++) {
			output.writeInt(randomIntegers[i]);
			writer.println(randomIntegers[i]);
		}
		//Closes both files
		output.close();
		writer.close();
	}
	
	public static void readBinaryFile() throws IOException {
		//Variable
		DataInputStream input = null;
		
		try {
			//Opens the binary file
			input = new DataInputStream(new FileInputStream("Binary.dat"));
			//Reads each integer from the binary file
			while (true) {
				System.out.println(input.readInt());
			}
		}
		catch (EOFException error){
			error.printStackTrace();
		}
		//Closes binary file
		input.close();
	}
}
