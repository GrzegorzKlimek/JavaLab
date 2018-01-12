package model;

import java.time.Month;
import java.util.List;

public class FinaceReport {
	
		
	private List < MonthlyFinances> yearFinanceReport;
	
	private List<Month> goodMonths;
	
	private List<Month> badMonths;
	
	private Month bestMonth;
	
	private Month worstMonth;


	public List < MonthlyFinances> getYearFinanceReport() {
		return yearFinanceReport;
	}

	public void setYearFinanceReport(List < MonthlyFinances> yearFinanceReport) {
		this.yearFinanceReport = yearFinanceReport;
	}

	public List<Month> getGoodMonths() {
		return goodMonths;
	}

	public void setGoodMonths(List<Month> goodMonths) {
		this.goodMonths = goodMonths;
	}

	public List<Month> getBadMonths() {
		return badMonths;
	}

	public void setBadMonths(List<Month> badMonths) {
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
		String newLine = System.lineSeparator();
		
		sb.append("Best month was ").append(bestMonth).append(" ");
		sb.append("Worst month was ").append(worstMonth).append(newLine);
		sb.append("Good months were: ").append(goodMonths).append(newLine);
		sb.append("Bad months were: ").append(badMonths).append(newLine);
		

		
		for (MonthlyFinances monthReport : yearFinanceReport) {
			sb.append(newLine).append(monthReport).append(" ");
		}
		
		
		return sb.toString();
		
	}
	

}
