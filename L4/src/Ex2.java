import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {
	
	static boolean  isleapYear (int num)  {
		boolean firstCondition = num % 100 != 0 ? true : false;
		boolean secondCondition = num % 4 == 0 ? true : false;
		boolean thirdCondition = num % 400 == 0 ? true : false;
		
		return (firstCondition && secondCondition) || thirdCondition;
		
	}
	 static boolean isUserInputValid (int input) {
		return input >= 1582 ? true : false;
	}
	
	public static void main (String args []) throws NumberFormatException, IOException {
		System.out.println("Give number");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(input.readLine());
		while (!isUserInputValid(year)) {
			System.out.println("Wrong input. Give year bigger than 1581");
			year = Integer.parseInt( input.readLine());
		}
		if (isleapYear(year)) {
			System.out.println("Given year is leap year");
		} else {
			System.out.println("Given number is not leap year");
		}
		
	}

}
