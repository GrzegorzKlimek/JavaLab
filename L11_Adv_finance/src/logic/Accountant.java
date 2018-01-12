package logic;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import model.FinaceReport;
import model.MonthlyFinances;

public class Accountant {
	
	public FinaceReport generateFinanceReport (double [] revenues, double [] costs) {
		
		FinaceReport report = new FinaceReport();
		List < MonthlyFinances> yearFinances = generateYearFinacesFromData(revenues, costs);
		report.setYearFinanceReport(yearFinances);
		report.setBestMonth(getBestMonth(yearFinances));
		report.setWorstMonth(getWorstMonth(yearFinances));
		report.setGoodMonths(getGoodMonths(yearFinances));
		report.setBadMonths(getBadMonths(yearFinances));
		
		return report;
	}
	
	private List < MonthlyFinances>  generateYearFinacesFromData (double [] revenues, double [] costs) {
		List < MonthlyFinances> yearFinances = new ArrayList<MonthlyFinances>();
		for (int i = 0; i < revenues.length; i++) {
			Month month = Month.of(i + 1);
			MonthlyFinances monthFinances = new MonthlyFinances(month, revenues[i], costs[i]);
			yearFinances.add( monthFinances);
		}
		return yearFinances;
	}
	
	
	private Month getBestMonth (List < MonthlyFinances> yearFinaces) {

		double bestIncome = Double.MIN_VALUE;
		Month bestMonth = null;
		
		for (MonthlyFinances monthReport : yearFinaces) {
			double monthIncome = monthReport.getIncome();
			if (monthIncome > bestIncome) {
				bestIncome = monthIncome;
				bestMonth = monthReport.getMonth();
			}
		}
		return bestMonth;
	}
	
	private Month getWorstMonth (List < MonthlyFinances> yearFinaces) {

		double worstIncome = Double.MAX_VALUE;
		Month worstMonth = null;
		
		for (MonthlyFinances monthReport : yearFinaces) {
			double monthIncome =  monthReport.getIncome();
			if (monthIncome < worstIncome) {
				worstIncome = monthIncome;
				worstMonth = monthReport.getMonth();
			}
		}
		return worstMonth;
	} 
	
	private double calcAverageIncome (List < MonthlyFinances> yearFinaces) {
		double totalIncome = 0.0;
		for (MonthlyFinances monthReport : yearFinaces) {
			totalIncome += monthReport.getIncome();
		}
		return totalIncome / yearFinaces.size();
	}
	
	public List<Month> getGoodMonths (List < MonthlyFinances> yearFinaces) {
		double averageIncome = calcAverageIncome(yearFinaces);
		
		List<Month> goodMonths = new ArrayList<Month>();
		
		for (MonthlyFinances monthReport : yearFinaces) {
			if( monthReport.getIncome() > averageIncome) {
				goodMonths.add(monthReport.getMonth());
			}
		}
		
		return goodMonths;
		
	}
	
	public List<Month> getBadMonths (List < MonthlyFinances> yearFinaces) {
		double averageIncome = calcAverageIncome(yearFinaces);
		
		List<Month> badMonths = new ArrayList<Month>();
		
		for (MonthlyFinances monthReport : yearFinaces) {
			if( monthReport.getIncome() < averageIncome) {
				badMonths.add(monthReport.getMonth());
			}
		}
		
		return badMonths;
		
	}

}
