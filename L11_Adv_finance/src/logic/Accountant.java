package logic;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.FinaceReport;
import model.MonthlyFinances;

public class Accountant {
	
	public FinaceReport generateFinanceReport (double [] revenues, double [] costs) {
		
		FinaceReport report = new FinaceReport();
		Map <Month, MonthlyFinances> yearFinances = generateYearFinacesFromData(revenues, costs);
		report.setYearFinanceReport(yearFinances);
		report.setBestMonth(getBestMonth(yearFinances));
		report.setWorstMonth(getWorstMonth(yearFinances));
		
		return report;
	}
	
	private Map <Month, MonthlyFinances>  generateYearFinacesFromData (double [] revenues, double [] costs) {
		Map <Month, MonthlyFinances> yearFinances = new HashMap<Month, MonthlyFinances>();
		for (int i = 0; i < revenues.length; i++) {
			Month month = Month.of(i + 1);
			MonthlyFinances monthFinances = new MonthlyFinances(month, revenues[i], costs[i]);
			yearFinances.put(Month.of(i + 1), monthFinances);
		}
		return yearFinances;
	}
	
	
	private Month getBestMonth (Map <Month, MonthlyFinances> yearFinaces) {
		Set< Map.Entry<Month, MonthlyFinances>> monthsEntries = yearFinaces.entrySet();
		double bestIncome = Double.MIN_VALUE;
		Month bestMonth = null;
		
		for (Entry<Month, MonthlyFinances> entry : monthsEntries) {
			double monthIncome = entry.getValue().getIncome();
			if (monthIncome > bestIncome) {
				bestIncome = monthIncome;
				bestMonth = entry.getKey();
			}
		}
		return bestMonth;
	}
	
	private Month getWorstMonth (Map <Month, MonthlyFinances> yearFinaces) {
		Set< Map.Entry<Month, MonthlyFinances>> monthsEntries = yearFinaces.entrySet();
		double worstIncome = Double.MAX_VALUE;
		Month worstMonth = null;
		
		for (Entry<Month, MonthlyFinances> entry : monthsEntries) {
			double monthIncome = entry.getValue().getIncome();
			if (monthIncome < worstIncome) {
				worstIncome = monthIncome;
				worstMonth = entry.getKey();
			}
		}
		return worstMonth;
	} 

}
