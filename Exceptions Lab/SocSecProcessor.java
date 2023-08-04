import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		String userName = "";
		String userSSN = "";
		String userReply = "";
		char charReply = 'y';
		
		while (charReply == 'y' || charReply == 'Y') {
			try {
				System.out.print("Name? ");
				userName = entry.nextLine();
				System.out.print("SSN? ");
				userSSN = entry.nextLine();
				
				if (isValid(userSSN)) 
					System.out.println(userName + " " + userSSN + " is valid");
			}
			
			catch (SocSecException e) {
				System.out.println(e.getMessage());
			}
			System.out.print("Continue? ");
			userReply = entry.nextLine();
			charReply = userReply.charAt(0);
		}
	}

	public static boolean isValid(String ssn) throws SocSecException {
		boolean validSSN = true;
		char charSSN;
		
		if (ssn.length() != 11) 
			throw new SocSecException("wrong number of characters");
		
		
		if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') 
			throw new SocSecException("dashes at wrong positions");
		
		for (int i = 0; i < ssn.length(); i++) {
			
			charSSN = ssn.charAt(i);
			if (Character.isLetter(charSSN))
				throw new SocSecException("contains a character that is not a digit");
		}
		return validSSN;
	}
}
