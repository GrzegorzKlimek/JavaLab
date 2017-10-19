import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5 {
	public static void main ( String[] args) throws NumberFormatException, IOException {
		System.out.println("Podaj liczbe calkowita wieksza od dwa");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(input.readLine());
		if (num < 2) {
			System.out.println("zla liczba");
		} else {
			int acc = 0;
			for (int i = 2; i <= num; i++) {
				if (i % 2 == 0) {
					acc += i;
				}
			}
			System.out.println("suma licz parzystych wynosi " + acc);
		}
	}

}
