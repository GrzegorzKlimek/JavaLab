package model;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import logic.Accountant;

public class FinaceReport {
	
		
	private List < MonthlyFinances> yearFinanceReport;
	
	private List<MonthlyFinances> goodMonths;
	
	private List<MonthlyFinances> badMonths;
	
	private Month bestMonth;
	
	private Month worstMonth;


	public List < MonthlyFinances> getYearFinanceReport() {
		return yearFinanceReport;
	}

	public void setYearFinanceReport(List < MonthlyFinances> yearFinanceReport) {
		this.yearFinanceReport = yearFinanceReport;
	}

	public List<MonthlyFinances> getGoodMonths() {
		return goodMonths;
	}

	public void setGoodMonths(List<MonthlyFinances> goodMonths) {
		this.goodMonths = goodMonths;
	}

	public List<MonthlyFinances> getBadMonths() {
		return badMonths;
	}

	public void setBadMonths(List<MonthlyFinances> badMonths) {
		this.badMonths = badMonths;
	}

	public Month getBestMonth() {
		return bestMonth;
	}

	public void setBestMonth(Month bestMonth) {
		this.bestMonth = bestMonth;
	}

	public Month getWorstMonth() {
		return worstMonth;
	}

	public void setWorstMonth(Month worstMonth) {
		this.worstMonth = worstMonth;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Best month was ").append(bestMonth).append(" ");
		sb.append("Worst month was ").append(worstMonth).append("  ");
		

		
		String newLine = System.lineSeparator();
		for (MonthlyFinances monthReport : yearFinanceReport) {
			sb.append(newLine).append(monthReport).append(" ");
		}
		
		
		return sb.toString();
		
	}
	

}
