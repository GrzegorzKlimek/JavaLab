import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {
	public static void main ( String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Podaj wpolrzedno x pierwszego punktu");
		double x1 = (double) Integer.parseInt(input.readLine());
		System.out.println("Podaj wpolrzedno y pierwszego punktu");
		double y1 = (double) Integer.parseInt(input.readLine());
		System.out.println("Podaj wpolrzedno x drugiego punktu");
		double x2 = (double) Integer.parseInt(input.readLine()); 
		System.out.println("Podaj wpolrzedno y drugiego punktu");
		double y2 = (double) Integer.parseInt(input.readLine());
		
		double distance = Math.pow ( Math.pow (x2 - x1, 2.0d ) + Math.pow( y2 - y1, 2.0d), 0.5d);
		System.out.println("Dystance between points is: " + distance);
		
		
	}
}
