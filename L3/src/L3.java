
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class L3 {
	
	 private void displayAlarm(int numOfLines) {
			for (int i = 0; i < numOfLines; i++) {
				System.out.println("Alarm!");
			}
	}
	
	private double average(int a, int b) {
		return (a + b)/2.0;
	}
	
	private double average(int a, int b, int c, int d) {
		return (a + b + c + d)/ 4.0;
	}
	
	private double average(int a, int b, int c) {
		return (a + b + c)/ 3.0;
	}
	
	static public void main (String [] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How mamy times alarm shoud by displayed?");
		try {
			int numOfLines = Integer.parseInt(input.readLine());
			while (numOfLines < 1) {
				System.out.println("wrong input. Number of lines cannot be lower than one");
				numOfLines = Integer.parseInt(input.readLine());
			}
			
			new L3().displayAlarm(numOfLines);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter 4 numbers");
		List <Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			int inputNum = Integer.parseInt(input.readLine());
			if (i == 0 && inputNum == 0 ) {
				return;
			}
			array.add(inputNum);
			
		}
		L3 calculator = new L3();
		System.out.println("average is of four number is: " + calculator.average (array.get(0), array.get(1), array.get(2), array.get(3) ) );
		System.out.println("averege of second, 3rd and 4th number is:  " + calculator.average(array.get(1), array.get(2), array.get(3)) );
		System.out.println("averege of first and 4th number is " + calculator.average(array.get(0), array.get(3)));
	}

}
