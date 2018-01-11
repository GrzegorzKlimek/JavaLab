import java.io.IOException;

import utilies.CSVparser;
import utilies.Converter;

public class Runner {
	public static void main (String [] args) throws IOException {
		
		CSVparser fileReader = new CSVparser();
		Converter converter = new Converter();
		
		String [] textData = fileReader.read("resources/dochod.txt");
		double [] numeric = converter.convertTextIntoNumbers(textData);
		
		for (int i = 0; i < numeric.length; i++) {
			System.out.println(numeric[i]);
		}
		
	}

}
