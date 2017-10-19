import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {
	public static void main ( String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Podaj ilosc monet 5 zlotowych");
		int pln5 = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 2 zlotowych");
		int pln2 = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 1 zlotowych");
		int pln1 = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 50 groszowych");
		int pln50gr = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 20 groszowych");
		int pln20gr = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 10 groszowych");
		int pln10gr = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 5 groszowych");
		int pln5gr = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 2 groszowych");
		int pln2gr = Integer.parseInt(input.readLine());
		System.out.println("Podaj ilosc monet 1 groszowych");
		int pln1gr = Integer.parseInt(input.readLine());
		
		int sum = pln5*500 + pln2*200 + pln1*100 + pln50gr*50 + pln20gr*20 + pln10gr*10 +  pln5gr*5 + pln2gr*2 + pln1gr;
		int zlotys = sum / 100;
		int grosze = sum % 100;
		System.out.println("kwota wynosi " + zlotys + " zlotych i " + grosze + " groszy");
	}

}
