package logic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ValidatorOfHipothesis {
	
	private boolean test(int numberOfDates) {
		GeneratorOfDates generator = new GeneratorOfDates();
		List <LocalDate> dates = generator.generate(numberOfDates);
		for (int i = 0; i < dates.size() - 1; i++ ) {
			for (int j = i + 1; j <  dates.size(); j++ ) {
				Month month1 = dates.get(i).getMonth();
				Month month2 = dates.get(j).getMonth();
				int day1 = dates.get(i).getDayOfMonth();
				int day2 = dates.get(j).getDayOfMonth();
				
				if (month1.equals(month2) &&  (day1 == day2) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	private double countPropability (int numberOfTests, int numberOfDates ) {
		
		double numberOfPositiveResult = 0;
		
		for (int i = 0; i < numberOfTests; i++ ) {
			if ( test(numberOfDates)) {
				numberOfPositiveResult ++;
			}
		}
		return numberOfPositiveResult/numberOfTests;
	}
	
	public boolean validate (int numberOfTests, int numberOfDates, double marginOfError, double assumemedPropapility) {
		return countPropability(numberOfTests, numberOfDates) >= assumemedPropapility - marginOfError ;
	}

}
