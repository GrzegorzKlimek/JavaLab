import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zd1 {
	
	public static void main ( String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Insert two numbers");
			float a = (float) Integer.parseInt(input.readLine());
			float b =  (float) Integer.parseInt(input.readLine());
			float sum = a + b;
			float dif = a - b;
			float mul = a * b;
			float div = a / b;
			System.out.println("sum of numbers is: " + sum);
			System.out.println("diffrence of numbers is: "+ dif );
			System.out.println("Mulitiplication of numbers is: " + mul);
			System.out.println("Devision of numbers is: " + div);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
