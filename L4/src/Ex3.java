import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ex3 {
	
	private static int [] generatResult ()  {
		Random generator = new Random();
		int [] array = new int [3];
		for (int i = 0; i < 3; i++) {
			array[i] = generator.nextInt(9);
		} 
		return array;
	}
	
	private static boolean  doUserWantToStop () throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("If you want to end game pres 'y' if not press any anything else");
		String userDecision = input.readLine();
		return userDecision.equals("y");
			
	}
	
	private static String handleResult (int [] result) {
		
		int numOfRepetision = 0 ;
		for (int i = 0; i < 2; i++) {
			if (result[i] == result[i + 1]) {
				numOfRepetision ++;
			}
		}
		if (numOfRepetision == 1) {
			return "Two numbers in the row are the same";
		} else if (numOfRepetision == 2) {
			return "Three numbers are the same";
		} else {
			return null;
		}
		
	}

	
	static public void main (String [] args) throws IOException {
		
		do {
			int [] numbers = generatResult();
			for (int i = 0; i < 3; i++) {
				System.out.print(numbers[i] + " ");
			}
		
			String communicat = handleResult(numbers);
			if (communicat != null) {
				System.out.println(communicat);
			}
			System.out.println();
			
		} while (!doUserWantToStop());
		
	}

}
