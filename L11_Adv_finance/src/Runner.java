import java.io.IOException;

import logic.Accountant;
import model.FinaceReport;
import utilies.CSVparser;
import utilies.Converter;

public class Runner {
	public static void main (String [] args) throws IOException {
		
		CSVparser fileReader = new CSVparser();
		Converter converter = new Converter();
		
		String [] revenueText = fileReader.read("resources/dochod.txt");
		String [] costsText = fileReader.read("resources/wydatki.txt");
		
		double [] revenues = converter.convertTextIntoNumbers(revenueText);
		double [] costs = converter.convertTextIntoNumbers(costsText);
		
		Accountant accountant = new Accountant();
		
		FinaceReport report = accountant.generateFinanceReport(revenues, costs);
		
		System.out.println(report);
		
	}

}
