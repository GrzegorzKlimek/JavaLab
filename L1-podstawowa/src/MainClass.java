import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

	private static void zad1() {
		System.out.println("Podaj kojeno 3 liczby aby wyliczyc srednia");
		float sum = 0;
		try {
			
			for (int i = 0; i < 3; i++) {
				BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
				int in = Integer.parseInt( wejscie.readLine());
				float inF = (float) in;

				sum += inF;
			}
			
			System.out.println(sum/3);
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
		
	} 
	
	private static void zad2() throws NumberFormatException, IOException {
		System.out.println("Podaj odleglosc w milach");
		BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
		float inF = (float) Integer.parseInt( wejscie.readLine());
		System.out.println(inF * 1.67f);
	} 
	
	public static void zad3() {
		System.out.println("Podaj liczbe sekund");
		BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
		int in = 0;
		try {
			 in = Integer.parseInt( wejscie.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		int hours = in/3600;
		int minutes = (in - hours*3600)/60;
		int seconds = in - (hours*3600 + minutes*60);
		
		System.out.println(hours + " : " + minutes + " : " + seconds);
		
	}
	
	private static void zad4() {
		BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Podaj poczatkowa wartosc licznika");
		int pocz = 0;
		int kon = 0;
		float benzyna = 0;
		try {
			 pocz = Integer.parseInt( wejscie.readLine());
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Podaj koncowa wartosc licznika");
		try {
			 kon = Integer.parseInt(wejscie.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Podaj ilosc zuzytej benzyny");
		try {
			benzyna = (float) Integer.parseInt( wejscie.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float spalaenieNa1Kilometr = benzyna / (float) (kon - pocz) ;
		System.out.println("Spalenie auto wynosi " + spalaenieNa1Kilometr*100 + " litrow paliwa na 100 km");
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		zad1();
		zad2();
		zad3();
		zad4();
	}
}
