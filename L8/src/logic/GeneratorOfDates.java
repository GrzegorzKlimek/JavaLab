package logic;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class GeneratorOfDates {
	
	private LocalDate generateRandomDate() {
		Random r = new Random();
		Month month = Month.of(1 + r.nextInt(12));
		Year year =  Year.of(1900 + r.nextInt(117));
		int maxvalOfDay = month.length(year.isLeap());
		int day = 1 + r.nextInt(maxvalOfDay);
		
		return LocalDate.of(year.getValue(), month, day);
	}

	public List <LocalDate> generate (int numberOfDates) {
		List<LocalDate> result = new ArrayList<>(numberOfDates);
		
		for (int i = 0; i < numberOfDates; i++) {
			result.add(generateRandomDate());
		}
		return result;
	}

}
